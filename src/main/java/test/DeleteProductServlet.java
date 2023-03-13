package test;
import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.*;
@SuppressWarnings("serial")
@WebServlet("/del")
public class DeleteProductServlet extends GenericServlet{
	public DeleteDAO ob = null;
	public void init() throws ServletException {
		ob = new DeleteDAO();
	}
	public void service(ServletRequest req,ServletResponse res) 
		throws ServletException,IOException{
		PrintWriter pw = res.getWriter();
		res.setContentType("text/html");
		int k=ob.delete(req);
		if(k>0) {
			pw.println("Product Deleted Successfully...<br>");
			RequestDispatcher rd = req.getRequestDispatcher("input.html");
			rd.include(req, res);
		}
		else {
			pw.println("Product is NOT Available..");
		}
			
		}
	}


