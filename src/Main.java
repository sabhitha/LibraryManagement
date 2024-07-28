import org.Book.Inventory;
import org.Driver.Driver;
import org.Library.Library;
import org.users.Membership;
import org.users.Users;

import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {


    public static void main(String[] args) {
        Membership member = new Membership();
        Inventory inventory = new Inventory();
        Library library = new Library();
        Driver driver = new Driver();        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        System.out.printf("Welcome to Ohara Library!");
        driver.addBooks(inventory);
        Scanner input = new Scanner(System.in);
        System.out.println("Please select any one option given below");
        Users user;
        while(true){
            System.out.println("1. New user? Click here to join as a member.");
            System.out.println("2. Are you an existing member? Click here to explore books and borrow them");
            System.out.println("3. Exit");
            int option = input.nextInt();
            switch (option){
                case 1:
                    user = driver.addUser(member);
                    member.setUser(user);
                    break;
                case 2:
                    driver.existingMember(member, inventory, library);
                    break;
                case 3:
                    input.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println("Please select any one option given below");
                    break;
            }
        }
    }

}