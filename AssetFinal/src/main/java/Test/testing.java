package Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

import com.mysql.cj.xdevapi.Statement;

import dao.DBUtil;

public class testing {

	public static void main(String[] args) {
    
		Connection con = DBUtil.getMyConnection();
		System.out.println(con);
		
		String url="jdbc:mysql://localhost:3306/AssetManagement";
		String username="root";
		String password="root";
		DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
		//DriverManager.registerDriver(new com.mysql.jdbc.Driver());
		con=DriverManager.getConnection(url,username,password);
		con.setAutoCommit(false);
		
		
		//conn("Insert into Asset2( assetName,assetType,assetDescription) values(?,?,?)");
		/*java.sql.Statement stmt=con.createStatement();
	     String query="SELECT * FROM asset";
	     ResultSet rs=stmt.executeQuery(query);
	     while(rs.next())
	     {
	          System.out.print(rs.getString("CUST_NAME") +" ");
	          System.out.print(rs.getString(2) +" ");
	          System.out.print(rs.getString(3) +" ");

	     } */   
	}
}
