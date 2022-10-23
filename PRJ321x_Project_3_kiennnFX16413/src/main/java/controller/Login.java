package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Account;
import dao.AccountDAO;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
        // TODO Auto-generated constructor stub
    }
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("utf-8");
		try {
			String remember = request.getParameter("remember");
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
			boolean isLogin = false;
			for(Account p:ls) {
			String uid = p.getUsr();
			String pwd = p.getPwd();
			if(userID!=null && acc.getPwd().equals(pwd) && acc.getName().equalsIgnoreCase(uid)) {
				isLogin=true;
				//set session
				session.setAttribute("user", userID);
				session.setAttribute("isLogin", isLogin);
				//Save cookie
				Cookie cookieRem = new Cookie("cookRem",remember);
				response.addCookie(cookieRem);
				Cookie cookieUser = new Cookie("cookUser",userID);
				response.addCookie(cookieUser);
				//login is valid, now redirect to index page
				response.sendRedirect("home2.jsp");
				} 
			}
			if(isLogin==false) {
				session.setAttribute("error", "wrong username and password");
				response.sendRedirect("login.jsp");
			}
			
		} catch (NullPointerException e) {
			RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
			rd.forward(request, response);
		} catch(Exception ex) {
			response.getWriter().println(ex);
		}
	
	}

}
