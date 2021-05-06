//This class defines the phonebook node. The class contains common phone book feilds. 
//Feilds include firstName, lastName, userEmail, phoneNumber, city, and address. 
public class listNode {

    // feilds for phonebook
    private String firstName;
    private String lastName;
    private String userEmail;
    private String phoneNumber;
    private String userCity;
    private String userAddress;

    // is protected correct?
    protected ListNode phonebookList;


    //a call to listNode is set to null at the end
    public listNode() {
        this(0, null);
    }

    public listNode(int data) {
        this(data, null);
    }
    
    public listNode(String FN, String LN, String UE, String PN, String UC, String UA) {
        this.firstName = FN;
        this.lastName = LN;
        this.userEmail = UE;
        this.phoneNumber = PN;
        this.userCity = UC;
        this.userAddress = UA;
    }

    

}
