// Gavin Stuart and Caroline El Jazmi
// (Date)
// CS 145 - Lab 3: Letter Inventory

// This programs output keeps track of an inventory of letters of the alphabet.
// It computes how many of each letter are in the String and keeps track of how many
// of each individual letters that the string posses (how many a's, how many b's, etc).
// The program ignores the case of the letters and anything that is not an alphabetic 
// character ( e.g., punctuation characters, digits, etc).


public class LetterInventory{

   private int size;
   private int[] inventory;
   private int[]alphabet = new int[26];
   
   
   public LetterInventory(String data) {
      inventory = new int[alphabet];
      data = data.toLowerCase();
      
      for(int index=0; index<letters.length();index++){
      if(data.charAt(index) - 'a'){
         alphabet[data - 'a']++;
         size++;
      }
      }
   }


   public int get(char letter){
      letter = Character.toLowerCase(letter);
      
      if(Character.isLetter(letter)){
            return alphabet[letter - 'a'];
    } else throw new IllegalArgumentException();
   }

   public void set(char letter, int value){
      letter = Character.toLowerCase(letter);
      
      if(Character.isLetter(letter)){
         size = size - inventory[letter - 'a'] + value;
         inventory[letter - 'a'] = value;
   } else throw new IllegalArgumentException();
   }


   public int size(){
      return size;
   }



















}
