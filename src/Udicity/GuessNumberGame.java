package Udicity;
import java.util.Scanner;
//This is a small, console game
public class GuessNumberGame {
    public static void main (String... args){
        System.out.println("I have choose a number between 1 and 100 \n try to guess it!");
        int randomInt = (int) (Math.random() * 100 +1);
        boolean hasWon = false;
        Scanner scn = new Scanner(System.in);

        for (int i=10; i>0; i--){
            System.out.println("You have " + i + " attempts left: ");
            int guess = scn.nextInt();

            if (guess < randomInt)
                System.out.println("The number is Bigger then " + guess);
            else if (guess > randomInt)
                System.out.println("The number is Smaller then " + guess);
            else if (guess == randomInt){
                System.out.println("Correct!");
                hasWon = true;
                break;
            }
        }
        if (hasWon){
            System.out.println("You have won!");
        }else System.out.println("You have lost! \n The number was " + randomInt);
    }
}
