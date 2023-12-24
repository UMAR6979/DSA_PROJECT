/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author ameer
 */
public class PriorityQueue<T> {

    queue<T> q1=new queue<>();
    queue<T> q2=new queue<>();
    queue<T> q3=new queue<>();
    
    
    public void enqueue(T data,int Priority)
    {
        if(Priority==1)
        {
            q1.enqueue(data);
        }
        else if(Priority==2)
        {
            q2.enqueue(data);
        }
        else
        {
            q3.enqueue(data);
        }
    }
    
    public void dequeue()
    {
        if(q1.isEmpty()==false)
        {
            q1.dequeue();
        }
        else if(q2.isEmpty()==false)
        {
            q2.dequeue();
        }
        else
        {
            q3.dequeue();
        }
    }
    
    public void Traverse()
    {
           q1.Traverse();
            q2.Traverse();
            q3.Traverse();
        
    }
}
