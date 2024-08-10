package Library;

import java.util.List;

public class Librarian extends User {

    public Librarian(String name, String userId, String email, String password) {
        super(name, userId, email, password);
    }

    public void addBook(Book book, Catalog catalog) {
        catalog.addBook(book);
    }

    public void removeBook(Book book, Catalog catalog) {
        catalog.removeBook(book);
    }

    public void updateBook(Book oldBook, Book newBook, Catalog catalog) {
        catalog.removeBook(oldBook);
        catalog.addBook(newBook);
    }

    public List<Book> searchBooks(String query, Catalog catalog) {
        return catalog.searchByTitle(query);
    }


    public String getRole() {
        return "Librarian";
    }

    @Override
    public String toString() {
        return "Librarian{" + super.toString() + "}";
    }
}
