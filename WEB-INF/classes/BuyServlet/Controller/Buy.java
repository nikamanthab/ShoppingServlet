package BuyServlet.Controller;
import BuyServlet.Model.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.http.HttpServlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.*;
import java.sql.*;

public class Buy extends HttpServlet
{
	public void doGet(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException
	{
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		String milk = "0";
		String popcorn = "0";
		if(request.getParameter("milk")!= null)
			milk=request.getParameter("milk");
		if(request.getParameter("popcorn")!=null)
			popcorn=request.getParameter("popcorn");
		// out.println("hi there...")
		try{
			BuyModel buy = new BuyModel();
			int total = 0;
			total = buy.calculateTotal(milk, popcorn);
			// int total=0;
			request.setAttribute("milk",milk);
			request.setAttribute("popcorn",popcorn);
			request.setAttribute("totalamount",Integer.toString(total));
			RequestDispatcher view=request.getRequestDispatcher("/results.jsp");
			view.forward(request,response);
		}
		catch(Exception e){
		}
	}
}