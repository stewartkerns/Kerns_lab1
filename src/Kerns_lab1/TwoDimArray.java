package Kerns_lab1;
import java.util.Scanner;
import java.util.Random;

public class TwoDimArray {
    public static void main(String[] args){
        Scanner keyboardIn = new Scanner(System.in);
        char userCont;
        do {
            System.out.print("Please input the size of array you would like " +
                    "(less than 100): ");
            int size = keyboardIn.nextInt();
            //consume the leftover \n
            keyboardIn.nextLine();
            int[][] randomArray = createArray(size);

            userCont = continuePrgrm(keyboardIn);
        } while(userCont == 'Y');
    }
    public static int[][] createArray(int size){
        final int MAX = 99;
        final int MIN = 0;
        Random rand = new Random();
        int arrFill;

        int[][] array = new int[size][size];
        for (int i = 0; i < size; i++){
            for (int j = 0; j < size; j++){
                arrFill = rand.nextInt((MAX - MIN) + 1) + MIN;
                array[i][j] = arrFill;
            }
        }
        return array;
    }
    public static int sumRows(int[] arr, int size){
        int sumRowsArr = 0;
        for (int i = 0; i < size; i++){
            sumRowsArr += arr[i];
        }
        return sumRowsArr;
    }

    public static int sumCol(int[][] arr, int col){
        int sumColArr = 0;
        for (int i = 0; i < arr.length; i++){
            sumColArr += arr[i][col];
        }
        return sumColArr;
    }

    public static int sumDiag1(int[][] arr){
        int sumDiagArr = 0;
        for (int i = 0; i < arr.length; i++){
            sumDiagArr += arr[i][i];
        }
        return sumDiagArr;
    }

    public static int sumDiag2(int[][] arr){
        int sumDiagArr = 0;
        for (int i = 0; i < arr.length; i++){
            sumDiagArr += arr[arr.length - i - 1][i];
        }
        return sumDiagArr;
    }
    public static char continuePrgrm(Scanner keyboardIn){
        System.out.print("Would you like to run the program again? (Y/N): ");
        return keyboardIn.nextLine().toUpperCase().charAt(0);
    }

}
