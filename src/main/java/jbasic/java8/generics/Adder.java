package jbasic.java8.generics;

public class Adder<T extends IAdder<T>>  {

	private T input1;
	private T input2;

	public Adder(T input1, T input2) {
		this.input1 = input1;
		this.input2 = input2;
	}

//	public T add(T input1, T input2){
//		return input1.getValue() + input2.getValue();
//	}
}

//class Add<T extends Integer> implements IAdder<T e>{
//
//	@Override public T getValue() {
//		return null;
//	}
//
//	@Override public T addValue(T input1, T input2) {
//		return (Integer)input1+(Integer)input2;
//	}
//}
//
//public class Concater<T extends IAdder<T>>


interface IAdder<T>{

	public T getValue();
	public T addValue(T input1,T input2);
}

class Demo{

}
