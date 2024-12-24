package data_structure.linked_lists.doubly;

import data_structure.linked_lists.LinkedListEmptyException;

public class LinkedList {
    Node head;

    public LinkedList() {
        head = null;
    }

    public void read() {

        if(head == null) {
            System.out.println("The linked list is empty");
            return;
        }

        Node temp = head;

        System.out.print("null <- ");

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

        System.out.print(headPointer.data + " -> ");
        readRecursive(headPointer.next);
    }

    public void addElementAtBegining(int newValue) {
        Node newNode = new Node(newValue);

        if(head == null) {
            head = newNode;
            return;
        }

        head.prev = newNode;
        newNode.next = head;
        head = newNode;
    }

    public void addElementAtNPosition(int newValue, int position) {
        if(position < 0) {
            throw new IndexOutOfBoundsException("The position must be greater than or equal to 0");
        }

        if(head == null || position == 0) {
            addElementAtBegining(newValue);
            return;
        }

        Node newNode = new Node(newValue);

        Node temp = head;
        int counter = 0;
        while(counter < position - 1 && temp != null) {
            temp = temp.next;
            counter++;
        }

        if(temp == null) {
            throw new IndexOutOfBoundsException("The position is out of bounds");
        }

        newNode.next = temp.next;
        newNode.prev = temp;
        temp.next = newNode;
    }

    public void addElementAtEnd(int newValue) {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    public void removeElementAtBegining() {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    public void removeElementAtNPosition(int position) {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    public void removeElementAtEnd() {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    public void updateAnElement(int position, int newValue) {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    public void reversed() {
        if(head == null) {
            throw new LinkedListEmptyException("The linked list is empty, nothing to reverse");
        }

        Node previous = null;
        Node current = head;

        while(current != null) {
            Node next = current.next;
            current.next = previous;
            current.prev = next;
            previous = current;
            current = next;
        }

        head = previous;

    }

    public void reversedRecursive(Node headPointer) {
        if(headPointer == null) {
            throw new LinkedListEmptyException("The linked list is empty, nothing to reverse");
        }

        if(headPointer.next == null) {
            head = headPointer;
            return;
        }

        reversedRecursive(headPointer.next);
        Node newNode = headPointer.next;
        newNode.next = headPointer;
        headPointer.prev = newNode;
        headPointer.next = null;
    }

}
