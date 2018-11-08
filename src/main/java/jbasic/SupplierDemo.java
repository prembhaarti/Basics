package jbasic;

import java.util.function.Supplier;

public class SupplierDemo {

	public static void main(String[] args) {
		supplierDemo(() -> "Prem");
	}


	public static void supplierDemo(Supplier<String> supplier){
		System.out.println(supplier.get());
	}
}
