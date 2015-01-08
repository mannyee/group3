package model;

public class Order {
	private String orderId;
	private  String orderDate;
	private double totalCost;
	
	public Order( String orderId,String orderDate,double totalCost){
		this.orderId = orderId;
		this.orderDate = orderDate;
		this.totalCost = totalCost;
	}
	
	public String getOrderId() {
		return orderId;
	}
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
	public String getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(String orderDate) {
		this.orderDate = orderDate;
	}
	public double getTotalCost() {
		return totalCost;
	}
	public void setTotalCost(double totalCost) {
		this.totalCost = totalCost;
	}
	
	
}
