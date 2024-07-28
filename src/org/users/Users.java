package org.users;

import org.Book.Books;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Users {

    String name;
    int age;
    String id;
    String address;
    //int booksDue; // added to track overdue/ pending books
    public Map<Users, List<Books>> userBorrowingHistory = new HashMap<>();

    public Users(String name, int age, String id, String address) {
        this.name = name;
        this.age = age;
        this.id = id;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public List<Books> getBooksLent(Users user){
        return userBorrowingHistory.getOrDefault(user, null);
    }

    public void setUserBorrowingHistory(Users user, List<Books> books) {
        this.userBorrowingHistory.put(user, books);
    }

    public boolean borrowBook(Books book){
        List<Books> lentBooks = getBooksLent(this);
        if(lentBooks == null){
          lentBooks =  new ArrayList<Books>();
          lentBooks.add(book);
        }
       else if(lentBooks.size() >= 3){
            return false;
        }else {
            lentBooks.add(book);
        }
        setUserBorrowingHistory(this, lentBooks);
       return true;
    }

    public void returnBook(Books book){
        List<Books> lentBooks = getBooksLent(this);
        lentBooks.remove(book);
        setUserBorrowingHistory(this, lentBooks);
    }
}
