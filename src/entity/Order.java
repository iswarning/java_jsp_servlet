package entity;

import java.util.List;

public class Order {

	private int id;
	private String orderId;
	private int userId;
	private String payment;
	private String position;
	private String note;
	private int totalQuantity;
	private long totalAmount;
	private int status;
	private List<OrderDetail> orderDetail;
	public Order() {
		super();
	}
	public Order(int id, String orderId, int userId, String payment, String position, String note, int totalQuantity,
			long totalAmount, int status, List<OrderDetail> orderDetail) {
		super();
		this.id = id;
		this.orderId = orderId;
		this.userId = userId;
		this.payment = payment;
		this.position = position;
		this.note = note;
		this.totalQuantity = totalQuantity;
		this.totalAmount = totalAmount;
		this.status = status;
		this.orderDetail = orderDetail;
	}
	public String getOrderId() {
		return orderId;
	}
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getPayment() {
		return payment;
	}
	public void setPayment(String payment) {
		this.payment = payment;
	}
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	public int getTotalQuantity() {
		return totalQuantity;
	}
	public void setTotalQuantity(int totalQuantity) {
		this.totalQuantity = totalQuantity;
	}
	public long getTotalAmount() {
		return totalAmount;
	}
	public void setTotalAmount(long totalAmount) {
		this.totalAmount = totalAmount;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public List<OrderDetail> getOrderDetail() {
		return orderDetail;
	}
	public void setOrderDetail(List<OrderDetail> orderDetail) {
		this.orderDetail = orderDetail;
	}
	@Override
	public String toString() {
		return "Order [id=" + id + ", orderId=" + orderId + ", userId=" + userId + ", payment=" + payment
				+ ", position=" + position + ", note=" + note + ", totalQuantity=" + totalQuantity + ", totalAmount="
				+ totalAmount + ", status=" + status + ", orderDetail=" + orderDetail + "]";
	}
	

	
	
	
}
