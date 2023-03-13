package test;
import java.sql.*;
import javax.servlet.*;

public class DeleteDAO {
    public int k=0;
    public int delete(ServletRequest req) {
    	try {
    		Connection con = DBConnection.getCon();
    		PreparedStatement ps = con.prepareStatement
    				("delete from product41 where pcode=?");
    		ps.setString(1,req.getParameter("pcode"));
    		k=ps.executeUpdate();
    	} catch(Exception e) {
    		e.printStackTrace();
    	}
    	return k;
    }
}
