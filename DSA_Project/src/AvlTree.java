/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author ameer
 */
public class AvlTree
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
        root = insert(root, data);
    }

    private Node insert(Node n, int value)
    {
        if (n == null)
        {
            n = new Node(value);
        }
        else if (n.data > value)
        {
            n.left = insert(n.left, value);
        }
        else if (n.data <= value)
        {
            n.right = insert(n.right, value);
        }
        Balance(n);
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
        Balance(n);
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

    public void PreOrder()
    {
        PreOrder(root);
    }

    private void PreOrder(Node n)
    {
        if (n != null)
        {
            System.out.print(n.data + " ");
            PreOrder(n.left);
            PreOrder(n.right);
        }
    }

    private int height(Node n)
    {
        if (n == null)
        {
            return -1;
        }
        else
        {
            return 1 + Math.max(height(n.left), height(n.right));
        }
    }

    private int BalanceFactor(Node n)
    {
        return (height(n.left) - height(n.right));
    }

    private Node RotateLeft(Node n)
    {
        Node temp1 = n;
        Node temp2 = n.right.left;
        n = n.right;
        n.left = temp1;
        n.left.right = temp2;
        return n;
    }

    private Node RotateRight(Node n)
    {
        Node temp1 = n;
        Node temp2 = n.left.right;
        n = n.left;
        n.right = temp1;
        n.right.left = temp2;
        return n;
    }

    private Node Balance(Node n)
    {
        if (BalanceFactor(n) == 2 && BalanceFactor(n.left) == 1)
        {
            n = RotateRight(n);
        }
        else if (BalanceFactor(n) == -2 && BalanceFactor(n.right) == -1)
        {
            n = RotateLeft(n);
        }
        else if (BalanceFactor(n) == 2 && BalanceFactor(n.left) == -1)
        {
            n.left = RotateLeft(n.left);
            n = RotateRight(n);
        }
        else if (BalanceFactor(n) == -2 && BalanceFactor(n.right) == 1)
        {
            n.right = RotateRight(n.right);
            n = RotateLeft(n);
        }
        else if (BalanceFactor(n) == 2)
        {
            n = RotateRight(n);
        }
        else if (BalanceFactor(n) == -2)
        {
            n = RotateLeft(n);
        }
        return n;
    }

}
