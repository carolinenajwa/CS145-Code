// Gavin Stuart and Caroline El Jazmi
// (Date)
// CS 145 - Lab 3: Letter Inventory

// This program's output keeps track of an inventory of letters of the alphabet.
// It computes how many of each letter are in the given String and keeps track of how many
// of each individual letters occures in the string (how many a's, how many b's, etc).
// The program ignores the case of the letters and anything that is not an alphabetic 
// character ( e.g., punctuation characters, digits, etc).

// Public Class
public class LetterInventory {

 // Stores size of LetterInventory, the occurance of each letter
 // and number of letters in the alphabet.
 private int size;
 private int[] inventoryData;
 private int[] alphabet = new int[26];


 // Constructs an inventory (inventoryData) of the alphabetic letters in the given string 
 // and counts the number of times each letter appears, ignoring the case of the letter and
 // ignoring any non-alphabetic characters. 
 public LetterInventory(String data) {
      inventoryData = new int[alphabet];
      data = data.toLowerCase();
        
      for (int index = 0; index < data.length(); index++) {
         if (data.charAt(index) - 'a' >= 0 && data.charAt(index) - 'a' < alphabet) {
            int temp  = data.toLowerCase().charAt(index) - 'a';
            inventoryData[temp]++;
            size++;
         }
      }
 }
 
 // Returns count of how many letters are in inventory,
 // throws an IllegalArgumentException if non-alphabetic character is passed. 
 public int get(char letter) {
      letter = Character.toLowerCase(letter);
      
      if(Character.isLetter(letter)){
         return alphabet[letter - 'a'];
    } else throw new IllegalArgumentException();
      }
      
      
 // Sets the count for the given letters to the given value.
 // If the character is not a letter or the value is negative, it 
 // throws an IllegalArgumentException
 public void set(char letter, int value){
      letter=Character.toLowerCase(letter);
      
      if(Character.isLetter(letter)){
         alphabet[letter - 'a'] = value;
         size = size - alphabet[letter - 'a'] + value;
     }else throw new IllegalArgumentException();
 }

 // Stores and returns size of the inventory
 public int size(){
      return size;
 }

}




