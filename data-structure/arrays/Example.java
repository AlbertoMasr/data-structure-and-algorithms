
import java.util.Scanner;

public class Example {

    public static void showMenu() {
        System.out.println("1. Read array");
        System.out.println("2. Delete an element of array");
        System.out.println("3. Update an element of array");
    }

    public static void readArray(int[] a) {
        for (int i : a) {
            System.out.println(i);
        }
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        final int SALIR = 0;
        int[] a = new int[0];
        int option = 0;

        while(option == SALIR) {
            System.out.println("What do you want to do?");
            showMenu();
            try {
                option = scanner.nextInt();

                if(option <= 0 || option > 3) {
                    continue;
                }
                switch (option) {
                    case 1:
                        readArray(a);
                        break;
                    default:
                        throw new AssertionError();
                }
            } catch (Exception e) {
                System.err.println("Please, choose a right option.");
            }
        }

        scanner.close();

    }
    
}