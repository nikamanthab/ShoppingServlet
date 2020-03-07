package BuyServlet.Model;
import java.util.*;
import java.sql.*;

public class BuyModel{
	public int calculateTotal(String milk, String popcorn){
		try
		{
			 return Integer.parseInt(milk)*25 + Integer.parseInt(popcorn)*50;
		}
		catch(Exception e)
		{
		System.out.println(e);
		return 0;
		}
	}
}