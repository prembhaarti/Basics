package jbasic.work;

public class PrivateConstructor {

	public static void main(String[] args) {
		System.out.println(PrivateConstructor.getString());
	}

	public static String getString(){
		return "first";
	}

	private PrivateConstructor(){
		System.out.println("hello");
	}
}
