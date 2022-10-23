package context;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DBContext {
	public Connection getConnection() throws Exception{
	String connectionUrl = "jdbc:sqlserver://localhost:1433;databaseName=ShoppingDB;encrypt=true;trustServerCertificate=true;integratedSecurity=true;";
	Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
	return DriverManager.getConnection(connectionUrl);
	}
}
