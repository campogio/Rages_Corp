package bevandecorporation;

import java.awt.List;
import java.sql.*;
import java.util.ArrayList;

public class ConnessioneMySql {

	public static ArrayList RichiestaData(String s,String columnLabel) throws SQLException {
		Statement st;
		ResultSet rs;
		String sql;
		ArrayList<String> stringhe = new ArrayList<String>();
		Connection cn;

		// CONNESSIONE
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			System.out.println("ClassNotFoundException: ");
			System.out.println(e.getMessage());
		} // try-catch

		cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb?user=root&password=Giordano");

		sql = s;
		// Testquery

		try {

			st = cn.createStatement();
			int i=0;
			rs = st.executeQuery(sql);
			while (rs.next() == true) {
				stringhe.add(rs.getString(columnLabel));
				System.out.println(rs.getString(columnLabel));
				i++;
			}
		} catch (SQLException e) {
			System.out.println("Errore: " + e.getMessage());
		}
		cn.close();
		return stringhe;

	}
	
	
	public static String RichiestaDataString(String s,String columnLabel) throws SQLException {
		Statement st;
		ResultSet rs;
		String sql;
		String stringhe = null;
		Connection cn;

		// CONNESSIONE
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			System.out.println("ClassNotFoundException: ");
			System.out.println(e.getMessage());
		} // try-catch

		cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb?user=root&password=Giordano");

		sql = s;
		// Testquery

		try {

			st = cn.createStatement();
			rs = st.executeQuery(sql);
			
			rs.first();			
			stringhe =rs.getString(columnLabel);
			System.out.println(stringhe);
			
		} catch (SQLException e) {
			System.out.println("Errore: " + e.getMessage());
		}
		cn.close();
		return stringhe;

	}

	public static void ManipolaData(String s) throws SQLException {
		Statement st;
		ResultSet rs;
		String sql;
		ArrayList<String> stringhe = new ArrayList<String>();
		Connection cn;

		// CONNESSIONE
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			System.out.println("ClassNotFoundException: ");
			System.out.println(e.getMessage());
		} // try-catch

		cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb?user=root&password=Giordano");

		sql = s;
		// Testquery

		try {

			st = cn.createStatement();
			st.execute(sql);

		} catch (SQLException e) {
			System.out.println("Errore: " + e.getMessage());
		}
		cn.close();

	}

}