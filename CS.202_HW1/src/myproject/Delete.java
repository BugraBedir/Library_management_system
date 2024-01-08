package myproject;
import java.sql.*;


public class Delete {
	public static boolean Del(int userID) {
	
		boolean b = false;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection bag = DriverManager.getConnection("jdbc:mysql://localhost:3306/library?autoReconnect=true&useSSL=false","root","");
			String q = "DELETE FROM users where user_id=?";
			PreparedStatement p1 = bag.prepareStatement(q);
			
			p1.setInt(1, userID);
			p1.executeUpdate();
			
			b = true;
		} catch (Exception e) {
			System.out.println("The user could not be deleted.");
		}
		return b;
	}
	public static boolean Del_Book(int bookID) {
		
		boolean b = false;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection bag = DriverManager.getConnection("jdbc:mysql://localhost:3306/library?autoReconnect=true&useSSL=false","root","");
			String q = "DELETE FROM books WHERE book_id=?";
			PreparedStatement p1 = bag.prepareStatement(q);
			
			p1.setInt(1, bookID);
			p1.executeUpdate();
			
			b=true;
		} catch (Exception e) {
			System.out.println("The book could not be removed");
		}
		return b;
	}
	public static boolean Book_Return(int checkout_id) {
		
		boolean b = false;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection bag = DriverManager.getConnection("jdbc:mysql://localhost:3306/library?autoReconnect=true&useSSL=false","root","");
			String q = "DELETE FROM	borrow WHERE checkout_id=?";
			PreparedStatement p1 = bag.prepareStatement(q);
			
			p1.setInt(1, checkout_id);
			p1.executeUpdate();
			
			b=true;
		} catch (Exception e) {
			System.out.println("The operation could not be completed");
		}
		return b;
	}

}

