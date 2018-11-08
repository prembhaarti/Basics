package jbasic.java8.abstraction;

public class Statics {


	public static ZZ object= new ZZ();

	static {
		object.a=5;

	}
	public static void change(){
		System.out.println(object.a);
	}

//	public static void main(String[] args) {
//
//		Statics s = new Statics();
//		System.out.println(Statics.object.a);
//	}
}
class ZZ{
	public int a;
	public int b;
}
