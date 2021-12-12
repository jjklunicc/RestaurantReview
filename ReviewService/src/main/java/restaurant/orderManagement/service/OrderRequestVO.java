package restaurant.orderManagement.service;

import java.util.Date;

public class OrderRequestVO {
	
	private String user_index;
	private int restaurant_index;

	private String order_address;
	private int order_total_price;
	private int order_state;
	private Date order_date;
	public String getUser_index() {
		return user_index;
	}
	public void setUser_index(String user_index) {
		this.user_index = user_index;
	}
	public int getRestaurant_index() {
		return restaurant_index;
	}
	public void setRestaurant_index(int restaurant_index) {
		this.restaurant_index = restaurant_index;
	}
	public String getOrder_address() {
		return order_address;
	}
	public void setOrder_address(String order_address) {
		this.order_address = order_address;
	}
	public int getOrder_total_price() {
		return order_total_price;
	}
	public void setOrder_total_price(int order_total_price) {
		this.order_total_price = order_total_price;
	}
	public int getOrder_state() {
		return order_state;
	}
	public void setOrder_state(int order_state) {
		this.order_state = order_state;
	}
	public Date getOrder_date() {
		return order_date;
	}
	public void setOrder_date(Date order_date) {
		this.order_date = order_date;
	}
	
}
