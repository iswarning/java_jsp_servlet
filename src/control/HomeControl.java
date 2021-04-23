package control;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import dao.ProductRepository;
import dao.CategoryRepo;
import entity.Category;
import entity.Product;

/**
 * Servlet implementation class HomeControl
 */
@WebServlet("/home")
public class HomeControl extends HttpServlet {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ProductRepository proRepo = new ProductRepository();
		CategoryRepo cateRepo = new CategoryRepo();
		boolean issetPage = (request.getParameter("page") == null);
		
		List<Product> listP = null;
		
		if(issetPage == false) {
			int currentPage = Integer.parseInt(request.getParameter("page"));
			int totalRecord = proRepo.getAllProduct(20, 0).size();
			int itemPerPage = 5;
			int offset = 5;
			int totalPage = totalRecord / itemPerPage;
			for(int i = 0; i < totalPage; i++) {
				if(currentPage == i+1) {
					offset = offset * i;
					listP = proRepo.getAllProduct(itemPerPage, offset);
					break;
				}
			}
		} else {
			listP = proRepo.getAllProduct(5, 0);
		}
		
	
		
		List<Category> listC = cateRepo.getAllCate();
		request.setAttribute("listP", listP);
		request.setAttribute("listC", listC);
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}

}
