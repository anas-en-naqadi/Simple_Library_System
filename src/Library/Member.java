package Library;

import java.util.*;
import java.util.concurrent.TimeUnit;

public class Member extends User{

  private  List<Book> borrowedBooks;
  private int maxBooksAllowed;
  private double fineAmount;

  //
    public Member(int m,String n,String u,String e,String p){
        super(n,u,e,p);
        borrowedBooks = new ArrayList<>();
        maxBooksAllowed = m;
        fineAmount = 0;
    }

    public void borrowBook(Book book){
        if(borrowedBooks.size() < maxBooksAllowed && book.isAvailable()){
            book.borrowBook();
            borrowedBooks.add(book);
            System.out.println("the book has been borrowed successfully");

        }else {
            System.out.println("Cannot borrow more books or book is not available.");
        }
    }
    public void returnBook(Book book){
        if(borrowedBooks.contains(book)){
            book.returnBook();
            borrowedBooks.remove(book);
            System.out.println("the book has been returned successfully");

        }
        else {
            System.out.println("This book was not borrowed by the member.");
        }

    }

   public List<Book> getBorrowedBooks(){
        return borrowedBooks;
    }

    public double calculateFine(Book book, Date returnDate) {
        // Assuming the book was borrowed and not returned on time
        long diffInMillies = Math.abs(returnDate.getTime() - new Date().getTime());
        long diff = TimeUnit.DAYS.convert(diffInMillies, TimeUnit.MILLISECONDS);

        // Assume a fine rate of 2.0 currency units per day
        double fineRate = 2.0;
         fineAmount = diff * fineRate;

        return fineAmount;
    }
    public String getRole(){
        return "Member";
    }

    @Override
    public String toString() {
        return "Member{" +
                super.toString()+
                "borrowedBooks=" + borrowedBooks +
                ", maxBooksAllowed=" + maxBooksAllowed +
                ", fineAmount=" + fineAmount +
                '}';
    }
}
