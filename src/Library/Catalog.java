package Library;

import java.util.*;

public class Catalog {

    private List<Book> books;
    private ArrayList<Book> results;
    //constructor

    public Catalog() {
        books = new ArrayList<Book>();
        results = new ArrayList<Book>();
    }
     public void addBook(Book book){
        books.add(book);
    }
     public void removeBook(Book book){
        if(books.contains(book))
            books.remove(book);
    }
   public List<Book> searchByTitle(String title){
       isClear();
        for(Book b : books){
            if(b.getTitle().toLowerCase().contains(title.toLowerCase()))
               results.add(b);

        }
        return results;
    }
    public void searchBook(String title){
       Book f_book = null ;
        for(Book b : books){
            if(b.getTitle().equalsIgnoreCase(title))
                f_book = b;
        }
        if(f_book != null){
            System.out.println("Book found: " + f_book.getTitle());
        // You can add more actions here if needed, e.g., display book details
    } else {
        System.out.println("No book found with the title: " + title);
    }

    }
 public   List<Book> searchByAuthor(String author){
      isClear();
        for(Book b : books){
            if(b.getAuthor().toLowerCase().contains(author.toLowerCase()))
                results.add(b);

        }
        return results;
    }
  public  List<Book> searchByGenre(String genre){
        isClear();
        for(Book b : books){
            if(b.getGenre().toLowerCase().contains(genre.toLowerCase()))
                results.add(b);

        }
        return results;
    }
    public List<Book> getAvailableBooks(){
       return books;
    }
    // functions
     void isClear(){
        if(!results.isEmpty())
            results.clear();
    }



}
