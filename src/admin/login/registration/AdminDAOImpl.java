package admin.login.registration;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class AdminDAOImpl implements AdminDAO {
	
	static Connection con;
	static PreparedStatement ps;

	@Override
	public int insertAdmin(Admin a) {
		int status = 0;
		try{
			con = MyConnectionCaller.getCon();
			ps = con.prepareStatement("insert into admin_login values(?,?,?)");
			
			ps.setString(1, a.getAdminname());
			ps.setString(2, a.getName());
			ps.setString(3, a.getPassword());
			
			status = ps.executeUpdate();
			con.close();
		}catch (Exception e) {
			System.out.println(e);
		}
		return status;
	}

	@Override
	public Admin getAdmin(String aname, String pass) {
		Admin a = new Admin();
		try{
			con = MyConnectionCaller.getCon();
			ps = con.prepareStatement("select * from admin_login where adminname=? and password=?");
			ps.setString(1, aname);
			ps.setString(2, pass);
			
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				a.setAdminname(rs.getString(1));
				a.setName(rs.getString(2));
				a.setPassword(rs.getString(3));
			}
		}catch (Exception e) {
			System.out.println(e);
		}
		return a;
	}

}
