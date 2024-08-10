package Library;

import java.util.Date;

public class Book {

   private  String title,author,isbn,genre ;
   private  Boolean isAvailable;
   private Date publishedDate;

    public Book(String title, String author, String isbn, String genre, Date publishedDate) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.genre = genre;
        this.isAvailable = true;
        this.publishedDate = publishedDate;
    }

    // getters and setters

    public String getTitle() {
        return title;
    }

    public void setTitle(String t){
        title = t ;
    }

    public Boolean getAvailable() {
        return isAvailable;
    }

    public void setAvailable(Boolean available) {
        isAvailable = available;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public Date getPublishedDate() {
        return publishedDate;
    }

    public void setPublishedDate(Date publishedDate) {
        this.publishedDate = publishedDate;
    }

    // functions

    public void borrowBook(){
        if (isAvailable) {
            isAvailable = false;
        } else {
            System.out.println("Book is already borrowed.");
        }
    }
    public void returnBook(){
        this.isAvailable = true ;
    }
    public Boolean isAvailable() {
        return this.isAvailable;
    }

    public String getDetails() {
        return title + " by " + author + " (ISBN: " + isbn + ")";
    }

    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", isbn='" + isbn + '\'' +
                ", isAvailable=" + isAvailable +
                ", publishedDate=" + publishedDate +
                ", genre='" + genre + '\'' +
                '}';
    }
}
