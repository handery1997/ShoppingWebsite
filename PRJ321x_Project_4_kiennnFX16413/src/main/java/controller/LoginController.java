package controller;

import java.util.List;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import dao.AccountDAO;
import model.Account;

@Controller
public class LoginController {
	@GetMapping("/login.html")
	public String getLogin() {
		return "login";
	}
	
	@GetMapping("/home.html")
	public String getHome() {
		return "home";
	}
@RequestMapping(value="/login.html", method = RequestMethod.POST)
public ModelAndView login(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String userName=request.getParameter("username");
		String passWord=request.getParameter("password");
		List<Account> ls = new AccountDAO().dbAccount();
		boolean isLogin = false;
		if(userName==null && passWord==null) {
			return new ModelAndView("login","error","Username or password is invalid");
		}
		for(Account p:ls) {
		String uid = p.getUsr();
		String pwd = p.getPwd();
		if(userName!=null && passWord!=null) {
			if(userName.equalsIgnoreCase(uid) && passWord.equals(pwd)) {
				return new ModelAndView("home","username",userName);
				
			}
		}		
	}
		return new ModelAndView("login","error","Please enter username and password");
	}
}
