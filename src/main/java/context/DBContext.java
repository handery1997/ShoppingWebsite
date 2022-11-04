package context;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class DBContext {
	public Connection getConnection() throws Exception{
	String connectionUrl = "jdbc:postgresql://ec2-44-199-22-207.compute-1.amazonaws.com/d83u6iushgd5e";
	String user = "faedgwhpubkcat";
	String password = "2ec2d61e09628fb34486488cdd382e64b14a2d7541cad777b064d20b4599eec0";
	Class.forName("org.postgresql.Driver");
	return DriverManager.getConnection(connectionUrl,user,password);
	}
}



































