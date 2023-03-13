package test;
import java.sql.*;
import javax.servlet.*;

public class ViewDAO {
	public ResultSet rs=null;
	public ResultSet view(ServletRequest req)
	{
		try {
			Connection con=DBConnection.getCon();
			PreparedStatement ps = con.prepareStatement
					                        ("select * from product41 where pcode=?");
			ps.setString(1,req.getParameter("pcode"));
	    rs = ps.executeQuery();
	   
	   } catch(Exception e)
		{
		   e.printStackTrace();
		  }
		return rs;
		}
}

