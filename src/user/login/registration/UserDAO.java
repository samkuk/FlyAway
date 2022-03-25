package user.login.registration;

public interface UserDAO {
	
	public int insertUser(User u);
	public User getUser(String username, String pass);

}
