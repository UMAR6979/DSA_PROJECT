/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author ameer
 */
public class queue<T> {

    private class Node {

        T data;
        Node Prelink;
        Node Nextlink;
    }
    private Node top = null;
    private Node head = null;
    private int size = 0;

    public boolean isEmpty() {
        return head == null;
    }

    public void enqueue(T data) {
        Node n = new Node();
        n.data = data;
        if (isEmpty()) {
            head = n;
            head.Prelink = null;
            head.Nextlink = null;
            top = head;
            size++;
        }
        else {
            n.Prelink = top;
            top.Nextlink = n;
            top = n;
            size++;
        }
    }

    public T dequeue() {
        if (isEmpty()) {
            return null;
        }
        else if(head==top)
        {
            T temp=head.data;
            head=null;
            top=null;
            return temp;
        }
        else {
            T temp = head.data;
            head = head.Nextlink;
            head.Prelink = null;
            size--;
            return temp;
        }

    }

    public int size() {
        return size;
    }

    public void Traverse() {
        if(isEmpty())
        {
            System.out.println("Queue is Empty");
        }
        else
        {
        Node temp = top;
         System.out.print("null");
        while (temp != null) {
            System.out.print("<--"+temp.data);
            temp = temp.Prelink;
        }
        }
        System.out.println(" ");
    }
}
