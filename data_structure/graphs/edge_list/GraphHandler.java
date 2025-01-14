package data_structure.graphs.edge_list;

import java.util.Scanner;

public class GraphHandler {

    static Scanner scanner = new Scanner(System.in);

    public static void readVertice(VertextList vertextList) {
        vertextList.readVertice();
    }

    public static void readEdge(VertextList vertextList) {
        vertextList.readEdge();
    }

    public static void addVertice(VertextList vertextList) {
        while (true) { 
            System.out.println("Enter the vertice name: ");
            String vertice = scanner.nextLine();
            vertextList.addVertice(vertice);
            break;
        }
    }

    public static void addEdge(VertextList vertextList) {
        while (true) { 
            try {
                System.out.println("Vertices positions:");
                vertextList.readVertice();
                System.out.println("\nEnter the vertice origin position: ");
                int origin = Integer.parseInt(scanner.nextLine());
                if(vertextList.isOutOfBounds(origin)) {
                    System.err.println("\nThe vertice position doesn't exist.");
                    continue;
                }
                System.out.println("\nEnter the vertice destiny position: ");
                int destiny = Integer.parseInt(scanner.nextLine());
                if(vertextList.isOutOfBounds(destiny)) {
                    System.err.println("\nThe vertice position doesn't exist.");
                    continue;
                }
                System.out.println("\nEnter the weight of the edge: ");
                int weight = Integer.parseInt(scanner.nextLine());
                vertextList.addEdge(origin, destiny, weight);
                break;
            } catch (NumberFormatException e) {
                System.err.println("\nPlease, enter a valid number.");
            }
        }
    }

    public static void updateVertice(VertextList vertextList) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public static void updateEdge(VertextList vertextList) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public static void deleteVertice(VertextList vertextList) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public static void deleteEdge(VertextList vertextList) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public static void findAdjacents(VertextList vertextList) {
        while(true) {
            try {
                System.out.println("Vertices positions:");
                vertextList.readVertice();
                System.out.println("\nEnter the vertice position to find adjacents vertices: ");
                int verticePosition = Integer.parseInt(scanner.nextLine());
                if(vertextList.isOutOfBounds(verticePosition)) {
                    System.err.println("\nThe vertice position doesn't exist.");
                    continue;
                }
                vertextList.findAdjacents(verticePosition);
                break;
            } catch (NumberFormatException e) {
                System.err.println("\nPlease, enter a valid number.");
            }
        }
    }

    public static void showMenu() {
        System.out.println("-----------------------------------");
        System.out.println("1. Read vertice of graph");
        System.out.println("2. Read edge of graph");
        System.out.println("3. Insert an vertice to graph");
        System.out.println("4. Inster an edge to graph");
        System.out.println("5. Update an vertice of graph");
        System.out.println("6. Update an edge of graph");
        System.out.println("7. Delete an vertice of graph");
        System.out.println("8. Delete an edge of graph");
        System.out.println("9. Find adjacents of a vertice");
        System.out.println("-----------------------------------");
    }

    public static void main(String[] args) {

        VertextList vertextList = new VertextList(2);

        final int SALIR = 0;
        int option = 0;

        do {
            System.out.println("What do you want to do?");
            showMenu();
            try {
                option = Integer.parseInt(scanner.nextLine());

                switch (option) {
                    case 1 -> GraphHandler.readVertice(vertextList);
                    case 2 -> GraphHandler.readEdge(vertextList);
                    case 3 -> GraphHandler.addVertice(vertextList);
                    case 4 -> GraphHandler.addEdge(vertextList);
                    case 5 -> GraphHandler.updateVertice(vertextList);
                    case 6 -> GraphHandler.updateEdge(vertextList);
                    case 7 -> GraphHandler.deleteVertice(vertextList);
                    case 8 -> GraphHandler.deleteEdge(vertextList);
                    case 9 -> GraphHandler.findAdjacents(vertextList);
                    default -> System.out.println("Option doesn't support");
                }
            } catch (NumberFormatException e) {
                System.err.println("Please, choose a right option.");
            }
        } while(option != SALIR);

        scanner.close();

    }

}
