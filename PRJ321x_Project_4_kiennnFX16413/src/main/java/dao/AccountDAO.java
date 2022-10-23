package dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import context.DBContext;
import model.Account;
import model.Product;
public class AccountDAO {
	public List<Account> dbAccount ()throws Exception{
		DBContext dbc = new DBContext();
		Connection db = dbc.getConnection();
		PreparedStatement prs = db.prepareStatement("select * from account");
		ResultSet exc=prs.executeQuery();
		List <Account> a = new ArrayList<Account>();
		while (exc.next()) {
			a.add(new Account(exc.getString("user_mail"),exc.getString("password")));
		}
		return a;
}
}
