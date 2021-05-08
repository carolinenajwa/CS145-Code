// Gavin Stuart and Caroline El Jazmi
// 5/7/2021
// CS 145 - Lab 3: Letter Inventory

// This programs output keeps track of an inventory of letters of the alphabet.
// It computes how many of each letter are in the String and keeps track of how many
// of each individual letters that the string posses (how many a's, how many b's, etc).
// The program ignores the case of the letters and anything that is not an alphabetic 
// character ( e.g., punctuation characters, digits, etc).

import java.util.Arrays;
import java.util.stream.IntStream;

public class LetterInventory {

   // Private fields to store string size, letter inventory,
   // and number of letters in the alphabet
   private int size;
   private String inventory;
   private int[] alphabet = new int[26];

   // Constructs an inventory of the alphabetic letters in given string, sets the
   // case of the letters to lower case and ignores non-alphabetic characters.
   public LetterInventory(String data) {

      //set inventory equal to data
      this.inventory = data.toLowerCase();

      //for each character in this.inventory
      for (int index = 0; index < inventory.length(); index++) {

         //if this is a character
         if (Character.isLetter(inventory.charAt(index))) {

            //what character are we dealing with?
            char c = inventory.charAt(index);

            //what is the index in alphabet of our character? 
            //we can discover the ascii code by using explicit
            // typecasting to get the char as an ascii int value
            // and subtracting 96
            int alphaIndex = (int)c - 96;
            
            alphabet[alphaIndex]++;
            
            this.size++;
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
         size -= alphabet[letter - 'a'] + value;
         alphabet[letter - 'a'] = value;
      } else
         throw new IllegalArgumentException();
   }

   // Returns an intenger that represents the sum of the
   // counts in the inventory.
   public int size() {
      return this.size;
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
      String toString = "[";

      // print the chars
      for (int i = 0; i < 25; i++) {
         if (alphabet[i] > 0) {
            for (int j = 0; j < alphabet[i]; j++) {
               toString += Character.toString(i + 96);
            }
         }  
      }

      // close the brackets
      toString += "]";

      return toString;
   }

   // Constructs and returns a new LetterInventory object that represents
   // the sum of this letter inventory and the other given LetterInventory.
   public LetterInventory add(LetterInventory other) {
      // create new letter inventory object
      LetterInventory add = new LetterInventory(inventory);

      // new object with sum of current inventory and new inventory(other)
      
         for(int index = 0; index < 25; index++){
            add.alphabet[index] += other.alphabet[index];

         }
      // return add
      return other;
   }

   // Constructs and returns a new LetterInventory object that represents
   // the result of subtracting the other inventory from this inventory
   public LetterInventory subtract(LetterInventory other) {
      return other;
   }

}
