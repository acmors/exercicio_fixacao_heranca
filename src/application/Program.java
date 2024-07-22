package application;

import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.ImportedProduct;
import entities.Product;
import entities.UsedProduct;

public class Program {

	public static void main(String[] args) throws ParseException{
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
			scan.nextLine();
			String name = scan.nextLine();
			System.out.println("Price: ");
			Double price = scan.nextDouble();
			
			if (answer == 'c') {
				list.add(new Product(name, price));
			} else if (answer == 'u') {
				System.out.println("Manufacture date (DD/MM/YYYY): ");
				LocalDate date = LocalDate.parse(scan.next(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
				list.add(new UsedProduct(name, price, date));
			}else {
				System.out.println("Customs Fee: ");
				double customsFee = scan.nextDouble();
				list.add(new ImportedProduct(name, price, customsFee));
			}
			
		}
		
		System.out.println();
		System.out.println("Price Tags: ");
		for(Product product : list) {
			System.out.println(product.priceTag());
		}
		
		scan.close();
	}

}
