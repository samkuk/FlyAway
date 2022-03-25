package admin.login.registration;

public interface AdminDAO {
	
	public int insertAdmin(Admin a);
	public Admin getAdmin(String adminname, String pass);

}
