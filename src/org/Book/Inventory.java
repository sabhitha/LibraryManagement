package org.Book;

import org.users.Users;

import java.util.*;

public class Inventory {
    private List<Books> availableBooks = new ArrayList<Books>();
    private Map<String, Integer> categorisation = new HashMap<String, Integer>();
    int totalCount;

    public List<Books> getAvailableBooks() {
        return availableBooks;
    }

    public void setAvailableBooks(List<Books> availableBooks) {
        this.availableBooks = availableBooks;
    }

    public Integer getCategorisation(String title) {
        return categorisation.getOrDefault(title, -1);
    }

    public void setCategorisation(Map<String, Integer> categorisation) {
        this.categorisation = categorisation;
    }

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    public int addBook(Books book, int bookQuantity){
        int availableCount = categorisation.getOrDefault(book.getTitle(), 0);
        availableCount += bookQuantity;
        availableBooks.add(book);
        categorisation.put(book.getTitle(), availableCount);
        totalCount += bookQuantity;
        if(!book.isAvailable){
            book.isAvailable = true;
        }
        return availableCount;
    }

    public int removeBook(String title, int bookQuantity){
        if(categorisation.getOrDefault(title, 0) == 0){
            return -1;
        } else {
           int updatedCount =  categorisation.get(title) - bookQuantity;
           categorisation.put(title, updatedCount);
           if(updatedCount == 0){
               //remove book from available books as its no longer available
               Books book = findBook(title);
               availableBooks.remove(book);
               book.isAvailable = false;
           }
           totalCount -= bookQuantity;
        }
        return bookQuantity;
    }

    public int updateBookDetails(Books oldDetails, Books newDetails){
        if(availableBooks.remove(oldDetails)){
            availableBooks.add(newDetails);
            return 1;
        }
        return -1; 
    }

    //To search any book with title/author/ISBN
    public List<Books> getRelatedBookDetails(String keyword){
        List<Books> matchedBooks = new ArrayList<Books>();
        for(Books b : availableBooks) {
            if (b.author.toLowerCase().startsWith(keyword) || b.ISBN.toLowerCase().startsWith(keyword) || b.title.toLowerCase().startsWith(keyword)) {
                matchedBooks.add(b);
            }
        }
        return matchedBooks;
    }

    //To find the exact book
    public Books findBook(String title){
        for(Books b : availableBooks){
            if(b.title.equalsIgnoreCase(title)){
                return b;
            }
        }
        return null;
    }
    //To directly update count for books
    public int updateBookQuantity(String title, int quantity){
        if(findBook(title) != null){
           int updatedCount = categorisation.get(title) + quantity;
           totalCount = totalCount - categorisation.get(title) + updatedCount;
           categorisation.put(title, updatedCount);
           return updatedCount;
        }
        return -1;
    }

}
