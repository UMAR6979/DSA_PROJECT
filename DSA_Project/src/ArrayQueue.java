/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author ameer
 */
public class ArrayQueue {

    int[] arr = new int[10];
    private int current = -1;

    private boolean isEmpty() {
        return current < 0;
    }

    private boolean isFull() {
        return current == arr.length - 1;
    }

    private void MoveBkwrd() {
        for (int i = 0; i <= current; i++) {
            arr[i] = arr[i + 1];
        }
        current--;
    }

    public void enqueue(int data) {
        if (isFull()) {
            System.out.println("Queue is Full");
        }
        else {
            arr[++current] = data;
        }
    }

    public int dequeue() {
        if (isEmpty()) {
            System.out.println("Queue is Empty");
            return -1;
        }
        else {
            int temp = arr[0];
            MoveBkwrd();
            return temp;
        }
    }

    public void traverse() {
        if (isEmpty()) {
            System.out.println("queue is Empty");
        }
        else
        {
            System.out.print("null");
        for (int i = current; i >= 0; i--) {
            System.out.print("<--"+arr[i]);
        }
        }
    }

}
