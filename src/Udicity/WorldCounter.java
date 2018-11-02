package Udicity;
import java.util.Scanner;
import java.io.File;

//Count how many worlds in file

public class WorldCounter {
    public static void main (String... args)throws Exception{
        File file = new File("30254-0.txt"); //path to file
        Scanner scn = new Scanner (file);
        int words = 0;
        while(scn.hasNextLine()){
            String line = scn.nextLine();
            words += line.split(" ").length;
        }
        System.out.println("The file contain " + words + " words.");


    }
}
