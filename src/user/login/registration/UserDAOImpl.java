package user.login.registration;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UserDAOImpl implements UserDAO {
	
	static Connection con;
	static PreparedStatement ps;

	@Override
	public int insertUser(User u) {
		int status = 0;
		try{
			con = MyConnectionCaller.getCon();
			ps = con.prepareStatement("insert into user_login values(?,?,?)");
			
			ps.setString(1, u.getUsername());
			ps.setString(2, u.getName());
			ps.setString(3, u.getPassword());
			
			status = ps.executeUpdate();
			con.close();
		}catch (Exception e) {
			System.out.println(e);
		}
		return status;
	}

	@Override
	public User getUser(String uname, String pass) {
		User u = new User();
		try{
			con = MyConnectionCaller.getCon();
			ps = con.prepareStatement("select * from user_login where username=? and password=?");
			ps.setString(1, uname);
			ps.setString(2, pass);
			
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				u.setUsername(rs.getString(1));
				u.setName(rs.getString(2));
				u.setPassword(rs.getString(3));
			}
		}catch (Exception e) {
			System.out.println(e);
		}
		return u;
	}

}
