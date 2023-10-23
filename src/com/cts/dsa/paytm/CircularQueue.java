
// Java code to implement a circular queue using an array:
/*
Explanation:

In this problem, we are implementing a circular queue using an array-based approach.
The CircularQueue class has member variables for the array, front, rear, and size.
The enqueue method adds an item to the rear of the queue and handles circular wrapping if necessary.
The dequeue method removes an item from the front of the queue and also handles circular wrapping.
The isFull and isEmpty methods check whether the queue is full or empty.
The main function demonstrates how to use the circular queue by creating an instance, enqueueing and dequeueing elements, 
and checking for fullness and emptiness.*/

package com.cts.dsa.paytm;

public class CircularQueue {
    private int[] queue;
    private int front;
    private int rear;
    private int size;

    public CircularQueue(int capacity) {
        queue = new int[capacity];
        front = 0;
        rear = -1;
        size = 0;
    }

    public void enqueue(int item) {
        if (!isFull()) {
            rear = (rear + 1) % queue.length;
            queue[rear] = item;
            size++;
        }
    }

    public int dequeue() {
        if (!isEmpty()) {
            int item = queue[front];
            front = (front + 1) % queue.length;
            size--;
            return item;
        }
        return -1; // Return -1 for an empty queue
    }

    public boolean isFull() {
        return size == queue.length;
    }

    public boolean isEmpty() {
        return size == 0;
    }
    
    public static void main(String[] args) {
        CircularQueue circularQueue = new CircularQueue(5);
        circularQueue.enqueue(1);
        circularQueue.enqueue(2);
        circularQueue.enqueue(3);
        System.out.println(circularQueue.dequeue()); // Should print 1
        System.out.println(circularQueue.dequeue()); // Should print 2
        circularQueue.enqueue(4);
        circularQueue.enqueue(5);
        circularQueue.enqueue(6); // Queue is full
    }
}
