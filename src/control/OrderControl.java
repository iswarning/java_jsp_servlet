package control;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.OrderRepo;
import entity.Order;
import entity.OrderDetail;
import entity.User;
import orther.RandomString;

/**
 * Servlet implementation class OrderControl
 */
@WebServlet("/order")
public class OrderControl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OrderControl() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    
    private OrderRepo orderRepo;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		List<OrderDetail> cart = (List<OrderDetail>)session.getAttribute("cart");
		int totalQuantity = 0;
		long totalAmount = 0;
		for(OrderDetail od : cart) {
			totalQuantity+=od.getQuantity();
			totalAmount+=(od.getPrice()*od.getQuantity());
		}
		OrderRepo orderRepo = new OrderRepo();
		User u = (User)session.getAttribute("userLogged");
		if(cart != null && totalQuantity != 0 && totalAmount != 0) {
			if(u != null) {
				try {
					Order o = new Order();
					String orderId = new RandomString().rand(10);
					o.setUserId(u.getId());
					o.setOrderId(orderId);
					o.setPayment("offline");
					o.setPosition("123 Cau Giay Ha Noi");
					o.setTotalQuantity(totalQuantity);
					o.setTotalAmount(totalAmount);
					o.setStatus(0);
					o.setNote("giao nhanh trong 10 phut");
					orderRepo.createOrder(o);
					
					for(int i = 0; i < cart.size(); i++) {
						cart.get(i).setOrderId(orderId);
						orderRepo.createOrderDetail(cart.get(i));
					}
					
					session.removeAttribute("cart");
					
					response.sendRedirect("home");
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					System.out.println(e);
				}
			} else {
				response.sendRedirect("login");
			}
		}
		
	}
	
}
