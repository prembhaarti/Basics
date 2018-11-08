package polymorphism;


public class Demo1 {



	public static void main(String[] args) {
		Demo1 demo1= new Demo1();
	}
}
abstract class Parent{
	private String name;

	public Parent(String name){
		this.name=name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
class Child1 extends Parent{
	private String name;
	public Child1(String name) {
		super(name);
	}

	@Override public String getName() {
		return name;
	}
}

class Child2 extends Parent{
	private String name;
	public Child2(String name) {
		super(name);
	}

	@Override public String getName() {
		return name;
	}
}
