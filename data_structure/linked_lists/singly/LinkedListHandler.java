package data_structure.linked_lists.singly;

import data_structure.linked_lists.LinkedListEmptyException;
import java.util.Scanner;

public class LinkedListHandler {

    static Scanner scanner = new Scanner(System.in);

    public static void read(LinkedList linkedList) {
        linkedList.read();
    }

    public static void readRecursive(LinkedList linkedList) {
        linkedList.readRecursive(linkedList.head);
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

    public static void reversedRecursive(LinkedList linkedList) {
        try {
            linkedList.reversedRecursive(linkedList.head);
        } catch (LinkedListEmptyException e) {
            System.err.println(e.getMessage());
        }
    }

    private static void findMergePoint(LinkedList l1, LinkedList l2) {
        Node mergePoint = l1.findMergePoint(l1.head, l2.head);
        if(mergePoint == null) {
            System.out.println("There is no merge point");
        } else {
            System.out.println("Merge point is: " + mergePoint.data);
        }
    }

    public static void findMergePoint() {

        // MERGE POINT IN 6
        // LinkedList linkedList1 = new LinkedList();
        // Node node1 = linkedList1.addElementAtEndAndReturnNode(1);
        // Node node3 = linkedList1.addElementAtEndAndReturnNode(3);
        // Node node5 = linkedList1.addElementAtEndAndReturnNode(5);
        // Node node6 = linkedList1.addElementAtEndAndReturnNode(6);
        // Node node7 = linkedList1.addElementAtEndAndReturnNode(7);
        // Node node9 = linkedList1.addElementAtEndAndReturnNode(9);

        // linkedList1.read();

        // LinkedList linkedList2 = new LinkedList();
        // Node node2 = linkedList2.addElementAtEndAndReturnNode(2);
        // Node node4 = linkedList2.addElementAtEndAndReturnNode(4);
        // node4.next = node6;

        // linkedList2.read();

        // NO MERGE POINT
        LinkedList linkedList1 = new LinkedList();
        Node node1 = linkedList1.addElementAtEndAndReturnNode(1);
        Node node2 = linkedList1.addElementAtEndAndReturnNode(2);
        Node node3 = linkedList1.addElementAtEndAndReturnNode(3);

        linkedList1.read();

        LinkedList linkedList2 = new LinkedList();
        Node node4 = linkedList2.addElementAtEndAndReturnNode(4);
        Node node5 = linkedList2.addElementAtEndAndReturnNode(5);
        Node node6 = linkedList2.addElementAtEndAndReturnNode(6);

        linkedList2.read();

        LinkedListHandler.findMergePoint(linkedList1, linkedList2);
    }

    public static void showMenu() {
        System.out.println("\n-----------------------------------");
        System.out.println("1. Read linked list");
        System.out.println("2. Read recursive linked list");
        System.out.println("3. Insert an element at the begining of linked list");
        System.out.println("4. Insert an element at N position of linked list");
        System.out.println("5. Insert an element at the end of linked list");
        System.out.println("6. Update an element of linked list");
        System.out.println("7. Delete an element of linked list");
        System.out.println("8. Reversed linked list");
        System.out.println("9. Reversed recursive linked list");
        System.out.println("10. Find merge point of two linked lists");
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
                    case 2 -> LinkedListHandler.readRecursive(linkedList);
                    case 3 -> LinkedListHandler.addElementAtBegining(linkedList);
                    case 4 -> LinkedListHandler.addElementAtNPosition(linkedList);
                    case 5 -> LinkedListHandler.addElementAtEnd(linkedList);
                    case 6 -> LinkedListHandler.updateAnElement(linkedList);
                    case 7 -> LinkedListHandler.deleteAnElement(linkedList);
                    case 8 -> LinkedListHandler.reversed(linkedList);
                    case 9 -> LinkedListHandler.reversedRecursive(linkedList);
                    case 10 -> LinkedListHandler.findMergePoint();
                    default -> System.out.println("Option doesn't support");
                }
            } catch (NumberFormatException e) {
                System.err.println("Please, choose a right option.");
            }
        } while(option != SALIR);

        scanner.close();
    }
}
