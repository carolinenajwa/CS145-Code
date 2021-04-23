import java.util.Random;
import java.util.Stack;

//plays a game of go fish
//52 cards 
//point is to get 4 of the same card
//each player has 7 cards


//ace 
//2-10
//jack
//queen
//king


//shuffle cards into a 52 card stack/queue


//deal cards 7 to each player array


//Stack 
//|A|
//|B|
//|C|



public class GoFish {
    public static void main(String[] args) {


        Stack<String> cardStack = new Stack<String>();
        Rand rand = new Random();
        


    }

    public static 



   
    //add a card to the stack
    public static void addCard(Stack cardStack, String card) {
        cardStack.push(card);
    }

    //get the top card from the stack
    public static String removeCard(Stack cardStack) {
        return cardStack.pop();
    }

    //check the top card in the stack
    public static String peekCard(Stack cardStack) {
        return cardStack.peek();
    }




}