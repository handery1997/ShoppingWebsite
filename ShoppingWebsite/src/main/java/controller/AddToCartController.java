package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.ListProductDAO;
import model.Cart;
import model.Product;
@WebServlet("/AddToCartController")
public class AddToCartController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		response.setCharacterEncoding("utf-8");
		try {
			HttpSession session = request.getSession(true);
			String idd = request.getParameter("idd");
			String action = request.getParameter("action");
			if(action !=null&& action.equalsIgnoreCase("add")) {
				if(session.getAttribute("cart")==null) {
					session.setAttribute("cart", new Cart());
				}
				int id = Integer.parseInt(idd);
				Product p = new ListProductDAO().getProducts(id);
				Cart c = (Cart) session.getAttribute("cart");
				c.add(p);
				session.setAttribute("cart", c);
				List<Product> ls = c.getItems();
				session.setAttribute("cartItems", ls);
				
				
			}else if (action!=null&&action.equalsIgnoreCase("delete")) {
				int id = Integer.parseInt(idd);
				Cart c = (Cart) session.getAttribute("cart");
				c.remove(id);
				session.setAttribute("cart", c);
				List<Product> ls = c.getItems();
				session.setAttribute("cartItems", ls);
				
			}
			RequestDispatcher rd = request.getRequestDispatcher("cart.jsp");
			rd.forward(request, response);
		} catch (Exception ex) {
			response.getWriter().println(ex);
		}
	}
}























