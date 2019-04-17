package jbasic;

public interface IFace {

	public void print(String a);


	default public String xyz(String first, String second){
		return first+second;
	}
}




class IFaceChild implements IFace{

	@Override public String xyz(String first, String second) {
		return null;
	}

	@Override public void print(String a) {

	}
}

class IFaceChild2 implements IFace{
	@Override public void print(String a) {

	}
}
