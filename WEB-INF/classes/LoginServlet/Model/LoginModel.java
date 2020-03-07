package LoginServlet.Model;
import java.util.*;
import java.sql.*;

public class LoginModel{
	public boolean validate(String name, String password){
		try
		{
		Class.forName("com.mysql.jdbc.Driver").newInstance();
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/nitindb?autoReconnect=true&useSSL=false","root","root");
		Statement st = con.createStatement();
		String sql = "select * from users where name = \'"+name+"\' and password = \'"+password+"\'";
		ResultSet rs = st.executeQuery(sql);
		if(rs.next())
		{
		return true;
		 }
		else {
			return false;
		     }
		}
		catch(Exception e)
		{
		System.out.println(e);
		return false;
		}
	}
}