
public class Dequeue<T> {
    class Node {
        T data;
        Node Prelink;
        Node Nextlink;
    }
    private Node top=null;
    private Node head=null;
    private int size=0;
    
    public boolean isEmpty()
    {
        if(head==null)
        {
            return true;
        }
        else
        {
            return false;
        }
    }
    public void InsertAtEnd(T data)
    {
        Node n=new Node();
        n.data=data;
        if(isEmpty())
        {
            head=n;
            head.Prelink=null;
            head.Nextlink=null;
            top=head;
            size++;
        }
        else
        {
            n.Prelink=top;
            top.Nextlink=n;
            top=n;
            size++;
        }
    }
    public void InsertAtStart(T data)
    {
        Node n=new Node();
         n.data=data;
        if(isEmpty())
        {
            head=n;
            head.Prelink=null;
            head.Nextlink=null;
            top=head;
            size++;
        }
        else
        {
            head.Prelink=n;
            n.Nextlink=head;
            head=n;
            head.Prelink=null;
            size++;
        }
    }
    
    public T RemoveAtEnd()
    {
        if(isEmpty())
        {
            return null;
        }
        else
        {
            T temp=top.data;
            top=top.Prelink;
            top.Nextlink=null;
            size--;
            return temp;
        }
    }
    public T RemoveAtStart()
    {
       if(isEmpty())
        {
            return null;
        }
       else
       {
           T temp=head.data;
           head=head.Nextlink;
           head.Prelink=null;
           size--;
           return temp;
       }
           
    }
    
    public int size()
    {
        return size;
    }
    public void Traverse()
    {
        Node temp=top;
        System.out.println("-------------------------------------------------");
        while(temp!=null)
        {
            System.out.print(temp.data+" | ");
            temp=temp.Prelink;
        }
        System.out.println("\n-------------------------------------------------");
    }
}
