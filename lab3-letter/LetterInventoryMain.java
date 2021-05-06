// Gavin Stuart and Caroline El Jazmi
// 5/4/2021
// CS 145 - Lab 3: Letter Inventory

// This programs output keeps track of an inventory of letters of the alphabet.
// It computes how many of each letter are in the String and keeps track of how many
// of each individual letters that the string posses (how many a's, how many b's, etc).
// The program ignores the case of the letters and anything that is not an alphabetic 
// character ( e.g., punctuation characters, digits, etc).

public class LetterInventory {

   // Private fields to store string size, letter inventory,
   // and number of letters in the alphabet
   private int size;
   private int[] inventory;
   private int[] alphabet = new int[26];

   // Constructs an inventory of the alphabetic letters in given string, sets the
   // case of the letters to lower case and ignores non-alphabetic characters.
   public LetterInventory(String data) {
      inventory = new int[alphabet];
      data = data.toLowerCase();

      for (int index = 0; index < alphabet.length(); index++) {
         if (data.charAt(index) - 'a') {
            alphabet[data - 'a']++;
            size++;
         }
      }
   }

   // Returns a count of how many of this letter are in the inventory, ignoring
   // case. Throws an IllegalArgumentException if non-alphabetic character.
   public int get(char letter) {
      letter = Character.toLowerCase(letter);

      if (Character.isLetter(letter)) {
         return alphabet[letter - 'a'];
      } else
         throw new IllegalArgumentException();
   }

   // Sets the value to each letter in the inventory in order to create a count.
   // Throws an Illegal ArgumentException if non-alphabetic character.
   public void set(char letter, int value) {
      letter = Character.toLowerCase(letter);

      if (Character.isLetter(letter)) {
         size = size - inventory[letter - 'a'] + value;
         inventory[letter - 'a'] = value;
      } else
         throw new IllegalArgumentException();
   }

   // Returns an intenger that represents the sum of the
   // counts in the inventory.
   public int size() {
      return size;
   }

   // returns true if all values are empty, else return false
   public boolean isEmpty() {

      // sum the array
      IntStream stream = Arrays.stream(alphabet);
      int sum = stream.sum();

      // check that sum
      if (sum > 0) {
         return false;
      } else {
         return true;
      }
   }

   // Returns a String representation of the inventory with the letters
   // all in lowercase and in sorted order and surrounded by square brackets.
   public String toString() {
      // open the brackets
      System.out.print("[");

      // print the chars
      for (int i : inventory) {

      }

      // close the brackets
      System.out.println("]");
   }

   // Constructs and returns a new LetterInventory object that represents
   // the sum of this letter inventory and the other given LetterInventory.
   public LetterInventory add(LetterInventory other) {
      int addSize = this.size + other.size;
      return addSize;
   }

   // Constructs and returns a new LetterInventory object that represents
   // the result of subtracting the other inventory from this inventory
   public LetterInventory subtract(LetterInventory other) {
      int addSize = this.size - other.size;

      if (addSize < 0) {
         return null;
      }

      return addSize;
   }

}
