package entities;

import entities.Product;

public class OrderItem {
	
	//Variables
	
	private Integer quantity;
	private Double price;
	private Product product;
	
	//Constructors
	
	public OrderItem() {
	}

	public OrderItem(Integer quantity, Double price, Product product) {
		this.quantity = quantity;
		this.price = price;
		this.product = product;
	}

	//Getters and Setters
	
	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}
	
	//Actions
	
	public Double subTotal() {
		return price * quantity;
	}
	
	public String toString() {
		return product.getName() 
				+ ", $"
				+ String.format("%.2f", price)
				+ ", Quantity: "
				+ quantity
				+ ", Subtotal: $"
				+ String.format("%.2f", subTotal());
							
	}
	
}
