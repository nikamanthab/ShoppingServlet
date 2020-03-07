package LoginServlet.Controller;
import LoginServlet.Model.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.http.HttpServlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.*;
import java.sql.*;



public class Login extends HttpServlet
{
	public void doPost(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException
	{
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		String name=request.getParameter("user");
		String password=request.getParameter("password");
		LoginModel login = new LoginModel();
		boolean val = login.validate(name, password);
		try{
			if(val){
				HttpSession session = request.getSession();
				if(session.isNew()){
					request.setAttribute("user",name);
				}
				else{request.setAttribute("user","back "+name);}
				RequestDispatcher view=request.getRequestDispatcher("/homepage.jsp");
				view.forward(request,response);
			}
			else{out.println("dumped up!");}
		}
		catch(Exception e){}
	}
}