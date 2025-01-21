package data_structure.arrays;

import java.util.Scanner;

public class ArrayHandler {

    static Scanner scanner = new Scanner(System.in);

    private int size = 0;
    private int[] array = new int[size];

    public ArrayHandler() {
        size = 0;
        array = new int[1];
    }

    public void read() {

        if(size == 0) {
            System.out.println("Array is empty");
            return;
        }

        System.out.println("Array elements");

        System.out.print("[");
        for (int i : array) {
            System.out.print(i+ " ");
        }
        System.out.println("]");

    }

    public void addElement() {

        if(size == array.length) {
            System.out.println("Array is full, creating another...");
            int[] newArray = new int[array.length * 2];

            System.out.println("Copying elements");
            System.arraycopy(array, 0, newArray, 0, array.length);

            System.out.println("Array created");
            array = newArray;

            System.out.printf("New size: %d%n", array.length);
        }

        while (true) { 
            try {
                System.out.println("Insert the new element");
                int newValue = Integer.parseInt(scanner.nextLine());
                array[size] = newValue;
                size++;
                System.out.println("Element added");
                break;
            } catch (NumberFormatException e) {
                System.err.println("Type an integer");
            }
        }

    }

    public void readAnElement() {

        while (true) { 
            try {
                System.out.println("What position do you want to get? (Remember, the position start on 0)");
                int indexToGet = Integer.parseInt(scanner.nextLine());
                System.out.printf("Retrieved data from index: %d%n", indexToGet);
                System.out.println("Value: "+ array[indexToGet]);
                break;
            } catch (Exception e) {
                System.err.println(e.getMessage());
            }
        }

    }

    public void updateAnElement() {

        while (true) { 
            try {
                System.out.println("What position do you want to update? (Remember, the position start on 0)");
                int indexToUpdate = Integer.parseInt(scanner.nextLine());
                System.out.println("Value: "+ array[indexToUpdate]);
                System.out.println("Which value do you want to put in that index?");
                int newValue = Integer.parseInt(scanner.nextLine());
                array[indexToUpdate] = newValue;
                System.out.println("The index was update, the new value is: "+ newValue);
                break;
            } catch (Exception e) {
                System.err.println(e.getMessage());
            }
        }

    }

    public void deleteAnElement() {

        while (true) { 
            try {
                System.out.println("What position do you want to update? (Remember, the position start on 0)");
                int indexToUpdate = Integer.parseInt(scanner.nextLine());
                array[indexToUpdate] = 0;
                System.out.println("The index was update, the new value is the default value: "+ 0);
                break;
            } catch (Exception e) {
                System.err.println(e.getMessage());
            }
        }

    }

    public void print2DArrayInSpiralForm() {
        int[][] matrix = {
            {1, 2, 3, 4},
            {5, 6, 7, 8},
            {9, 10, 11, 12},
            {13, 14, 15, 16}
        };

        int t = 0;
        int b = matrix.length - 1;
        int l = 0;
        int r = matrix[0].length - 1;
        int dir = 0;

        while(t <= b && l <= r) {
            if(dir == 0) {
                for(int i = l; i <= r; i++) {
                    System.out.print(matrix[t][i] +", ");
                }
                t++;
                dir = 1;
            } else if(dir == 1) {
                for(int i = t; i <= b; i++) {
                    System.out.print(matrix[i][r] +", ");
                }
                r--;
                dir = 2;
            } else if(dir == 2) {
                for(int i = r; i >= l; i--) {
                    System.out.print(matrix[b][i] +", ");
                }
                b--;
                dir = 3;
            } else if(dir == 3) {
                for(int i = b; i >= t; i--) {
                    System.out.print(matrix[i][l] +", ");
                }
                l++;
                dir = 0;
            }
        }
    }

    private int maxSumSubarray(int[] arr, int n) {
        if(n == 1) {
            return arr[0];
        }

        int m = n / 2;
        int leftSide = maxSumSubarray(arr, m);
        int rightSide = maxSumSubarray(arr , n - m);
        int leftSum = Integer.MIN_VALUE;
        int rightSum = Integer.MIN_VALUE;
        
        int sum = 0;
        for(int i = (m - 1); i >= 0; i--) {
            sum += arr[i];
            leftSum = Math.max(leftSum, sum);
        }

        sum = 0;
        for(int i = m; i < n; i++) {
            sum += arr[i];
            rightSum = Math.max(rightSum, sum);
        }

        int ans = Math.max(leftSide, rightSide);

        return Math.max(ans, leftSum + rightSum);
    }

    public void sumSubarrayDivideAndConquer() {
        // int[] arr = {3, -1, 5, -1};
        int[] arr = {1, -3, 2, -5, 7, 6, -1, -4, 11, -23};
        int maxSumSubarray = maxSumSubarray(arr, arr.length);
        System.out.println("Max sum subarray: "+ maxSumSubarray);
    }

    public void sumSubarrayKadane() {
        // int[] arr = {3, -1, 5, -1};
        int[] arr = {1, -3, 2, -5, 7, 6, -1, -4, 11, -23};
        int ans = 0;
        int sum = 0;

        for(int i = 0; i < arr.length; i++) {
            if(sum + arr[i] > 0) {
                sum += arr[i];
            } else {
                sum = 0;
            }
            ans = Math.max(ans, sum);
        }
        System.out.println("Max sum subarray: "+ ans);
    }

    public static void showMenu() {
        System.out.println("-----------------------------------");
        System.out.println("1. Read array");
        System.out.println("2. Insert an element of array");
        System.out.println("3. Read an element of array");
        System.out.println("4. Update an element of array");
        System.out.println("5. Delete an element of array");
        System.out.println("6. Print 2D element in spiral form");
        System.out.println("7. Sum subarray divide and conquer");
        System.out.println("8. Sum subarray Kadane's algorithm");
        System.out.println("-----------------------------------");
    }

    public static void main(String[] args) {

        ArrayHandler arrayHandler = new ArrayHandler();

        final int SALIR = 0;
        int option = 0;

        do {
            System.out.println("What do you want to do?");
            showMenu();
            try {
                option = Integer.parseInt(scanner.nextLine());

                switch (option) {
                    case 1 -> arrayHandler.read();
                    case 2 -> arrayHandler.addElement();
                    case 3 -> arrayHandler.readAnElement();
                    case 4 -> arrayHandler.updateAnElement();
                    case 5 -> arrayHandler.deleteAnElement();
                    case 6 -> arrayHandler.print2DArrayInSpiralForm();
                    case 7 -> arrayHandler.sumSubarrayDivideAndConquer();
                    case 8 -> arrayHandler.sumSubarrayKadane();
                    default -> System.out.println("Option doesn't support");
                }
            } catch (NumberFormatException e) {
                System.err.println("Please, choose a right option.");
            }
        } while(option != SALIR);

        scanner.close();

    }

}
