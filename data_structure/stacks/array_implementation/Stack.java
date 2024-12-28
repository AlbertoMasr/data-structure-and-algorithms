package data_structure.stacks.array_implementation;

public class Stack {
    int maxSize;
    int[] stack;
    int top;

    public Stack(int maxSize) {
        this.maxSize = maxSize;
        this.stack = new int[maxSize];
        this.top = -1;
    }

    private void creatNewArray() {
        System.out.println("Creating new array...");
        int[] newStack = new int[maxSize * 2];
        System.arraycopy(stack, 0, newStack, 0, stack.length);
        stack = newStack;
        System.out.println("New array created.");
    }

    public void read() {
        if(isEmpty()) {
            System.out.println("Stack is empty.");
            return;
        }

        System.out.println("\nStack elements:\n");
        for (int i = top; i >= 0 ; i--) {
            System.out.println("| "+ stack[i] +" |");
            System.out.println("|___|");
        }
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public void push(int element) {
        if (top == maxSize - 1) {
            creatNewArray();
        }

        stack[++top] = element;
    }

    public void pop() {
        if(isEmpty()) {
            throw new IndexOutOfBoundsException("Stack is empty.");
        }

        stack[top--] = 0;
    }

    public void top() {
        if(isEmpty()) {
            throw new IndexOutOfBoundsException("Stack is empty.");
        }

        System.out.println("Top element: " + stack[top]);
    }
}
