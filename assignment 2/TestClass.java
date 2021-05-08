// Test Class
// User Interface




import java.util.*;


public class TestClass {


      Scanner console = new Scanner(System.in);



 public static void main(String[] args) {
      LinkedList<TestClass> list = new LinkedList<>();
      int menuInput;
      Scanner console = new Scanner(System.in);
      boolean quit = false;
         
         do {
      
      
      System.out.println("Welcome to PhoneBook Manager!");
      System.out.println("Menu Options: ");
      System.out.println("1  (Add new contact)");
      System.out.println("2  (Display contact directory)");
      System.out.println("3  (Delete contact)");
      System.out.println("4  (Edit contact)");
      System.out.println("5  (Quit)");


      System.out.println("How can I help you today?");
      System.out.print("Enter Valid Command: ");
      menuInput = console.nextInt();
      

      switch (menuInput) {
      // Add contact
      case 1:
      PhoneBook.addEntry();      
      break;
     
      // Display contacts
      case 2:
      PhoneBook.displayDirectory();
      break;
                     
      // Delete contact
      case 3:
      PhoneBook.deleteEntry
      break;
      
      // TODO: Modify contact
      case 4:
      
      break;
      
      // Quit program   
      case 5:
      System.out.println("Goodbye!");
      quit = true;
      break;
      
      // Default - invalid input
      default:
      System.out.println("Invalid Input. Try Again!");
      }
 }while (!quit);
}
}
