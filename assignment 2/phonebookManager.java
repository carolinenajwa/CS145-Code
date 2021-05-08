//This class is called by TestClass to manage data in the listNode class. 
//Needs 
//-Add - DONE
//-Get - DONE
//-Delete 
//-Modify 
//-isEmpty


public class PhoneBookManager {
    private LinkedList<Phonebook> entry = new LinkedList<>();

    // Get contact
    public LinkedList<Phonebook> getEntry() {
        return entry;
    }
    
    // Set Contact
    public void setEntry(LinkedList<Phonebook> entry) {
        this.entry = entry;
    }

    // Amount of contacts in phonebook
    public int size() {
        return entry.size();
    }

    // Add new contact to PhoneBook
    public void addEntry() {
        LinkedList<String> stringLinkedList = new LinkedList<>();
        Scanner console = new Scanner(System.in);

      System.out.println("Add New Contact");
      System.out.print("Enter Full Name: ");
      String name = console.nextLine();
      System.out.print("Enter Email: ");
      String email = console.nextLine();
      System.out.print("Enter Phone Number: ");
      String phoneNumber = console.nextLine();
      System.out.print("Enter City: ");
      String city = console.nextLine();
      System.out.print("Enter Address: ");
      String address = console.nextLine();
      
      entry.add(new Phonebook(name, email, phoneNumber, city, address));
      System.out.println("New Contact Saved");   
    }

    // Display contacts in phonebook with index.
    // If Phonebook is empty return "Directory is Empty"
    public void displayDirectory () {
        int index = 0;
        for (PhoneBook p: entry) {
            System.out.println(index + ": " p.getName() + "-" + p.getEmail() + "-" + p.getPhoneNumber() + "-" + p.getCity() + "-" + p.getAddress());
            index++;
        }
        if(entry.size() == 0) {
            System.out.println("Directory is Empty");
        }
    }

