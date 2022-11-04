package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import context.DBContext;
import model.Product;

public class ListProductDAO {
	public List<Product> search (String character)throws Exception{
		DBContext dbc = new DBContext();
		Connection db = dbc.getConnection();
		PreparedStatement prs = db.prepareStatement("select * from products where product_name like ?");
		prs.setString(1, "%"+character+"%");
		ResultSet exc=prs.executeQuery();
		List <Product> a = new ArrayList<Product>();
		while (exc.next()) {
			a.add(new Product(exc.getInt("product_id"),exc.getString("product_name"),exc.getString("product_des"),exc.getFloat("product_price"),exc.getString("product_img_source"),exc.getString("product_type"),exc.getString("product_brand"),1));
		}
		return a;
		
	}
	public Product getProducts (int id) throws Exception{
		DBContext dbc = new DBContext();
		Connection db = dbc.getConnection();
		PreparedStatement prs = db.prepareStatement("select * from products where product_id=?");
		prs.setInt(1, id);
		ResultSet exc=prs.executeQuery();
		Product a = new Product();
		while (exc.next()) {
			a = new Product(exc.getInt("product_id"),exc.getString("product_name"),exc.getString("product_des"),exc.getFloat("product_price"),exc.getString("product_img_source"),exc.getString("product_type"),exc.getString("product_brand"),1);
		}
		return a;
		
	}
}
