package admin.login.registration;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import user.login.registration.User;


@WebServlet("/ALoginRegister")
public class ALoginRegister extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public ALoginRegister() {
      
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		AdminDAO ad = new AdminDAOImpl();
		String adminName = request.getParameter("adminname");
		String passWord = request.getParameter("password1");
		String submitType = request.getParameter("submit");
		Admin a = new Admin();
		a = ad.getAdmin(adminName, passWord);
		
		if(submitType.equals("login") && a != null && a.getName() != null){
			request.setAttribute("message", a.getName());
			request.getRequestDispatcher("flightList.jsp").forward(request, response);
		}else if(submitType.equals("register")) {
			a.setName(request.getParameter("name"));
			a.setPassword(passWord);
			a.setAdminname(adminName);
			ad.insertAdmin(a);
			request.setAttribute("successMessage", "Registration done Please Login to Continue !!");
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}else {
			request.setAttribute("message", "Data Not Found ,click on Register !!!");
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}
	}

	
	
	
	
	
	
	
	
	
	
}
