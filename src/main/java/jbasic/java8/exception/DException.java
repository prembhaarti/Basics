package jbasic.java8.exception;

public class DException extends Exception{

//	private String message;

	public DException(String message) {
		super(message);
//		this.message = message;
	}


//	@Override public String toString() {
//		return "DException{" + "message='" + message + '\'' + '}';
//	}

	public static void main(String[] args) {
		try{
			throw new DException("xyz");
		}
		catch (Exception de){
			System.out.println(de.getMessage());
		}
	}

}
