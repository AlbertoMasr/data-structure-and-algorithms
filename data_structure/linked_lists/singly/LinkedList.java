package data_structure.linked_lists.singly;

import data_structure.linked_lists.LinkedListEmptyException;

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

    public void readRecursive(Node headPointer) {
        if(headPointer == null) {
            System.out.println("null");
            return;
        }
        System.out.print(headPointer.data +" -> ");
        readRecursive(headPointer.next);
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
        
        for(int i = 0; i < position && temp.next != null; i++) {
            temp = temp.next;
        }

        // if(temp.next == null) {
        //     throw new IndexOutOfBoundsException("Position out of bounds");
        // }

        newNode.next = temp.next;
        temp.next = newNode;

    }

    public void addElementAtEnd(int data) {

        if(head == null) {
            addElementAtBegining(data);
        }

        Node newNode = new Node(data);
        Node temp = head;

        while(temp.next != null) {
            temp = temp.next;
        }

        temp.next = newNode;

    }

    public Node addElementAtEndAndReturnNode(int data) {

        if(head == null) {
            addElementAtBegining(data);
        }

        Node newNode = new Node(data);
        Node temp = head;

        while(temp.next != null) {
            temp = temp.next;
        }

        temp.next = newNode;

        return newNode;

    }

    public void updateAnElement(int data, int position) {
        if(position < 0) {
            throw new IndexOutOfBoundsException("Position out of bounds, must be greater than 0");
        }

        if(head == null) {
            throw new LinkedListEmptyException("Empty linked list, nothing to update");
        }

        Node temp = head;

        int counter = 0;
        while(counter < position && temp.next != null) {
            temp = temp.next;
            counter++;
        }

        // if(temp.next == null) {
        //     throw new IndexOutOfBoundsException("Position out of bounds, position not found");
        // }

        temp.data = data;
    }

    public void deleteAnElement(int position) {
        if(position < 0) {
            throw new IndexOutOfBoundsException("Position out of bounds, must be greater than 0");
        }

        if(head == null) {
            throw new LinkedListEmptyException("Empty linked list, nothing to delete");
        }

        if(position == 0) {
            head = head.next;
            return;
        }

        Node temp = head;

        int counter = 0;
        
        while(counter < position - 1 && temp.next != null) {
            temp = temp.next;
            counter++;
        }

        if(temp.next == null) {
            throw new IndexOutOfBoundsException("Position out of bounds, position not found");
        }

        Node temp2 = temp.next;
        temp.next = temp2.next;
    }

    public void reversed() {
        if(head == null) {
            System.out.println("Linked list is empty, nothing to reverse");
            return;
        }

        Node prev = null;
        Node current = head;

        while(current !=  null) {
            Node next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }

        head = prev;

    }

    public void reversedRecursive(Node headPointer) {
        if(headPointer == null) {
            throw new LinkedListEmptyException("Empty linked list, nothing to delete");
        }

        if(headPointer.next == null) {
            head = headPointer;
            return;
        }

        reversedRecursive(headPointer.next);
        Node nextNode = headPointer.next;
        nextNode.next = headPointer;
        headPointer.next = null;

    }

    private int length(Node headPointer) {
        if(headPointer == null) {
            return 0;
        }

        int counter = 0;

        Node temp = headPointer;
        while(temp != null) {
            counter++;
            temp = temp.next;
        }

        return counter;
    }

    public Node findMergePoint(Node head1, Node head2) {
        int m = length(head1);
        int n = length(head2);
        int d = n - m;

        if(m > n) {
            Node temp = head1;
            head1 = head2;
            head2 = temp;
            d = m - n;
        }

        for(int i = 0; i < d; i++) {
            head2 = head2.next;
        }

        while(head1 != null && head2 != null) {
            if(head1 == head2) {
                return head1;
            }

            head1 = head1.next;
            head2 = head2.next;
        }

        return null;
    }

}