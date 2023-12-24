/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author ameer
 */
public class CircularQueue<T> {
    class Node{
        T data;
        Node NextLink;
        Node PreLink;
    }
    private Node head;
    private Node tail;
    private int size=0;
    
    public boolean isEmpty()
    {
        return head==null;
    }
    
    public void enqueue(T data)
    {
        Node n=new Node();
        n.data=data;
        if(isEmpty())
        {
            head=n;
            head.NextLink=tail;
            head.PreLink=tail;
            tail=head;
            size++;
        }
        else
        {
            tail.NextLink=n;
            n.PreLink=tail;
            tail=n;
            n.NextLink=head;
            head.PreLink=tail;
            size++;
        }
    }
    
    public T dequeue()
    {
        if(isEmpty())
        {
            return null;
        }
        else if(head==tail)
        {
            T temp=head.data;
            head=null;
            tail=null;
            return temp;
        }
        else
        {
            T temp=head.data;
            head=head.NextLink;
            head.PreLink=tail;
            tail.NextLink=head;
            size--;
            return temp;
        }
    }
    
    public int Size()
    {
        return size;
    }
    
    public void Traverse()
    {
        if(isEmpty())
        {
            System.out.println("Queue is Empty");
        }
        else
        {
        Node Temp=tail;
        do{
            System.out.print("<--"+Temp.data);
            Temp=Temp.PreLink;
        }
        while(Temp!=null  && Temp.NextLink!=head);
        System.out.print("-->");
        }
    }
    
}
