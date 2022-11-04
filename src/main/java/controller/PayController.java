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

import dao.OrdersDAO;
import model.Cart;
import model.Orders;
import model.Product;

/**
 * Servlet implementation class PayController
 */
@WebServlet("/PayController")
public class PayController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		response.setCharacterEncoding("utf-8");
		try {

			HttpSession session = request.getSession(true);
			String action = request.getParameter("action");
			if (action!=null&&action.equalsIgnoreCase("Pay")){
			if (session.getAttribute("cart")==null) {
				session.setAttribute("cartError", "No item!");
				response.sendRedirect("cart.jsp");
			}
			else if(session.getAttribute("isLogin")==null){
				session.setAttribute("cartError", "Please login before order!");
				response.sendRedirect("cart.jsp");
			}
			else {
			OrdersDAO dao = new OrdersDAO();
			List<Product> c = (List<Product>) session.getAttribute("cartItems");
			int flag= (int)session.getAttribute("flag");
			for (int i = 0; i<flag; i++) {
				String am =request.getParameter("amount"+i);
				c.get(i).setNumber(Integer.parseInt(am));
			}
			String userName = (String) session.getAttribute("user");
			Orders d = new Orders(userName, 2, "", "","",null);
			for(Product p:c) {
				dao.insertOrder(d, p);
			}
			session.setAttribute("cart", null);
			session.setAttribute("cartItems", null);
			session.setAttribute("cartError", "Order success!");
			response.sendRedirect("cart.jsp");
			}
			} 
			int flag= (int)session.getAttribute("flag");
			String action2;
			for (int i = 0; i<flag; i++) {
				action2=request.getParameter("action"+i);
			if (action2!=null&&action2.equalsIgnoreCase("Delete")) {
				String idd = request.getParameter("idd"+i);
				int id = Integer.parseInt(idd);
				Cart c = (Cart) session.getAttribute("cart");
				c.remove(id);
				session.setAttribute("cart", c);
				List<Product> ls = c.getItems();
				session.setAttribute("cartItems", ls);
				RequestDispatcher rd = request.getRequestDispatcher("cart.jsp");
				rd.forward(request, response);
			}
			}
			
		}catch (Exception ex) {
			response.getWriter().println(ex);
			ex.printStackTrace();
		}
	}
	

}




















