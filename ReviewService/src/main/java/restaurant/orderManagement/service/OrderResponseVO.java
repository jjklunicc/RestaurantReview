package restaurant.orderManagement.service;

import java.util.Date;

public class OrderResponseVO {
	private int order_index;
	private String restaurant_name; 
	private Date order_date;
	private String order_address; 
	private int order_state;
	private int order_total_price;
	
	public int getOrder_index() {
		return order_index;
	}
	public void setOrder_index(int order_index) {
		this.order_index = order_index;
	}
	public String getRestaurant_name() {
		return restaurant_name;
	}
	public void setRestaurant_name(String restaurant_name) {
		this.restaurant_name = restaurant_name;
	}
	public Date getOrder_date() {
		return order_date;
	}
	public void setOrder_date(Date order_date) {
		this.order_date = order_date;
	}
	public String getOrder_adress() {
		return order_address;
	}
	public void setOrder_adress(String order_adress) {
		this.order_address = order_adress;
	}
	public int getOrder_state() {
		return order_state;
	}
	public void setOrder_state(int order_state) {
		this.order_state = order_state;
	}
	public int getOreder_total_price() {
		return order_total_price;
	}
	public void setOreder_total_price(int oreder_total_price) {
		this.order_total_price = oreder_total_price;
	}
	
	

}
