package myproject;
import java.sql.*;
public class Insert_Book {
	public static void add_book(String BookName,int amount,int genre_id) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			Connection bag = DriverManager.getConnection("jdbc:mysql://localhost:3306/library?autoReconnect=true&useSSL=false", "root", "");
			String sql2 = "INSERT INTO books VALUES (NULL,?,?,?)";
			
			PreparedStatement p2 = bag.prepareStatement(sql2);
				p2.setString(1,BookName);
				p2.setInt(2, amount);
				p2.setInt(3, genre_id);
				
			int sonuc2= p2.executeUpdate();
		
			if(sonuc2==1) {
				System.out.println("The book has been added.");
			} else {
				System.out.println("The book couldn't have been added.");
			}
			p2.close();
			bag.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
}
}
