package test;
import java.io.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.annotation.*;
@SuppressWarnings("serial")
@WebServlet("/vw")
public class ViewProductSer extends GenericServlet{
	public ViewDAO ob=null;
	public void init() throws ServletException{
		ob=new ViewDAO();
	}
	public void service(ServletRequest req,ServletResponse res)
	       throws ServletException,IOException
	{
		try {
		PrintWriter pw = res.getWriter();
		res.setContentType("text/html");
		ResultSet rs = ob.view(req);
			if(rs!=null)
		{
				if(rs.next()) 
				{
				
					pw.println(rs.getString(1)+"&nbsp&nbsp"+rs.getString(2)+
							"&nbsp&nbsp"+rs.getFloat(3)+"&nbsp&nbsp"+rs.getInt(4)+"<br>");
					
					RequestDispatcher rd = req.getRequestDispatcher("input.html");
					rd.include(req, res);	
				
				}
				else
				{
					pw.println("Invalid Product Code...<br>");
					RequestDispatcher rd = req.getRequestDispatcher("input.html");
					rd.include(req, res);	
					
				}		
		}				
	}catch(Exception e)
	{
		e.printStackTrace();
	}

       }
	}

