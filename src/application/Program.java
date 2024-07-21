package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.Product;

public class Program {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner scan = new Scanner(System.in);

		List<Product> list = new ArrayList<>();
		
		System.out.println("Enter number of products: ");
		int n = scan.nextInt();
		
		for (int i = 1; i<=n; i++) {
			System.out.println("Product #" + i + " data:");
			System.out.print("Common, used or imported (c/u/i) ?");
			char answer = scan.next().charAt(0);
			System.out.println("Name: ");
			String name = scan.nextLine();
			System.out.println("Price: ");
			Double price = scan.nextDouble();
			
			if (answer == 'c') {
				list.add(new Product(name, price));
			} else if (answer == 'u') {
				
			}
		}
	}

}
