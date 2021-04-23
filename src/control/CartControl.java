package control;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.ProductRepository;
import entity.Order;
import entity.OrderDetail;
import entity.Product;
import orther.RandomString;

/**
 * Servlet implementation class CartControl
 */
@WebServlet("/cart")
public class CartControl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CartControl() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		if(action != null && !action.isEmpty()) {
			switch(action) {
				case "list":
					this.listCart(request, response);
					break;
				case "remove":
					this.remove(request, response);
					break;
			}
		}
	}
	 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		switch(action) {
			case "addToCart":
				this.addToCart(request, response);
				break;
			case "update":
				this.updateCart(request, response);
				break;
		}
	}
	
	private void remove(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		HttpSession session = request.getSession();
		List<OrderDetail> cart = (List<OrderDetail>)session.getAttribute("cart");
		int index = isExisting(id, cart);
		cart.remove(index);
		session.setAttribute("cart", cart);
		response.sendRedirect("cart?action=list");
	}
	
	private void listCart(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		List<OrderDetail> sessOr = (List<OrderDetail>)session.getAttribute("cart");
		request.setAttribute("listOD", sessOr);
		request.getRequestDispatcher("cart.jsp").forward(request, response);
	}
	
	private void addToCart(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int proId = Integer.parseInt(request.getParameter("proId"));
		ProductRepository proRepo = new ProductRepository();
		Product pro = proRepo.getOneP(proId);
		HttpSession session = request.getSession();
		List<OrderDetail> cart = (List<OrderDetail>)session.getAttribute("cart");
		List<OrderDetail> listOD = new ArrayList<>();
		if(session.getAttribute("cart") == null) {
			OrderDetail oD = new OrderDetail();
			oD.setProductId(proId);
			oD.setProductName(pro.getTenSanPham());
			oD.setPrice(pro.getGia());
			oD.setQuantity(1);
			listOD.add(oD);
			session.setAttribute("cart", listOD);
		} else {
			
			int index = isExisting(proId, cart);
			if(index == -1) {
				OrderDetail oD = new OrderDetail();
				oD.setProductId(proId);
				oD.setProductName(pro.getTenSanPham());
				oD.setPrice(pro.getGia());
				oD.setQuantity(1);
				cart.add(oD);
			} else {
				int qty = cart.get(index).getQuantity() + 1;
				cart.get(index).setQuantity(qty);
			}
			session.setAttribute("cart", cart);
		}
		
		response.sendRedirect("cart?action=list");
	}
	
	private void updateCart(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int proId = Integer.parseInt(request.getParameter("proId"));
		int qty = Integer.parseInt(request.getParameter("qty"));
		
		HttpSession session = request.getSession();
		List<OrderDetail> cart = (List<OrderDetail>)session.getAttribute("cart");
		
		int index = isExisting(proId, cart);
		cart.get(index).setQuantity(qty);
		session.setAttribute("cart", cart);
		response.sendRedirect("cart?action=list");
	}
	
	private int isExisting(int id, List<OrderDetail> od) {
		for(int i = 0; i < od.size(); i++) {
			if(od.get(i).getProductId() == id) {
				return i;
			}
		}
		return -1;
	}

}

