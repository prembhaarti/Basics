package jbasic.java8;

import org.joda.time.DateTime;
import org.joda.time.DateTimeComparator;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

public class DateTimeDemo {

	public static void main(String[] args) {
		DateTime dateTime = new DateTime();
		//yyyy-MM-dd'T'HH:mm:ssZ
		DateTimeFormatter formatter = DateTimeFormat.forPattern("dd/MM/yyyy HH:mm:ss");
		DateTime dt = formatter.parseDateTime("14/03/2018 00:00:00");

		if(DateTimeComparator.getDateOnlyInstance().compare(DateTime.now(),dt) > 2){
			System.out.println(true);
		}
		else{
			System.out.println(false);
		}

		System.out.println(dateTime);
		System.out.println(dateTime.getMillis());
	}
}
