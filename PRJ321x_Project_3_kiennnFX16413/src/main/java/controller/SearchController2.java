package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ListProductDAO;

/**
 * Servlet implementation class SearchController2
 */
@WebServlet("/SearchController2")
public class SearchController2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		response.setCharacterEncoding("utf-8");
		try {
			String text = request.getParameter("s");
			request.setAttribute("results", new ListProductDAO().search(text));
			RequestDispatcher rd = request.getRequestDispatcher("search.jsp");
			rd.forward(request, response);
		}catch (Exception ex) {
			response.getWriter().println(ex);
			ex.printStackTrace();
		}
	}

}








