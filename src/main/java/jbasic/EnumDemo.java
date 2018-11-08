package jbasic;

public class EnumDemo {

	public static void main(String[] args) {
		System.out.println(State.RECOMMENDED);
	}


}

enum State{
	RECOMMENDED("R"),CONFIRMED("C");

	final String value;

	State(String value) {
		this.value = value;
	}

	@Override public String toString() {
		return value;
	}
}
