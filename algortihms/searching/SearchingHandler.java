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

    public static void findFirstOcurrence(Searching searching) {
        int[] list = {10, 24, 40, 40, 40, 73, 95, 100, 120, 140, 140, 140, 150, 160};
        System.out.println("List: ");
        print(list);

        while (true) {
            try {
                System.out.println("Enter the number to find first occurrence: ");
                int number = Integer.parseInt(scanner.nextLine());
                int indexNumber = searching.findFirstLastOcurrence(list, number, true);

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

    public static void findLastOcurrence(Searching searching) {
        int[] list = {10, 24, 40, 40, 40, 73, 95, 100, 120, 140, 140, 140, 150, 160};
        System.out.println("List: ");
        print(list);

        while (true) {
            try {
                System.out.println("Enter the number to find last occurrence: ");
                int number = Integer.parseInt(scanner.nextLine());
                int indexNumber = searching.findFirstLastOcurrence(list, number, false);

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

    public static void countOcurrence(Searching searching) {
        int[] list = {10, 24, 40, 40, 40, 40, 40, 73, 95, 95, 100, 120, 140, 140, 140, 150, 160};
        System.out.println("List: ");
        print(list);

        while (true) {
            try {
                System.out.println("Enter the number to find the number of occurrence: ");
                int number = Integer.parseInt(scanner.nextLine());
                int startIndex = searching.findFirstLastOcurrence(list, number, true);

                if(startIndex == -1) {
                    System.out.println("The number "+ number +" has 0 occurrences.");
                } else {
                    int endIndex = searching.findFirstLastOcurrence(list, number, false);
                    int count = endIndex - startIndex + 1;
                    System.out.println("The number "+ number +" has "+ count +" occurrences.");
                }
                break;
            } catch (NumberFormatException e) {
                System.err.println("Please, enter a number.");
            }
        }
    }

    public static void rotateArray(Searching searching) {
        // int[] list = {5, 6, 7, 8, 9, 7, 1, 2, 3, 4};
        // int[] list = {7, 8, 9, 1, 2, 3, 4, 5, 6};
        // int[] list = {1, 2, 3, 4};
        // int[] list = {2, 3, 4, 1};
        int[] list = {2, 1};
        System.out.println("List: ");
        print(list);

        while (true) {
            try {
                int rotations = searching.rotateArray(list);
                System.out.println("The array is rotated "+ rotations +" times.");
                break;
            } catch (NumberFormatException e) {
                System.err.println("Please, enter a number.");
            }
        }
    }

    public static void finElementCircleArray(Searching searching) {
        int[] list = {5, 6, 7, 8, 9, 1, 2, 3, 4};
        System.out.println("List: ");
        print(list);

        while (true) {
            try {
                System.out.println("Enter the number to find: ");
                int number = Integer.parseInt(scanner.nextLine());
                int indexNumber = searching.findCircleArray(list, number);

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
        System.out.println("4. Find first ocurrence");
        System.out.println("5. Find last ocurrence");
        System.out.println("6. Count number of ocurrence");
        System.out.println("7. How many times an array is rotated");
        System.out.println("8. Find element in a circle array");
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
                    case 4 -> SearchingHandler.findFirstOcurrence(searching);
                    case 5 -> SearchingHandler.findLastOcurrence(searching);
                    case 6 -> SearchingHandler.countOcurrence(searching);
                    case 7 -> SearchingHandler.rotateArray(searching);
                    case 8 -> SearchingHandler.finElementCircleArray(searching);
                    default -> System.out.println("Option doesn't support");
                }
            } catch (NumberFormatException e) {
                System.err.println("Please, choose a right option.");
            }
        } while(option != SALIR);

        scanner.close();

    }
}
