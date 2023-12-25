/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author ameer
 */
public class BinarySearchTree
{

    class Node
    {

        int data;
        Node left, right;

        Node(int value)
        {
            this.data = value;
        }
    }
    private Node root = null;

    public void insert(int data)
    {
        root=insert(root, data);
    }

    private Node insert(Node n, int value)
    {
        if(n==null)
        {
            n=new Node(value);
        }
        else if(n.data>value)
        {
            n.left=insert(n.left, value);
        }
        else if(n.data<=value)
        {
            n.right=insert(n.right, value);
        }
        return n;
    }

    public void delete(int value)
    {
        delete(root, value);
    }

    private Node delete(Node n, int value)
    {
        if (n == null)
        {
            return n;
        }
        else if (n.data < value)
        {
            n.right = delete(n.right, value);
        }
        else if (n.data > value)
        {
            n.left = delete(n.left, value);
        }
        else
        {
            if (n.left == null && n.right == null)
            {
                return null;
            }
            else if (n.left == null)
            {
                return n.right;
            }
            else if (n.right == null)
            {
                return n.left;
            }
            else
            {
                Node successor = n.right;
                while (successor.left != null)
                {
                    successor = successor.left;
                }

                int temp = n.data;
                n.data = successor.data;
                successor.data = temp;

                n.right = delete(n.right, successor.data);
            }
        }
        return n;
    }

    public void search(int data)
    {
        Node temp = search(root, data);
        if (temp != null)
        {
            System.out.println("Found required Data");
        }
        else
        {
            System.out.println("Data not found");
        }
    }

    private Node search(Node n, int data)
    {
        if (n == null)
        {
            return n;
        }
        else if (n.data == data)
        {
            return n;
        }
        else
        {
            if (n.data > data)
            {
                return search(n.left, data);
            }
            else
            {
                return search(n.right, data);
            }
        }
    }

    public void traverse()
    {
        traverse(root);
    }

    private void traverse(Node n)
    {
        if (n != null)
        {
            System.out.print(n.data + " ");
            traverse(n.left);
            traverse(n.right);
        }
    }
}
