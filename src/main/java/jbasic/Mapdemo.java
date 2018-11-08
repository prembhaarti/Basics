package jbasic;

import java.util.HashMap;

public class Mapdemo {

	public static void main(String[] args) {
		HashMap<String,String> map = new HashMap<>();
		boolean x =map.put("isAppOldVersionApplied","true")==null;
		System.out.println(x);
	}
}
