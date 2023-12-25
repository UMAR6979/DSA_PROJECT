/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author ameer
 */
public class BinaryTree<T>
{

    class Node
    {

        T data;
        Node left;
        Node right;

        Node(T value)
        {
            this.data = value;
            this.left = null;
            this.right = null;
        }
    }
    Node root;

    public void insertRoot(T value)
    {
        Node n = new Node(value);
        if (root != null)
        {
            System.out.println("Root Already Exist");
        }
        else
        {
            root = n;
        }
    }

    public void insertAtright(T value, T ParentValue)
    {
        Node n = new Node(value);
        Node Parent = search(root, ParentValue);
        if (Parent != null)
        {
            if (Parent.right == null)
            {
                Parent.right = n;
            }
            else
            {
                System.out.println("Right Child is Not Empty");
            }
        }
        else
        {
            System.out.println("Node not found");
        }

    }

    public void insertAtleft(T value, T ParentValue)
    {
        Node n = new Node(value);
        Node Parent = search(root, ParentValue);
        if (Parent != null)
        {
            if (Parent.left == null)
            {
                Parent.left = n;
            }
            else
            {
                System.out.println("Left Child is Not Empty");
            }
        }
        else
        {
            System.out.println("Node not found");
        }
    }

    public Node search(Node node, T key)
    {
        if (node == null || node.data == key)
        {
            return node;
        }
        Node left = search(node.left, key);
        if (left != null)
        {
            return left;
        }
        else
        {
            return search(node.right, key);
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
