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
        Scanner keyboardIn = new Scanner(System.in);
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


    public static int sumCol(int[][] arr, int col, int size){
        int sumColArr = 0;
        for (int i = 0; i < size; i++){
            sumColArr += arr[i][col];
        }
        return sumColArr;
    }

    public static int sumDiag1(int[][] arr, int size){
        int sumDiagArr = 0;
        for (int i = 0; i < size; i++){
            sumDiagArr += arr[i][i];
        }
        return sumDiagArr;
    }

    public static int sumDiag2(int[][] arr, int size){
        int sumDiagArr = 0;
        for (int i = 0; i < size; i++){
            sumDiagArr += arr[size - i - 1][i];
        }
        return sumDiagArr;
    }
    public static char continuePrgrm(Scanner keyboardIn){
        System.out.print("Would you like to run the program again? (Y/N): ");
        return keyboardIn.nextLine().toUpperCase().charAt(0);
    }

    public static void printArr(int[][] arr, int size){
        for (int i = 0; i < size; i++){
            for (int j = 0; j < size; j++){
                System.out.print("\t" + arr[i][j]);
            }
            System.out.println("\t=\t" + sumRows(arr[i], size));
        }
        System.out.print(sumDiag2(arr, size));
        for(int i = 0; i < size; i++){
            System.out.print("\t" + sumCol(arr, i, size));
        }
        System.out.print("\t\t" + sumDiag1(arr, size));
        System.out.println();
    }

}
