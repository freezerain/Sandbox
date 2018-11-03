package Udicity;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;

//Game to guess movie name letter by letter

public class MovieGuessGame {
    public static void main(String...args){
        // Creating File Scanner and Array List
        Scanner scn = new Scanner(System.in);
        try{
            scn = new Scanner (new File("movies.txt"));
        }catch(FileNotFoundException exception){
            System.out.println("Cannot get file with movie titles.");
            System.exit(42);
        }
        ArrayList<String> titles = new ArrayList<>();

        //Adding line to array
        while(scn.hasNextLine()){
            titles.add(scn.nextLine());
        }
        if (titles.size()<1) System.exit(43); //Check if array contain something

        String movie = titles.get((int)(Math.random() * titles.size())); //pick random movie

        String gameLine ="";
        for (int i = 0; i<movie.length(); i++){
            gameLine += (movie.charAt(i) == ' ' ? " ":"_"); //Change to StringBuilder.append
        }
        System.out.println("I choose one random movie, try to find out it´s name!");
        scn = new Scanner(System.in);
        int letters = 0;
        for(int i = 0; i<gameLine.length(); i++){
            if (gameLine.charAt(i) == '_') letters++;
        }
        System.out.println("Movie name contain " + letters + " letters.");
        boolean win = false;
        System.out.println(gameLine);
        //System.out.println(movie);
        for(int guesses = 10; guesses >0; guesses--) {
            System.out.println("You have " + guesses + " life left: ");
            char guess = scn.next().charAt(0);
            char[] tempCharr = gameLine.toCharArray();
            char[] tempMov = movie.toCharArray();
            boolean founded = false;
            for(int i = 0; i<gameLine.length();i++){
                if(tempMov[i] == guess){
                    tempCharr[i] = guess;
                    founded = true;
                }
            }
            if(founded){
                gameLine = new String (tempCharr);
                System.out.println("Letter founded!");
                guesses++;
            }else System.out.println("Letter not founded!");
            System.out.println(gameLine);
            int lettersLeft = 0;
            for(int i = 0; i<gameLine.length(); i++){
                if (gameLine.charAt(i) == '_') lettersLeft++;
            }
            if(lettersLeft<=0){win = true; break;}
            System.out.println("You need to find " + lettersLeft + " more letters.");
        }
        if (win) System.out.println("Correct! The movie name is: " + movie);
        else System.out.println("Too bad! You have lost! The movie name was: " + movie);
    }
}
