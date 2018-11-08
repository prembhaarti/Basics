package jdbc;

import java.sql.*;
import java.util.List;

public class Demo {

	public static void main(String[] args) throws ClassNotFoundException {
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;

		String url = "jdbc:mysql://localhost:3306/maverick";
		String user = "root";
		String password = "";

		try {
			con = DriverManager.getConnection(url, user, password);
			st = con.createStatement();
			rs = st.executeQuery("select * from accounts");

			ResultSetMapper<Pojo> resultSetMapper = new ResultSetMapper<Pojo>();
			List<Pojo> accountList = resultSetMapper.mapRersultSetToObject(rs, Pojo.class);

			// print out the list retrieved from database
			if(accountList != null){
				for(Pojo account : accountList){
					System.out.println(account);
				}
			} else {
				System.out.println("ResultSet is empty. Please check if database table is empty");
			}

			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
