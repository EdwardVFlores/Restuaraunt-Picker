package FloresEdward1;
import java.io.*;
import java.util.Scanner;

/**
 * 
 * A restaurant picker for Jack and Emma which sorts a 2D array
 * 
 * @author Flores, Edward
 * @assignment CSCI 2912 Assignment 1
 * @date 09/08/2018
 * 
 */

public class FloresEdward1{

    public static void main(String[] args) {
        //Global objects
        Scanner answer = new Scanner(System.in);
        
        //Gets the number of streets and avenues for the 2D array
        int streets = 0;
        int avenues = 0;
        try{
            while (streets < 1){
                System.out.println("Enter the number of streets that are greater than 0");
                streets = answer.nextInt();
            }
            while (avenues < 1){
                System.out.println("Enter the number of avenues that are greater than 0");
                avenues = answer.nextInt();
            }
        }catch(Exception e){
            System.out.println("Whoops something went wrong with that input :( "
                    + "\nPlease enter an integer greater than 0."
                    + "\nError Message: " + e.getMessage());
            System.exit(0);
        }
        
        //Creates 2D array containing streets and avenues
        int[][] inputFileArray = new int[streets][avenues];
        
        //Gets the value for each index for the inputFileArray
        try{
            for(int i=0; i<streets;i++){
                for (int j=0; j<avenues;j++){
                    System.out.println("Enter restuaraunt #" +(j+1) + " on street #" + (i+1));
                    inputFileArray[i][j] = answer.nextInt();
                }
            }
        }catch(Exception e){
            System.out.println("Whoops something went wrong with that input :( "
                    + "\nPlease enter an integer greater than 0."
                    + "\nError Message: " + e.getMessage());
            System.exit(0);
        }
        
        //Creating the restuaraunts text file to put the array in
        PrintWriter txtFile = null;
        try {
            txtFile = new PrintWriter(new FileOutputStream("restuaraunts.txt"));
        }
        catch(FileNotFoundException e){
            System.out.println("Error opening the file out restuaraunts.txt" + e.getMessage());
            System.exit(0);
        }
        
        //Writing to the restuaraunts text file
        txtFile.println(streets + " " +avenues);
        
        for (int i=0; i<inputFileArray.length;i++) {
            for(int j=0;j<inputFileArray[i].length;j++){
                txtFile.print(inputFileArray[i][j] + " ");
            }
            txtFile.println();
        }
        txtFile.close();
        
        //Sorts the 2D array to get the desired restuaraunt
        
        int price = 0;
        
        for (int i=0; i<inputFileArray.length;i++) {
            theEmmaSort(inputFileArray[i]);
            int min=inputFileArray[i][0];
            for(int j=0;j<inputFileArray[i].length;j++){
                if(inputFileArray[i][j]<min){
                    min = inputFileArray[i][j];
                }
            }
            if(inputFileArray[i][0]>price){
                price = inputFileArray[i][0];
            }
        }
        System.out.println("\n\n\nCost of Dinner: " + price);
    }
    
    //The Selection Sort method for the 2D array
    private static int[] theEmmaSort(int[] Score) {
        for(int i = 0; i<Score.length;i++)
        {   int min=Score[i];
            int index = i; 
            for(int j = i + 1; j<Score.length; j++)
            {
                if(Score[j]<min) {
                    index = j;
                    min = Score[j];
                } 
            }
            Score[index]=Score[i];
            Score[i] = min;
        }
    
        return Score;
    }
}