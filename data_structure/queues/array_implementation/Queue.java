package data_structure.queues.array_implementation;

public class Queue {
    int maxSize;
    int[] queue;
    int front;
    int rear;

    public Queue(int maxSize) {
        this.maxSize = maxSize;
        this.queue = new int[maxSize];
        this.front = -1;
        this.rear = -1;
    }

    public void read() {
        if(isEmpty()) {
            System.out.println("Queue is empty");
            return;
        }

        System.out.println("Queue elements are:");

        System.out.print(" Front -> ");
        for(int i = front; i != rear; i = (i + 1) % maxSize) {
            System.out.print(queue[i] +" -> ");
        }
        System.out.print(queue[rear]);
        System.out.print(" <- Rear");
    }

    public boolean isEmpty() {
        return front == -1 && rear == -1;
    }
    
    public boolean isFull() {
        return (rear + 1) % maxSize == front;
    }

    public void enqueue(int element) {
        if(isFull()) {
            throw new IndexOutOfBoundsException("Queue is full");
        }

        if(isEmpty()) {
            front = 0;
            rear = 0;
        } else {
            rear =  (rear + 1) % maxSize;
        }
        queue[rear] = element;
    }

    public void dequeue() {
        if(isEmpty()) {
            throw new IndexOutOfBoundsException("Queue is empty");
        }

        if(front == rear) {
            front = -1;
            rear = -1;
        } else {
          