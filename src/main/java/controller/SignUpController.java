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

import dao.AccountDAO;
import dao.SignUpDAO;
import model.Account;

/**
 * Servlet implementation class SignUpController
 */
@WebServlet("/SignUpController")
public class SignUpController extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("utf-8");
		try {
			request.getSession(true).invalidate();
			//Make sure that email is valid
			String regexMail = "^[A-Z0-9_a-z]+@[A-Z0-9\\.a-z]+\\.[A-Za-z]{2,6}$";
			String regex ="[a-zA-Z0-9_!@#$%^&*]+";
			//Collect data from a login form
			String userID = request.getParameter("username");
			String password = request.getParameter("password");
			Account acc = new Account();
			acc.setName(userID);
			acc.setPwd(password);
			HttpSession session = request.getSession(true);
			if(!password.matches(regex)|| !userID.matches(regexMail)) {
				session.setAttribute("error", "invalid syntax");
				response.sendRedirect("login.jsp");
			}
			List<Account> ls = new AccountDAO().dbAccount();
			boolean isSignUp = true;
			for(Account p:ls) {
			String uid = p.getUsr();
			String pwd = p.getPwd();
			if(userID!=null && acc.getPwd().equals(pwd) && acc.getName().equalsIgnoreCase(uid)) {
				session.setAttribute("error", "The account already exist!");
				response.sendRedirect("signUp.jsp");
				isSignUp = false;
				return;
				} 
			}
			if(isSignUp==true) {
				SignUpDAO su = new SignUpDAO();
				su.addToDb(userID, password);
				session.setAttribute("anou", "Sign up successfull please login!");
				response.sendRedirect("login.jsp");
			}
			
		} catch (NullPointerException e) {
			RequestDispatcher rd = request.getRequestDispatcher("signUp.jsp");
			rd.forward(request, response);
		} catch(Exception ex) {
			response.getWriter().println(ex);
		}
		
	}

}
