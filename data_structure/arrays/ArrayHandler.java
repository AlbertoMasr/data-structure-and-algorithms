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

    public static void showMenu() {
        System.out.println("-----------------------------------");
        System.out.println("1. Read array");
        System.out.println("2. Insert an element of array");
        System.out.println("3. Read an element of array");
        System.out.println("4. Update an element of array");
        System.out.println("5. Delete an element of array");
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
                    default -> System.out.println("Option doesn't support");
                }
            } catch (NumberFormatException e) {
                System.err.println("Please, choose a right option.");
            }
        } while(option != SALIR);

        scanner.close();

    }

}
