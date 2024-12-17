package data_structure.linked_lists;

import java.util.Scanner;

public class LinkedListHandler {

    static Scanner scanner = new Scanner(System.in);

    public static void read(LinkedList linkedList) {
        linkedList.read();
    }

    public static void addElementAtBegining(LinkedList linkedList) {

        while (true) {
            try {
                System.out.println("Insert the new element");
                int newValue = Integer.parseInt(scanner.nextLine());
                linkedList.addElementAtBegining(newValue);
                System.out.println("Element added");
                break;
            } catch (NumberFormatException e) {
                System.err.println("Type an integer");
            } catch (IndexOutOfBoundsException e) {
                System.err.println("Position out of bounds");
            }
        }

    }

    public static void addElementAtNPosition(LinkedList linkedList) {
        while (true) {
            try {
                System.out.println("Insert the new element");
                int newValue = Integer.parseInt(scanner.nextLine());
                System.out.println("Insert the position (Rembember that the first position is 0)");
                int position = Integer.parseInt(scanner.nextLine());
                linkedList.addElementAtNPosition(newValue, position);
                System.out.println("Element added");
                break;
            } catch (NumberFormatException e) {
                System.err.println("Type an integer");
            } catch (IndexOutOfBoundsException e) {
                System.err.println("Position out of bounds");
            }
        }
    }

    public static void addElementAtEnd(LinkedList linkedList) {
        while (true) {
            try {
                System.out.println("Insert the new element");
                int newValue = Integer.parseInt(scanner.nextLine());
                linkedList.addElementAtEnd(newValue);
                System.out.println("Element added");
                break;
            } catch (NumberFormatException e) {
                System.err.println("Type an integer");
            }  catch (IndexOutOfBoundsException e) {
                System.err.println("Position out of bounds");
            }
        }
    }

    public static void updateAnElement(LinkedList linkedList) {
        while(true) {
            try {

                System.out.println("Insert the new value");
                int newValue = Integer.parseInt(scanner.nextLine());
                System.out.println("Insert the position (Rembember that the first position is 0)");
                int position = Integer.parseInt(scanner.nextLine());
                linkedList.updateAnElement(newValue, position);
                System.out.println("Element updated");
                break;
            } catch (NumberFormatException e) {
                System.err.println("Type an integer");
            }  catch (IndexOutOfBoundsException e) {
                System.err.println(e.getMessage());
            } catch (LinkedListEmptyException e) {
                System.err.println(e.getMessage());
                break;
            }
        }
    }

    public static void deleteAnElement(LinkedList linkedList) {
        while (true) { 
            try {
                System.out.println("Insert the position (Rembember that the first position is 0)");
                int position = Integer.parseInt(scanner.nextLine());
                linkedList.deleteAnElement(position);
                System.out.println("Element deleted");
                break;
            } catch (NumberFormatException e) {
                System.err.println("Type an integer");
            }  catch (IndexOutOfBoundsException e) {
                System.err.println(e.getMessage());
            } catch (LinkedListEmptyException e) {
                System.err.println(e.getMessage());
                break;
            }
        }
    }

    public static void reversed(LinkedList linkedList) {
        linkedList.reversed();
    }

    public static void showMenu() {
        System.out.println("\n-----------------------------------");
        System.out.println("1. Read linked list");
        System.out.println("2. Insert an element at the begining of linked list");
        System.out.println("3. Insert an element at N position of linked list");
        System.out.println("4. Insert an element at the end of linked list");
        System.out.println("5. Update an element of linked list");
        System.out.println("6. Delete an element of linked list");
        System.out.println("7. Reversed linked list");
        System.out.println("-----------------------------------\n");
    }

    public static void main(String[] args) {

        LinkedList linkedList = new LinkedList();

        final int SALIR = 0;
        int option = 0;

        do {
            System.out.println("\nWhat do you want to do?");
            showMenu();
            try {
                option = Integer.parseInt(scanner.nextLine());

                switch (option) {
                    case 1 -> LinkedListHandler.read(linkedList);
                    case 2 -> LinkedListHandler.addElementAtBegining(linkedList);
                    case 3 -> LinkedListHandler.addElementAtNPosition(linkedList);
                    case 4 -> LinkedListHandler.addElementAtEnd(linkedList);
                    case 5 -> LinkedListHandler.updateAnElement(linkedList);
                    case 6 -> LinkedListHandler.deleteAnElement(linkedList);
                    case 7 -> LinkedListHandler.reversed(linkedList);
                    default -> System.out.println("Option doesn't support");
                }
            } catch (NumberFormatException e) {
                System.err.println("Please, choose a right option.");
            }
        } while(option != SALIR);

        scanner.close();
    }
}
