package test2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class CatchExpressionDemo {

	private String expression =  null ;
	private int exCount = 0;

	private String subject = null;
	private String verb = null;
	private String object = null;

	private boolean nextOb = false;

	public void getSubOrOb(String card) {
		if (nextOb == true) {
			object = card;
			nextOb = false;
			System.out.println("object: " + object);
		} else {
			subject = card;
			nextOb = true;
			System.out.println("subject: " + subject);
		}
	}

	public void getVerb(String card) {
		verb = card;
		System.out.println("verb: " + verb);
	}

	public String getExpression() {
		if (subject != null && verb != null && object != null) {
			try {
				Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
			} catch (Exception ex) {
				// handle the error
			}

			Connection conn = null;
			try {
				conn = DriverManager.getConnection("jdbc:mysql://localhost/databased?"
						+ "user=root&password=0000&serverTimezone=UTC&useSSL=false");

				Statement stmt = conn.createStatement();

				ResultSet rs = stmt.executeQuery("select a.num, subject, verb, object, action, tocardnum"
						+ " from action a" + " where subject='" + subject + "'" 
						+ " and verb='" + verb + "'" + " and object='" + object + "'");

				/*ResultSet rs = stmt.executeQuery("select a.num, subject, verb, object, action, tocardnum, card"
						+ " from action a, cards c" + " where c.cardnum = a.tocardnum" + " and subject='" + subject
						+ "'" + " and verb='" + verb + "'" + " and object='" + object + "'");*/

				while (rs.next()) {
					expression = rs.getString(5);
					System.out.println("expression: " + expression);
				}

			} catch (SQLException ex) {
				// handle any errors
				System.out.println("SQLException: " + ex.getMessage());
				System.out.println("SQLState: " + ex.getSQLState());
				System.out.println("VendorError: " + ex.getErrorCode());
			}

			subject = null;
			verb = null;
			object = null;

			return expression;
		} else {
			return expression;
		}
	}

}
