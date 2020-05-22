package entities;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import entities.OrderItem;
import entities.enums.OrderStatus;

public class Order {
	
	//Variables
	
	private Date moment = new Date();
	private OrderStatus status;
	private List<OrderItem> items = new ArrayList<>();
	private Client client;
	private SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
	
	//Constructors
	
	public Order() {
	}

	public Order(Date moment, OrderStatus status, Client client) {
		this.moment = moment;
		this.status = status;
		this.client = client;
	}

	//Getters and Setters

	public Date getMoment() {
		return moment;
	}

	public void setMoment(Date moment) {
		this.moment = moment;
	}

	public OrderStatus getStatus() {
		return status;
	}

	public void setStatus(OrderStatus status) {
		this.status = status;
	}
	
	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public List<OrderItem> getItem() {
		return items;
	}

	//Actions
	
	public void addItem(OrderItem item) {
		items.add(item);
	}
	
	public void removeItem(OrderItem item) {
		items.remove(item);
	}
	
	public Double total() {
		double sum = 0;
		for (OrderItem item : items) {
			sum += item.subTotal();
		}
		return sum;
	}

	//To String
	
	public String toString() {
		
		StringBuilder sb = new StringBuilder();
		
		sb.append("Order moment: ");
		sb.append(sdf.format(moment) + "\n");
		
		sb.append("Order status: ");
		sb.append(status + "\n");
		
		sb.append("\n");
		sb.append(client + "\n");
		sb.append("\n");
		
		sb.append("Order items:" + "\n");
		
		for (OrderItem item : items) {
			sb.append(item.toString() + "\n");
		}
		
		sb.append("\n");
		
		sb.append("Total price: $");
		sb.append(String.format("%.2f", total())); 
		
		return sb.toString();
			
	}	
	
}
