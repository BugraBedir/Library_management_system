package myproject;
import java.sql.*;
import java.util.Date;

public class Insert {
	public static void add(String User_Name,String Email,String Adress) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			Connection bag = DriverManager.getConnection("jdbc:mysql://localhost:3306/library?autoReconnect=true&useSSL=false", "root", "");
			
			String sql = "INSERT INTO users VALUES (NULL,?,?,?)";
			PreparedStatement p1 = bag.prepareStatement(sql);
			
			p1.setString(1,User_Name);
			p1.setString(2, Email);
			p1.setString(3, Adress);
				
			int sonuc = p1.executeUpdate();
	
			if(sonuc==1) {
				System.out.println("User has been added.");
			} else {
				System.out.println("The user did not been added.'");
			}
			
			p1.close();
			bag.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
}
	public static void checkout_book(int book_id,int user_id) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			Connection bag = DriverManager.getConnection("jdbc:mysql://localhost:3306/library?autoReconnect=true&useSSL=false", "root", "");
			Date date = new Date();
			java.sql.Date sqldate = new java.sql.Date(date.getTime());
			String sql = "INSERT INTO borrow VALUES (NULL,?,?,?)";
			PreparedStatement p1 = bag.prepareStatement(sql);
			
			p1.setInt(1,user_id);
			p1.setInt(2,book_id );
			p1.setDate(3, sqldate);
			
			int sonuc = p1.executeUpdate();
	
			if(sonuc==1) {
				System.out.println("The checkout has been made.");
			} else {
				System.out.println("The checkout has not been made.'");
			}
			
			p1.close();
			bag.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}		public static void insert_hist(int book_id,int user_id) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			Connection bag = DriverManager.getConnection("jdbc:mysql://localhost:3306/library?autoReconnect=true&useSSL=false", "root", "");
			Date date = new Date();
			java.sql.Date sqldate = new java.sql.Date(date.getTime());
			String sql = "INSERT INTO borrow_hist VALUES (?,?,?)";
			PreparedStatement p1 = bag.prepareStatement(sql);
			
			p1.setInt(1,user_id);
			p1.setInt(2,book_id );
			p1.setDate(3, sqldate);
			
			int sonuc = p1.executeUpdate();
	
			if(sonuc==1) {
				System.out.println("The checkout has been made.");
			} else {
				System.out.println("The checkout has not been made.'");
			}
			
			p1.close();
			bag.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}		
	public void Minus_One(int book_id) {
		try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		Connection bag = DriverManager.getConnection("jdbc:mysql://localhost:3306/library?autoReconnect=true&useSSL=false", "root", "");
		String sql = "UPDATE books SET amount=amount-1 WHERE book_id=?";
		
		PreparedStatement p1 =bag.prepareStatement(sql);
		p1.setInt(1, book_id);
		
		int sonuc = p1.executeUpdate();
		if(sonuc==1) {
			System.out.println("Update completed successfully.");
		} else {
			System.out.println("The update could not be completed.");
		}
		bag.close();
		p1.close();
		
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void Plus_One(int book_id) {
		try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		Connection bag = DriverManager.getConnection("jdbc:mysql://localhost:3306/library?autoReconnect=true&useSSL=false", "root", "");
		String sql = "UPDATE books SET amount=(amount+1) WHERE book_id=?";
		
		PreparedStatement p1 =bag.prepareStatement(sql);
		p1.setInt(1, book_id);
		
		int sonuc = p1.executeUpdate();
		if(sonuc==1) {
			System.out.println("Update completed successfully.");
		} else {
			System.out.println("The update could not be completed.");
		}
		bag.close();
		p1.close();
		
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}