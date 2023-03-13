package test;
import java.sql.*;

public class RetrieveDAO {
 public ResultSet rs = null;
 public ResultSet retrieve() {
	 try {
		Connection con = DBConnection.getCon();
		PreparedStatement ps = con.prepareStatement
				("select * from product41");
		rs = ps.executeQuery();
	 } catch(Exception e)
	 {e.printStackTrace();}
	 return rs;
 }
}
