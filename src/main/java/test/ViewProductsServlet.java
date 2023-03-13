package test;
import java.io.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.annotation.*;
@SuppressWarnings("serial")
@WebServlet("/view")

public class ViewProductsServlet extends GenericServlet {
	public RetrieveDAO ob = null;
	public void init() throws ServletException{
		ob = new RetrieveDAO();
	}
	public void service(ServletRequest req,ServletResponse res)
	         throws ServletException,IOException {
		PrintWriter pw = res.getWriter();
		res.setContentType("text/html");
		try {
			ResultSet rs = ob.retrieve();
			if(rs==null) {
				pw.println("Product NOT Available...<br>");
				RequestDispatcher rd = req.getRequestDispatcher("input.html");
				rd.include(req, res);						
			} else {
				while(rs.next()) {
					pw.println(rs.getString(1)+"&nbsp&nbsp"+rs.getString(2)+
							"&nbsp&nbsp"+rs.getFloat(3)+"&nbsp&nbsp"+rs.getInt(4)+"<br>");
				}
				RequestDispatcher rd = req.getRequestDispatcher("input.html");
				rd.include(req, res);
			}
		} catch(Exception e)
		{e.printStackTrace();}
	}

}
