package user.login.registration;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/LoginRegister")
public class LoginRegister extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	public LoginRegister() {
		
	}
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UserDAO ud = new UserDAOImpl();
		String userName = request.getParameter("username");
		String passWord = request.getParameter("password1");
		String submitType = request.getParameter("submit");
		User u = new User();
		u = ud.getUser(userName, passWord);
		
		if(submitType.equals("login") && u != null && u.getName() != null){
			request.setAttribute("message", u.getName());
			request.getRequestDispatcher("welcome.jsp").forward(request, response);
		}else if(submitType.equals("register")) {
			u.setName(request.getParameter("name"));
			u.setPassword(passWord);
			u.setUsername(userName);
			ud.insertUser(u);
			request.setAttribute("successMessage", "Registration done Please Login to Contiue !!");
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}else {
			request.setAttribute("message", "Data Not Found ,click on Register !!!");
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}
	}

	
	
	
}
