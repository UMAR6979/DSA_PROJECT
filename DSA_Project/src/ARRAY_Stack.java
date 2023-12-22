/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author ameer
 */
public class ARRAY_Stack {

    int[] arr = new int[10];
    int current = -1;

    public boolean isEmpty() {
        if (current < 0) {
            return true;
        }
        else {
            return false;
        }
    }

    public boolean isFull() {
        if (current == arr.length - 1) {
            return true;
        }
        else {
            return false;
        }
    }

    public void push(int data) {
        if (isFull()) {
            System.out.println("Stack Overflow");
        }
        else {
            current++;
            arr[current] = data;
        }
    }

    public int pop() {
        if (isEmpty()) {
            return -1;
        }
        else {
            return arr[current--];
        }
    }

    public void Traverse() {
        if (isEmpty()) {
            System.out.println("Stack is Empty");
        }
        else {
            int[] temp = arr;
            System.out.println("---------------------------------------------------");
            for (int i = current; i >= 0; i--) {
                System.out.print(temp[i] + " | ");
            }
            System.out.println("\n---------------------------------------------------");
        }
    }

    public int size() {
        return current + 1;
    }

    public int peak() {
        if (isEmpty()) {
            System.out.print("Stack is Empty");
            return -1;
        }
        else {
            int temp = arr[current];
            return temp;
        }
    }
}
