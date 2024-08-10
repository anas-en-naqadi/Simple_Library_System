package Library;

import java.util.*;

public class Library {
    private String name ;
    private List<Member> members;
    private List<Librarian> librarians;
    private Catalog catalog;

    //constructor

    public Library(String n){
        name = n ;
        catalog = new Catalog();
        members = new ArrayList<>();
        librarians = new ArrayList<>();
    }
    public void addMember(Member member){
        members.add(member);

    }
    public void removeMember(Member member){
        if(members.contains(member))
            members.remove(member);
        else
            System.out.println("This Member desnt exist in this library !!");
    }
    public void addLibrarian(Librarian librarian){
        librarians.add(librarian);
    }
    public void removeLibrarian(Librarian librarian){
        if(librarians.contains(librarian))
            librarians.remove(librarian);
        else
            System.out.println("This librarian doesnt exist in this library !!");
    }
   public Catalog getCatalog(){
        return catalog;
    }
    public List<Member> getAllMembers(){
        return members;
    }
    public List<Librarian> getAllLibrarians(){
        return librarians;
    }

}
