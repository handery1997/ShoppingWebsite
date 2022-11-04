package dao;
import java.sql.Connection;
import java.sql.PreparedStatement;

import context.DBContext;

public class SignUpDAO {
	public void addToDb (String userName,String password) throws Exception {
		DBContext dbc = new DBContext();
		Connection db = dbc.getConnection();
		PreparedStatement prs = db.prepareStatement("insert into account values (?,?,1,?,'None',0)");
		prs.setString(1, userName);
		prs.setString(2, password);
		prs.setString(3, userName);
		prs.executeUpdate();
	}
}
