package Kerns_lab1;
import java.util.Scanner;   //import Scanner class
import java.util.Random;    //import Random class

/** This program allows the user to pick a size of an array and then the program
 * fills in an array of that size with random numbers.  It then prints out the
 * array, sum of the rows, columns, and main diagonals.  It runs as many times
 * as the user wants.
 *
 * @author Stewart Kerns
 * @version 1.0
 */
public class TwoDimArray {

    /** The main method calls the other methods of the program and allows the
     * user to run the program as many times as they would like
     *
     * @param args A string array containing the command line arguments
     */
    public static void main(String[] args){
        //create a scanner object to take in user input
        Scanner keyboardIn = new Scanner(System.in);
        welcome();      //print the welcome message
        //Provide the do while loop to allow the user to repeat the program
        do {
            //ask the user how large of an array to make
            System.out.print("Please input the size of array you would like " +
                    "(between 1 and 10): ");
            int size = keyboardIn.nextInt();
            //consume the leftover \n
            keyboardIn.nextLine();

            //create the array with random numbers
            int[][] randomArray = createArray(size);
            //print the array and sums
            printArr(randomArray, size);

        } while(continuePrgrm(keyboardIn) == 'Y');
        goodbye();      //print the goodbye message
        keyboardIn.close();     //close the Scanner object
    }

    /** This method creates the array of random numbers based off of the size
     * the user requested
     *
     * @param size how many rows and columns to make the array
     * @return the filled out array
     */
    public static int[][] createArray(int size){
        //create final ints for the min and max of the random numbers
        final int MAX = 99;
        final int MIN = 0;
        //create a random object
        Random rand = new Random();
        //declare an integer that will be used for filling the array
        int arrFill;
        //create a 2d array of the size the user requested
        int[][] array = new int[size][size];
        //create a nested for loop to fill in the array with random numbers
        for (int i = 0; i < size; i++){
            for (int j = 0; j < size; j++){
                arrFill = rand.nextInt((MAX - MIN) + 1) + MIN;
                array[i][j] = arrFill;
            }
        }
        return array;       //return the array
    }

    /**This method sums a single row of the array input
     *
     * @param arr an array input to be summed
     * @param size the original size of the array requested by the user
     * @return the sum of the array
     */
    public static int sumRows(int[] arr, int size){
        //create an int to hold the sum and initialize at 0
        int sumRowsArr = 0;
        //use a for look to sum the array input
        for (int i = 0; i < size; i++){
            sumRowsArr += arr[i];
        }
        return sumRowsArr;      //return the sum of the array
    }

    /** This method sums a column that is input from an array that is input
     *
     * @param arr the 2d array to be used to sum from
     * @param col which column of the array to sum
     * @param size the size of the array input by the user
     * @return the sum of the column requested
     */
    public static int sumCol(int[][] arr, int col, int size){
        //create an int to hold the sum of the column
        int sumColArr = 0;
        //sum the column requested
        for (int i = 0; i < size; i++){
            sumColArr += arr[i][col];
        }
        return sumColArr;       //return the summed column
    }

    /** This method sums the main diagonal from top-left to bottom-right
     *
     * @param arr the array that the diagonal will be summed from
     * @param size the size of the array requested by the user
     * @return the summed diagonal
     */
    public static int sumDiag1(int[][] arr, int size){
        //create an int to hold the sum of the diagonal
        int sumDiagArr = 0;
        //use a for loop to sump the diagonal
        for (int i = 0; i < size; i++){
            sumDiagArr += arr[i][i];
        }
        return sumDiagArr;  //return the summed diagonal
    }

    /** This method sums the main diagonal from bottom-left to top-right
     *
     * @param arr the array that the diagonal will be summed from
     * @param size the size of the array requested by the user
     * @return the summed diagonal
     */
    public static int sumDiag2(int[][] arr, int size){
        //create an int to hold the sum of the diagonal
        int sumDiagArr = 0;
        //use a for loop to sum the diagonal
        for (int i = 0; i < size; i++){
            sumDiagArr += arr[size - i - 1][i];
        }
        return sumDiagArr;      //return the sum of the diagonal
    }

    /**This method asks the user if they want to run the program again and then
     * returns the letter that they selected
     *
     * @param keyboardIn a scanner object for reading input from the terminal
     * @return the first letter of the user input
     */
    public static char continuePrgrm(Scanner keyboardIn){
        //prompt the user to run the program again or not
        System.out.print("\n\nWould you like to run the program again?(Y/N): ");
        //return the first letter of their answer
        return keyboardIn.nextLine().toUpperCase().charAt(0);
    }

    /**This method prints out the entire array, the sum of each row, column, and
     * main diagonal
     *
     * @param arr the array that will be used and printed
     * @param size the size input by the user
     */
    public static void printArr(int[][] arr, int size){
        //create a nested for loop to print out the array itself
        for (int i = 0; i < size; i++){
            for (int j = 0; j < size; j++){
               System.out.printf("\t%-3d", arr[i][j]);
            }
            // print out the sum after each row
            System.out.printf("\t=\t%-3d\n", sumRows(arr[i], size));
        }
        //print out the bottom-left to top-right diagonal sum
        System.out.printf("%-3d", sumDiag2(arr, size));
        //print out each of the column sums
        for(int i = 0; i < size; i++){
            System.out.printf("\t%-3d", sumCol(arr, i, size));
        }
        //print the top-left to bottom-right diagonal sum
        System.out.printf("\t\t%-3d", sumDiag1(arr, size));
    }

    /**This method prints a welcome message to the user
     *
     */
    public static void welcome(){
        //print the welcome message
        System.out.println("Welcome to TwoDimArray!\nThis program asks for " +
                "the array size of a 2d square array of integers, then\n" +
                "creates the square array, fills it with random numbers, " +
                "then prints it out along\nwith sums in both directions and " +
                "along the diagonals.\n");
    }

    /**This method prints a goodbye message to the user
     *
     */
    public static void goodbye(){
        //print the goodbye message
        System.out.println("\nThanks for using TwoDimArray!");
    }
}
