package test;
import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.*;
@SuppressWarnings("serial")
@WebServlet("/add")
public class AddPoductServlet extends GenericServlet{
	public InsertDAO ob = null;
	public void init() throws ServletException{
		ob= new InsertDAO();
	}
	public void service(ServletRequest req,ServletResponse res)
	       throws ServletException,IOException{
		PrintWriter pw = res.getWriter();
		pw.println("<html><body bgcolor=yellow text=red>");
		pw.println("</html></body>");
		res.setContentType("text/html");
		int k = ob.insert(req);
		if(k>0) {
			pw.println("Product added Successfully...<br>");
			RequestDispatcher rd =
					req.getRequestDispatcher("input.html");
			rd.include(req, res);
		}
	}

}
