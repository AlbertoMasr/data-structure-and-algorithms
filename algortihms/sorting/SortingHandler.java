package algortihms.sorting;

import java.util.Scanner;

public class SortingHandler {

    static Scanner scanner = new Scanner(System.in);

    private static void print(int[] list) {
        for(int i = 0; i < list.length; i++) {
            System.out.print(list[i] + " ");
        }
        System.out.println("\n");
    }

    public static void selection(Sorting sorting) {
        int[] list = {5, 3, 2, 4, 1};
        System.out.println("List to sort: ");
        print(list);

        sorting.selection(list);

        System.out.println("List sorted: ");
        print(list);
    }

    public static void bubble(Sorting sorting) {
        int[] list = {5, 3, 2, 4, 1};
        System.out.println("List to sort: ");
        print(list);

        sorting.bubble(list);

        System.out.println("List sorted: ");
        print(list);
    }

    public static void insertion(Sorting sorting) {
        int[] list = {5, 3, 2, 4, 1};
        System.out.println("List to sort: ");
        print(list);

        sorting.insertion(list);

        System.out.println("List sorted: ");
        print(list);
    }

    public static void merge(Sorting sorting) {
        int[] list = {5, 3, 2, 4, 1};
        System.out.println("List to sort: ");
        print(list);

        sorting.merge(list);

        System.out.println("List sorted: ");
        print(list);
    }

    public static void quick(Sorting sorting) {
        int[] list = {5, 3, 2, 4, 1};
        System.out.println("List to sort: ");
        print(list);

        sorting.quick(list, 0, list.length - 1);

        System.out.println("List sorted: ");
        print(list);
    }

    public static void showMenu() {
        System.out.println("-----------------------------------");
        System.out.println("1. Selection sort");
        System.out.println("2. Bubble sort");
        System.out.println("3. Insertion sort");
        System.out.println("4. Merge sort");
        System.out.println("5. Quick sort");
        System.out.println("-----------------------------------");
    }

    public static void main(String[] args) {

        Sorting sorting = new Sorting();

        final int SALIR = 0;
        int option = 0;

        do {
            System.out.println("What do you want to do?");
            showMenu();
            try {
                option = Integer.parseInt(scanner.nextLine());

                switch (option) {
                    case 1 -> SortingHandler.selection(sorting);
                    case 2 -> SortingHandler.bubble(sorting);
                    case 3 -> SortingHandler.insertion(sorting);
                    case 4 -> SortingHandler.merge(sorting);
                    case 5 -> SortingHandler.quick(sorting);
                    default -> System.out.println("Option doesn't support");
                }
            } catch (NumberFormatException e) {
                System.err.println("Please, choose a right option.");
            }
        } while(option != SALIR);

        scanner.close();

    }
}
