package applications;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import entities.Client;
import entities.Order;
import entities.OrderItem;
import entities.Product;
import entities.enums.OrderStatus;

public class Program {

	public static void main(String[] args) throws ParseException {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");	
		
		//Client Data
		
		System.out.println("Enter client data:");
		
		System.out.print("Name: ");
		String name = sc.nextLine();
		
		System.out.print("Email: ");
		String email = sc.nextLine();
		
		System.out.print("Birth date (DD/MM/YYYY): ");
		Date birthDate = sdf.parse(sc.next());

		Client client = new Client(name, email, birthDate);
		
		//Order input
		
		System.out.println();
		System.out.println("Enter order data:");
			
		System.out.print("Status: ");
		OrderStatus status = OrderStatus.valueOf(sc.next());
		
		System.out.println();
		
		Order order = new Order(new Date(), status, client);
		
		System.out.print("How many items to this order? ");
		Integer n = sc.nextInt();
		
		System.out.println();
		
		for(int i = 1; i <= n; i++) {
			
			sc.nextLine();
			
			System.out.println("Enter #" + i + " item data:");
			
			System.out.print("Product name: ");
			String productName = sc.nextLine();
			
			System.out.print("Product price: ");
			Double productPrice = sc.nextDouble();
			
			Product product = new Product(productName, productPrice);
			
			System.out.print("Quantity: ");
			Integer productQuantity = sc.nextInt();
			
			OrderItem orderItem = new OrderItem(productQuantity, product.getPrice(), product);
			
			order.addItem(orderItem);
		}
		
		System.out.println();
		System.out.println("ORDER SUMARRY:");
		System.out.println(order);
		
		sc.close();
		
	}

}
