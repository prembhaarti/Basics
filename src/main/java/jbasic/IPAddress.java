package jbasic;

import com.mchange.v2.lang.StringUtils;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class IPAddress {

	public static void main(String[] args) {
		String ipAddress= "";
		try {
			ipAddress = InetAddress.getLocalHost().getHostAddress();
			System.out.println(ipAddress);
		}
		catch (UnknownHostException e) {
			e.printStackTrace();
		}
	}
}
