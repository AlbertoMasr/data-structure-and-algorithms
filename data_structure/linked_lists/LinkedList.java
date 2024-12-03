package data_structure.linked_lists;

public class LinkedList {
    Node head;

    public LinkedList() {
        this.head = null;
    }

    public void read() {
        if(head == null) {
            System.out.println("Linked list is empty");
            return;
        }

        Node temp = head;

        while(temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }

    public void addElementAtBegining(int data) {
        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;
    }

    public void addElementAtNPosition(int data, int position) {

        if(position < 0) {
            throw new IndexOutOfBoundsException("Position out of bounds, must be greater than 0");
        }

        if(head == null || position == 0) {
            addElementAtBegining(data);
            return;
        }

        Node newNode = new Node(data);
        Node temp = head;
        
        for(int i = 0; i < position - 1 && temp.next != null; i++) {
            temp = temp.next;
        }

        if(temp.next == null) {
            throw new IndexOutOfBoundsException("Position out of bounds");
        }

        newNode.next = temp.next;
        temp.next = newNode;

    }

    public void addElementAtEnd(int data) {
        Node newNode = new Node(data);

        if(head == null) {
            addElementAtBegining(data);
        }

        Node temp = head;

        while(temp.next != null) {
            temp = temp.next;
        }

        temp.next = newNode;

    }
}
