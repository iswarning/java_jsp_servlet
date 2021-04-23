package control;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.CategoryRepo;
import dao.ProductRepository;
import entity.Category;
import entity.Product;

/**
 * Servlet implementation class ProDetailControl
 */
@WebServlet("/detail")
public class ProDetailControl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProDetailControl() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ProductRepository proRepo = new ProductRepository();
		CategoryRepo cateRepo = new CategoryRepo();
		int id = Integer.parseInt(request.getParameter("id"));
		Product pro = proRepo.getOneP(id);
		List<Category> listC = cateRepo.getAllCate();
		request.setAttribute("pro", pro);
		request.setAttribute("listC", listC);
		request.getRequestDispatcher("detail.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
