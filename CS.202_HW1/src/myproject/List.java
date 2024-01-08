package myproject;
import java.sql.*;

import com.mysql.cj.protocol.x.SyncFlushDeflaterOutputStream;
public  class List {
	public static void list() {
		try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		Connection bag = DriverManager.getConnection("jdbc:mysql://localhost:3306/library?autoReconnect=true&useSSL=false", "root", "");
		
		String sql = "SELECT BookName,amount FROM books";
		
		PreparedStatement p1 =bag.prepareStatement(sql);
		
		ResultSet sonuc = p1.executeQuery();
		System.out.print("Stock "+"   --------    Name");
		System.out.println("\n");
	      while (sonuc.next()) {
              String name = sonuc.getString("BookName");
              int amount = sonuc.getInt("amount");
              System.out.println(amount+"\t\t\t   "+ name);
          }
		bag.close();
		p1.close();
		
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static void list_genres() {
		try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		Connection bag = DriverManager.getConnection("jdbc:mysql://localhost:3306/library?autoReconnect=true&useSSL=false", "root", "");
		
		String sql = "SELECT * FROM genre";
		
		PreparedStatement p1 =bag.prepareStatement(sql);
		
		ResultSet sonuc = p1.executeQuery();
		System.out.print("Genre_ID "+"   ------    Genre");
		System.out.println("\n");
	      while (sonuc.next()) {
	    	  int genre_id = sonuc.getInt("genre_id");
              String genre_name = sonuc.getString("genre_name");
              System.out.println(genre_id+"\t\t\t\t"+ genre_name);
          }
		
		bag.close();
		p1.close();
		
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static void list_by_genres(int l) {
		try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		Connection bag = DriverManager.getConnection("jdbc:mysql://localhost:3306/library?autoReconnect=true&useSSL=false", "root", "");
		
		String sql = "SELECT BookName,amount FROM books WHERE genre_id=?";
		
		PreparedStatement p1 =bag.prepareStatement(sql);
		p1.setInt(1, l);
		ResultSet sonuc = p1.executeQuery();
		System.out.print("Amount "+"   ------     Book Name");
		System.out.println("\n");
	      while (sonuc.next()) {
	    	  int amount = sonuc.getInt("amount");
              String book_name = sonuc.getString("BookName");
              System.out.println(amount+"\t\t\t\t"+ book_name);
          }
		
		bag.close();
		p1.close();
		
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static void list_borrow() {
		try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		Connection bag = DriverManager.getConnection("jdbc:mysql://localhost:3306/library?autoReconnect=true&useSSL=false", "root", "");
		
		String sql = "SELECT borrow.checkout_id ,users.user_name ,books.BookName "
				+ "FROM books, borrow, users "
				+ "WHERE books.book_id=borrow.book_id AND users.user_id=borrow.user_id";
		
		PreparedStatement p1 =bag.prepareStatement(sql);
		System.out.println("Checkout ID  -------- User Name ---------Book Name");
		ResultSet sonuc = p1.executeQuery();
	      while (sonuc.next()) {
	    	  String user_name = sonuc.getString("user_name");
	    	  int checkout_id = sonuc.getInt("checkout_id");
              String name = sonuc.getString("BookName");
              System.out.println(checkout_id+"\t\t\t"+ user_name+"\t\t\t\t"+name);
          }
		bag.close();
		p1.close();
		
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static void list_borrow_hist(int user_id) {
		try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		Connection bag = DriverManager.getConnection("jdbc:mysql://localhost:3306/library?autoReconnect=true&useSSL=false", "root", "");
		
		String sql = "SELECT borrow_hist.checkout_date ,	users.user_name ,books.BookName "
				+ "FROM books, borrow_hist, users "
				+ "WHERE books.book_id=borrow_hist.book_id AND users.user_id=? AND borrow_hist.user_id=?";
		
		PreparedStatement p1 =bag.prepareStatement(sql);
		p1.setInt(1, user_id);
		p1.setInt(2,user_id);
		System.out.println("Checkout Date  -------- User Name ---------Book Name");
		ResultSet sonuc = p1.executeQuery();
	      while (sonuc.next()) {
	    	  String checkout_date = sonuc.getString("checkout_date");
	    	  String bookname = sonuc.getString("BookName");
              String user_name = sonuc.getString("user_name");
              System.out.println(checkout_date+"\t\t\t"+user_name +"\t\t"+bookname);
          }
		bag.close();
		p1.close();
		
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
