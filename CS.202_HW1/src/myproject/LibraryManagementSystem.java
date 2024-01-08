package myproject;
import java.io.*;
import java.util.Scanner;

public class LibraryManagementSystem {

	public static void main(String[] args) throws IOException {
		
		Scanner sc = new Scanner(System.in);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter the number of the operation...");
		
		System.out.println("1. Add User(name, email, address)");
		System.out.println("2. Remove User(user id)");
		System.out.println("3. Create Book(name, amount, genre(must be selected from a list))");
		System.out.println("4. Remove Book(book id)");
		System.out.println("5. List all books with stock info");
		System.out.println("6. List all books from a Specific Genre, with stock info(genre_id)");
		System.out.println("7. Get Currently Borrowed Books");
		System.out.println("8. Get Currently Borrowed and Borrow History of a User(user_id)");
		System.out.println("9. Checkout book(book_id, user_id)");
		System.out.println("10.Return Book(checkout_id)");
		
		int op = sc.nextInt();
	while(true)	
		if(op==1) {
			
					System.out.println("Enter User Name: ");
					String name = br.readLine();
					System.out.println("Enter User Email: ");
					String email = br.readLine();
					System.out.println("Enter User Adress: ");
					String adress = br.readLine();
					Insert I = new Insert();
					I.add(name, email, adress);
					break;
					
		} else if (op==2) {
			
					System.out.println("Enter the ID of the user you want to remove...");
					int userID = Integer.parseInt(br.readLine());
					Delete d = new Delete();
					boolean b = d.Del(userID);
					System.out.println("The operation has been completed.");
					break;
					
		} else if (op==3) {
			
			System.out.println("Please select the genre of the book...");
			List l = new List();
			l.list_genres();
			int genre_num = sc.nextInt();
			if(genre_num<1 || genre_num >6) {
				System.out.println("There is no genre assigned for number "+genre_num);
				break;
			}
			System.out.println("Type the name of the book... ");
			String book_name = br.readLine();
			System.out.println("Please write the amout of the book... ");
			int book_amount =sc.nextInt() ;
			Insert_Book IB = new Insert_Book();
			IB.add_book(book_name, book_amount, genre_num);
			break;
			
		} else if (op==4) {
			
			System.out.println("Enter the Book ID of the book you want to remove...");
			int userID = Integer.parseInt(br.readLine());
			Delete d = new Delete();
			boolean b = d.Del_Book(userID);
			System.out.println("The operation has been completed.");
			break;
			
		} else if (op==5) {
			
			List l = new List();
			l.list();
			break;
			
		} else if (op==6) {
			
			System.out.println("Please select the genre you want to list...");
			List l = new List();
			l.list_genres();
			int genre_num = sc.nextInt();
			l.list_by_genres(genre_num);
			break;
			
		} else if (op==7) {
			
			List l = new List();
			l.list_borrow();
			break;
			
		} else if (op==8) {
			
			System.out.println("Please type the User ID you want to display...");
			int id=sc.nextInt();
			List l = new List();
			l.list_borrow_hist(id);
			break;
			
		} else if (op==9) {
			
			System.out.println("Please type the User Id of the borrower...");
			int id=sc.nextInt();
			System.out.println("Please type the id of the book...");
			int id2=sc.nextInt();
			Insert I = new Insert();
			I.checkout_book(id2, id);
			I.insert_hist(id2,id);
			I.Minus_One(id2);
			break;
			
		} else if (op==10) {
			
			System.out.println("Please type the Checkout Id...");
			int id=sc.nextInt();
			System.out.println("Please type the Book Id...");
			int id2=sc.nextInt();
			Delete del= new Delete();
			del.Book_Return(id);
			Insert I = new Insert();
			I.Plus_One(id2);
			break;
			
		} else {
			
			System.out.println("There is no operation for number "+op);
			break;
			
		}
	
		
	}

}
