public class TestClass {

    //main to test the main class
    public static void main(String[] args) {
        LetterInventory test = new LetterInventory("test");
        LetterInventory test2 = new LetterInventory("blah");
        LetterInventory l = test.add(test2);
        System.out.println(l.toString());
    }
}
