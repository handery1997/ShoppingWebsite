package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import context.DBContext;

import model.Orders;
import model.Product;

public class OrdersDAO {
	public void insertOrder(Orders o, Product c)throws Exception{
		DBContext dbc = new DBContext();
		Connection db = dbc.getConnection();
		PreparedStatement prs = db.prepareStatement("insert into orders(user_mail, order_status, order_date, order_discount_code, order_address) values (?,2,'','','')");
		prs.setString(1, o.getUserMail());
		prs.executeUpdate();
		PreparedStatement prs2 = db.prepareStatement("select max(order_id) from orders");
		prs2.executeQuery();
		ResultSet exc=prs2.getResultSet();
		int maxID=0;
		while (exc.next()){
			  maxID = exc.getInt(1);
			}
		PreparedStatement prs3 = db.prepareStatement("insert into orders_detail values (?,?,?,?)");
		prs3.setInt(1, maxID);
		prs3.setInt(2, c.getId());
		prs3.setInt(3, c.getNumber());
		prs3.setInt(4, (int)c.getPrice());
		prs3.executeUpdate();
	}
}
