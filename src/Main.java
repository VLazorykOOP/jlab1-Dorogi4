import java.util.Scanner;
public class Main {
	
    public static double function1(double n, double m) {
        double result = ((n + 1) / (Math.pow(n, 2) * m + 2)) + ((m + n) / (m - n)) + (Math.pow(n, 3));
        return result;
    }

    public static double function2(int n, int m) {
        double result = ((n + 1) / (n * n * m + 2)) + ((m + n) / (m - n)) + (n * n * n);
        return result;
    }

    public static int function3(double n, double m) {
        int result = (int) (((n + 1) / (Math.pow(n, 2) * m + 2)) + ((m + n) / (m - n)) + (Math.pow(n, 3)));
        return result;
    }


    public static void main(String[] args) {

Scanner scan = new Scanner(System.in);

        System.out.println("First Example");
        System.out.print("Input n: ");

        while (!scan.hasNextDouble()){
            System.out.println("Please input a number!");
            scan.next();
        }
        double n = scan.nextDouble();

        System.out.print("Input n: ");
        while (!scan.hasNextDouble()){
            System.out.println("Please input a number!");
            scan.next();
        }
        double m = scan.nextDouble();

        while (n*m == 0){
            System.out.println("Please input new values.");
            System.out.print("Input new n: ");
            while (!scan.hasNextDouble()){
                System.out.println("Please input a number.");
                scan.next();
            }
            n = scan.nextDouble();

            System.out.print("Input new m: ");
            while (!scan.hasNextDouble()){
                System.out.println("Please input a number.");
                scan.next();
            }
            m = scan.nextDouble();
        }
        System.out.println("Example 1 result: " + function1(n,m));
        System.out.println("Example 2 result: " + function2((int)n,(int)m));
        System.out.println("Example 3 result: " + function3(n,m));

    }
}



//Exercise 2
import java.util.Scanner;
import java.util.Arrays;
public class AI {

    public static void main(String[] args) {


        Scanner in = new Scanner(System.in);
        int n = -1;
        while (n <= 0 || n > 200) {
            System.out.print("Input n<=200: ");
            if (in.hasNextInt()) {
                n = in.nextInt();
                in.nextLine();
                if (n <= 0 || n > 200) {
                    System.out.println("Invalid input, please try again.");
                }
            } else {
                System.out.println("Invalid input, please try again.");
                in.nextLine();
            }
        }
        int A[] = new int[n];
        for (int i = 0; i < A.length; i++) {
            boolean validInput = false;
            while (!validInput) {
                System.out.print("a["+i+"]= ");
                if (in.hasNextInt()) {
                    A[i] = in.nextInt();
                    validInput = true;
                    in.nextLine();
                } else {
                    System.out.println("Invalid input, please try again.");
                    in.nextLine();
                }
            }
        }
        System.out.print("A = ");
        for (int i = 0; i < A.length; i++) {
            System.out.print(A[i] +  " ");
        }


        int[] B = new int[n];
        int bIndex = 0;
        System.out.println(" ");

        for (int i = 0; i < n; i++) {
            int current = A[i];
            int count = 0;


            for (int j = i + 1; j < n; j++) {
                if (A[j] == current) {
                    count++;
                }
            }


            if (count > 0) {
                boolean found = false;
                for (int j = 0; j < bIndex; j++) {
                    if (B[j] == current) {
                        found = true;
                        break;
                    }
                }
                if (!found) {
                    B[bIndex] = current;
                    bIndex++;
                }
            }
        }

        System.out.print("Array B:");
        for (int i = 0; i < bIndex; i++) {
            System.out.print(" "+ B[i]);
            System.out.print(" ");



        }
        in.close();
    }

}

//Exercise 3
import java.util.Scanner;
public class ex31 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = -1;
        while (n <= 0 || n > 200) {
            System.out.print("Input positive: ");
            if (in.hasNextInt()) {
                n = in.nextInt();
                in.nextLine();
                if (n <= 0 || n > 200) {
                    System.out.println("Invalid input, please try again.");
                }
            } else {
                System.out.println("Invalid input, please try again.");
                in.nextLine();
            }
        }
        int[][] matrix = new int[n][n];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print("Enter element arr[" + i + "][" + j + "]:");
                matrix[i][j] = in.nextInt();
            }
        }
        in.close();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(matrix[i][j] + "|");
            }
            System.out.println();
        }

// Find max element and its position
        int max = matrix[0][0];
        int max_row_index = 0;
        int max_col_index = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] > max) {
                    max = matrix[i][j];
                    max_row_index = i;
                    max_col_index = j;
                }
            }
        }
// Swap rows
        int temp_row[] = matrix[0];
        matrix[0] = matrix[max_row_index];
        matrix[max_row_index] = temp_row;
// Swap columns
        for (int i = 0; i < n; i++) {
            int temp_col = matrix[i][0];
            matrix[i][0] = matrix[i][max_col_index];
            matrix[i][max_col_index] = temp_col;
        }
        System.out.println();
// Print result
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(matrix[i][j] + "|");
            }
            System.out.println();
        }
    }
}

//Exercise 4

import java.util.Scanner;
public class ex4 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter text:");
        String text = in.nextLine();
        String[] words = text.split("[ ,.:;-?!]+");
        for (String word : words) { int i = 0; int j = word.length() - 1; boolean symmetrical = true;
            while (i < j) {
                if (word.charAt(i) != word.charAt(j)) {
                    symmetrical = false;
                    break;
                }
                i++;
                j--;
            }
            if (symmetrical) {
                System.out.println(word + "");
            }
            in.close();
        }
    }
}
