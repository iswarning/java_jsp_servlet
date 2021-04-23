package control;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UserRepo;
import entity.User;

/**
 * Servlet implementation class RegisterControl
 */
@WebServlet("/register")
public class RegisterControl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterControl() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("register.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String rePassword = request.getParameter("repassword");
		
		List<User> listU = new ArrayList<>();
		for(User u : listU) {
			if(!email.equals(u.getEmail())) {
				request.setAttribute("message", "Email already exists !");
				request.getRequestDispatcher("register.jsp").forward(request, response);
				break;
			}
		}
		
		if(!rePassword.equals(password)) {
			request.setAttribute("message", "Password does not same !");
			request.getRequestDispatcher("register.jsp").forward(request, response);
		}
		
		UserRepo uRepo = new UserRepo();
		User u = uRepo.register(email, password);	
		response.sendRedirect("login");
	}

}
