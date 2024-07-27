package org.Driver;

import org.Book.Books;
import org.Book.Inventory;
import org.Library.Library;
import org.users.Membership;
import org.users.Users;

import java.util.List;
import java.util.Scanner;

public class Driver {

    public Users addUser(Membership member){
        System.out.println("Please enter your name");
        Scanner input = new Scanner(System.in);
        String name = input.next();
        System.out.println("Please enter your Age");
        int age = input.nextInt();
        if(age < 18){
            System.out.println("Sorry "+ name + " minimum age to enter is 18");
            return null;
        }
        System.out.println("Please provide any identification number");
        String id = input.next();
        System.out.println("Please enter your address");
        String address = input.next();
        Users user = new Users(name, age, id, address);
        System.out.println(member.addMember(user));
        return user;
    }

    public void existingMember(Membership member, Inventory inventory, Library library){
        System.out.println("Please enter your name");
        Scanner input = new Scanner(System.in);
        String name = input.nextLine();
        System.out.println("Hello " +name+"! Please select any one option given below");
        while(true){
            if(member != null){
                System.out.println("Hello " +name+"! Please select any one option given below");
                System.out.println("1. Search available Books");
                System.out.println("2. Return book lent");
                System.out.println("3. Borrow book");
                System.out.println("4. Exit");
                int option = input.nextInt();
                switch (option) {
                    case 1:
                        System.out.println("Please enter name or author of book");
                        printBooks(inventory.getRelatedBookDetails(input.next()));
                        break;
                    case 2:
                        System.out.println("Please enter name of the book");
                        Books book = inventory.findBook(input.next());
                        if(book != null){
                            library.returnBook(book, member.getUser(), inventory);
                        }else {
                            System.out.println("Book you are returning doesn't match with our records.Please check the book you are returning");
                        }
                        break;
                    case 3:
                        System.out.println("Please enter name of the book");
                        Books books = inventory.findBook(input.next());
                        if(library.checkoutBook(books, member, inventory)){
                            System.out.println("Book your looking for is available, please make sure to return without any damage");
                        }else{
                            System.out.println("Book you are looking is not available now, sorry for inconvenience");
                        }
                        break;
                    case 4:
                        System.out.println("Thanks for visiting!");
                        System.exit(1);
                        break;
                    default:
                        System.out.println("Please enter any option from 1-4");
                        break;
                }
            }
        }
    }

    public static void printBooks(List<Books> books){
        for(Books book: books){
            int i = 1;
            System.out.println(i +"."+ book.getTitle() +", "+book.getAuthor()+", "+ book.getPublicationYear());
        }
    }
    // populates some books in library
    public void addBooks(Inventory inventory){
        Books book = new Books("The stand", "Stephen king", "12", 1996);
        inventory.addBook(book, 10);
        Books book1 = new Books("1984", "George Orwell", "13", 1998);
        inventory.addBook(book1, 10);
        Books book2 = new Books("The end of eternity", "Issac Asimo", "14", 2000);
        inventory.addBook(book2, 10);
        Books book3 = new Books("Fire and Blood", "George RR Martin", "14", 1998);
        inventory.addBook(book3, 10);
        Books book4 = new Books("kafka", "Haruki Murakami", "15", 1994);
        inventory.addBook(book4, 10);
        Books book5 = new Books("Fantastic Beasts", "JK Rowling", "15", 1994);
        inventory.addBook(book5, 10);
    }
}
