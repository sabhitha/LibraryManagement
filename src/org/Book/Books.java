package org.Book;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Books {
    //attributes such as title, author, ISBN, and publication year.
    String title;
    String author;
    String ISBN;
    int publicationYear;
    public boolean isAvailable = true;

    private Map<Books, List<String>> history = new HashMap<>();
    public Books(String title, String author, String ISBN, int publicationYear) {
        this.title = title;
        this.author = author;
        this.ISBN = ISBN;
        this.publicationYear = publicationYear;
    }

    public List<String> getHistory() {
        return history.getOrDefault(this, null);
    }

    public void setHistory(String userName) {
        if(getHistory() != null){
            List<String> usersBorrowed = getHistory();
            usersBorrowed.add(userName);
            history.put(this, usersBorrowed);
        }
    }

    public List<String> getUsersLent(){
        return history.getOrDefault(this, null);
    }

    public Books() {
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getISBN() {
        return ISBN;
    }

    public int getPublicationYear() {
        return publicationYear;
    }

}
