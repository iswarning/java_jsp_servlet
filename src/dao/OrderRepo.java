package dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import context.DBContext;
import entity.Order;
import entity.OrderDetail;

public class OrderRepo {
	
	private Connection conn;
	private PreparedStatement ps;
	private ResultSet rs;

	public void createOrder(Order o) throws SQLException {
		String query = "INSERT INTO `order`(`user_id`, `order_id`, `payment`, `position`, `note`, `total_quantity`, `total_amount`, `status`) VALUES ( ?, ?, ?, ?, ?, ?, ?, ?)";
		
		try {
			conn = new DBContext().getConnection();
			ps = conn.prepareStatement(query);
			ps.setInt(1, o.getUserId());
			ps.setString(2, o.getOrderId());
			ps.setString(3, o.getPayment());
			ps.setString(4, o.getPosition());
			ps.setString(5, o.getNote());
			ps.setInt(6, o.getTotalQuantity());
			ps.setLong(7, o.getTotalAmount());
			ps.setInt(8, o.getStatus());
			ps.executeUpdate();
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void createOrderDetail(OrderDetail od) throws SQLException {
		String query = "INSERT INTO `orderproduct`(`order_id`, `product_id`, `product_name`, `price`, `quantity`) VALUES ( ?, ?, ?, ?, ?)";
		
		try {
			conn = new DBContext().getConnection();
			ps = conn.prepareStatement(query);
			ps.setString(1, od.getOrderId());
			ps.setInt(2, od.getProductId());
			ps.setString(3, od.getProductName());
			ps.setFloat(4, od.getPrice());
			ps.setInt(5, od.getQuantity());
			ps.executeUpdate();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public List<Order> getAllOrderByUser(int id){
		String query = "SELECT * FROM `order` WHERE user_id = ?";
		List<Order> list = new ArrayList<>();
		try {
			conn = new DBContext().getConnection();
			ps = conn.prepareStatement(query);
			ps.setInt(1, id);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				Order o = new Order();
				o.setId(rs.getInt(1));
				o.setOrderId(rs.getString(2));
				o.setUserId(rs.getInt(3));
				o.setPayment(rs.getString(4));
				o.setPosition(rs.getString(5));
				o.setNote(rs.getString(6));
				o.setTotalQuantity(rs.getInt(7));
				o.setTotalAmount(rs.getLong(8));
				o.setStatus(rs.getInt(9));
				list.add(o);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return list;
	}
	
	public List<OrderDetail> getAllOrderDetailByOrderId(String orderId) {
		String query = "SELECT * FROM `orderproduct` WHERE order_id = ?";
		
		List<OrderDetail> list = new ArrayList<>();
		try {
			conn = new DBContext().getConnection();
			ps = conn.prepareStatement(query);
			ps.setString(1, orderId);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				OrderDetail o = new OrderDetail();
				o.setId(rs.getInt(1));
				o.setOrderId(rs.getString(2));
				o.setProductId(rs.getInt(3));
				o.setProductName(rs.getString(4));
				o.setPrice(rs.getFloat(5));
				o.setQuantity(rs.getInt(6));
				list.add(o);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
}
