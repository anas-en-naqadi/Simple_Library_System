import Library.*;

import java.util.Date;
import java.util.Optional;
import java.util.Scanner;
import java.util.UUID;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        int choice = 0;
        System.out.println("create your library");
        Scanner scanner = new Scanner(System.in);
        System.out.println("add name of the library");
        String lib_name = scanner.nextLine();
        Library lib = new Library(lib_name);
        System.out.println("now add a librarian");
        System.out.println("Enter the name of the librarian:");
        String name = scanner.nextLine();

        // Generate a random UUID as a user ID
        String userId = UUID.randomUUID().toString();

        System.out.println("Enter the email of the librarian:");
        String email = scanner.nextLine();

        System.out.println("Enter the password for the librarian:");
        String password = scanner.nextLine();

        Librarian librarian = new Librarian(name, userId, email, password);
        Catalog london_catalog = new Catalog();


        while (choice != 7) {

            System.out.println("-----------------------------");
            System.out.println("1-add a member");
            System.out.println("2-add a book");
            System.out.println("3-show librarian details");
            System.out.println("4-show all books");
            System.out.println("5-show all members");
            System.out.println("6-i am a member");
            System.out.println("7-exit");

            choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1:
                    System.out.println("Enter the name of the Member:");
                    String m_name = scanner.nextLine();

                    // Generate a random UUID as a user ID
                    String m_userId = UUID.randomUUID().toString();

                    System.out.println("Enter the email of the Member:");
                    String m_email = scanner.nextLine();

                    System.out.println("Enter the password for the Member:");
                    String m_password = scanner.nextLine();
                    System.out.println("what is the max of borrowed books:");
                    int maxBor = scanner.nextInt();
                    Member m1 = new Member(maxBor, m_name, m_userId, m_email, m_password);
                    lib.addMember(m1);
                    break;

                case 2:

                    System.out.println("Enter the title of the book:");
                    String b_title = scanner.nextLine();
                    System.out.println("Enter the author of the book:");

                    // Generate a random UUID as a user ID
                    String b_author = scanner.nextLine();

                    String b_isbn = UUID.randomUUID().toString();

                    System.out.println("Enter the type for the book:");
                    String b_genre = scanner.nextLine();
                    Book b1 = new Book(b_title, b_author, b_isbn, b_genre, new Date());
                    librarian.addBook(b1, london_catalog);
                    break;
                case 4:
                    System.out.println(london_catalog.getAvailableBooks());
                    System.out.println();

                    break;
                case 5:
                    System.out.println(lib.getAllMembers());
                    System.out.println();

                    break;
                case 6:
                    System.out.println("what is your email");
                    String c_email = scanner.nextLine();
                    System.out.println("what is your password");
                    String pass = scanner.nextLine();
                    Optional<Member> matchingMember = lib.getAllMembers().stream().filter(member -> member.getEmail().equalsIgnoreCase(c_email)).findFirst();
                    if (matchingMember.isPresent()) {
                        Member member = matchingMember.get();
                        if (member.getPassword().equals(pass) && member.getRole().equals("Member")) {
                            int m_choice = 0;
                            System.out.println("Welcome " + member.getName());
                            System.out.println();
                            while (m_choice != 5) {

                                System.out.println("-----------------------------");
                                System.out.println("1-borrow a book");
                                System.out.println("2-return a book");
                                System.out.println("3-find a book");
                                System.out.println("4-show borrowed books");
                                System.out.println("5-exit");

                                m_choice = scanner.nextInt();
                                scanner.nextLine();
                                switch (m_choice) {
                                    case 1:
                                        System.out.println("1-title of the book");
                                        String b_name1 = scanner.nextLine();
                                        Optional<Book> matchingBook = london_catalog.getAvailableBooks().stream().filter(book -> book.getTitle().equalsIgnoreCase(b_name1)).findFirst();
                                        if (matchingBook.isPresent()) {
                                            Book book = matchingBook.get();
                                            member.borrowBook(book);

                                        } else {
                                            System.out.println("this book is not available");

                                        }
                                        break;
                                    case 2:
                                        System.out.println("1-title of the book");
                                        String b_name2 = scanner.nextLine();
                                        Optional<Book> matchingBook2 = member.getBorrowedBooks().stream().filter(book -> book.getTitle().equalsIgnoreCase(b_name2)).findFirst();
                                        if (matchingBook2.isPresent()) {
                                            Book book = matchingBook2.get();
                                            member.returnBook(book);

                                        } else {
                                            System.out.println("this book isnt the one you had borrowed");

                                        }
                                        break;
                                    case 3:
                                        System.out.println("1-title of the book or of the author");
                                        String b_name3 = scanner.nextLine();
                                        london_catalog.searchBook(b_name3);
                                        break;
                                    case 4:
                                        System.out.println(member.getBorrowedBooks());
                                        break;
                                    default:
                                        choice = 5;
                                        break;

                                }
                            }
                        } else {
                            System.out.println("the password is incorrect or you are not a Member");

                        }

                    } else {
                        System.out.println("you are not a member in this library or your email is incorrect");
                    }
                    break;
                case 3:
                    System.out.println(librarian);
                    break;

                default:
                    choice = 7;
                    break;
            }
        }


    }
}