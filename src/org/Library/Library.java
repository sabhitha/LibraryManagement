package org.Library;

import org.Book.Books;
import org.Book.Inventory;
import org.users.Membership;
import org.users.Users;

import java.util.HashMap;
import java.util.Map;

public class Library {
    Books book = new Books();

    Map<Books, Users> lendingRecords = new HashMap<Books, Users>();

    public boolean checkoutBook(Books book, Membership member, Inventory inventory) {
        Users patron = member.getUser();
        if (member.getMember(patron.getName()) == null || inventory.getCategorisation(book.getTitle()) == -1) {
            return false;
        }
        inventory.removeBook(book.getTitle(), -1);
        lendingRecords.put(book, patron);
        book.setHistory(patron.getName());
        return patron.borrowBook(book);
    }

    public boolean returnBook(Books book, Users patron, Inventory inventory) {
        if (lendingRecords.containsKey(book) && lendingRecords.get(book).equals(patron)) {
           // book.setAvailable(true);
            lendingRecords.remove(book);
            inventory.addBook(book,1);
            patron.returnBook(book);
            return true;
        }
        return false;
    }
}
