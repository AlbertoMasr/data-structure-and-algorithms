package algortihms.searching;

import java.util.Scanner;

public class SearchingHandler {

    static Scanner scanner = new Scanner(System.in);

    private static void print(int[] list) {
        for(int i = 0; i < list.length; i++) {
            System.out.print(list[i] + " ");
        }
        System.out.println("\n");
    }

    public static void linear(Searching searching) {
        int[] list = {10, 24, 40, 73, 95, 100, 120, 140, 150, 160};
        System.out.println("List: ");
        print(list);

        while (true) {
            try {
                System.out.println("Enter the number to search: ");
                int number = Integer.parseInt(scanner.nextLine());
                int indexNumber = searching.linear(list, number);

                if (indexNumber != -1) {
                    System.out.println("The number is in the index: " + indexNumber);
                } else {
                    System.out.println("The number is not in the list.");
                }
                break;
            } catch (NumberFormatException e) {
                System.err.println("Please, enter a number.");
            }
        }
    }

    public static void binaryIterative(Searching searching) {
        int[] list = {10, 24, 40, 73, 95, 100, 120, 140, 150, 160};
        System.out.println("\nList: ");
        print(list);

        while (true) {
            try {
                System.out.println("Enter the number to search: ");
                int number = Integer.parseInt(scanner.nextLine());
                int indexNumber = searching.binaryIterative(list, number);
                if (indexNumber != -1) {
                    System.out.println("The number is in the index: " + indexNumber);
                } else {
                    System.out.println("The number is not in the list.");
                }
                break;
            } catch (NumberFormatException e) {
                System.err.println("Please, enter a number.");
            }
        }
    }

    public static void binaryRecursive(Searching searching) {
        int[] list = {10, 24, 40, 73, 95, 100, 120, 140, 150, 160};
        System.out.println("List: ");
        print(list);

        while (true) {
            try {
                System.out.println("Enter the number to search: ");
                int number = Integer.parseInt(scanner.nextLine());
                int indexNumber = searching.binaryRecursive(list, 0, list.length, number);

                if (indexNumber != -1) {
                    System.out.println("The number is in the index: " + indexNumber);
                } else {
                    System.out.println("The number is not in the list.");
                }
                break;
            } catch (NumberFormatException e) {
                System.err.println("Please, enter a number.");
            }
        }
    }

    public static void showMenu() {
        System.out.println("-----------------------------------");
        System.out.println("1. Linear search");
        System.out.println("2. Binary iterative search");
        System.out.println("3. Binary recursive search");
        System.out.println("-----------------------------------");
    }

    public static void main(String[] args) {

        Searching searching = new Searching();

        final int SALIR = 0;
        int option = 0;

        do {
            System.out.println("What do you want to do?");
            showMenu();
            try {
                option = Integer.parseInt(scanner.nextLine());

                switch (option) {
                    case 1 -> SearchingHandler.linear(searching);
                    case 2 -> SearchingHandler.binaryIterative(searching);
                    case 3 -> SearchingHandler.binaryRecursive(searching);
                    default -> System.out.println("Option doesn't support");
                }
            } catch (NumberFormatException e) {
                System.err.println("Please, choose a right option.");
            }
        } while(option != SALIR);

        scanner.close();

    }
}
