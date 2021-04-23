import java.util.Stack;

//plays a game of go fish

public class GoFish {
    public static void main(String[] args) {
        Stack<E> cardStack = new Stack<String>();

        
    }

    public static void addCard(Stack cardStack, String card) {
        cardStack.push(card);
    }

    public static String removeCard(Stack cardStack) {
        return cardStack.pop();
    }

    public static String peekCard(Stack cardStack) {
        return cardStack.peek();
    }




}
