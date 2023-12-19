
public class LL_Stack<T> {

    class Node {

        T data;
        Node link;
    }
    private Node top = null;
    private int size = 0;

    public boolean isEmpty() {
        if (top == null) {
            return true;
        }
        else {
            return false;
        }
    }

    public void push(T data) {
        Node n = new Node();
        n.data = data;
        n.link = top;
        top = n;
        size++;
    }

    public T pop() {
        if (isEmpty()) {
            System.out.println("Stack is empty");
            return null;
        }
        else {
            T var = top.data;
            top = top.link;
            size--;
            return var;
        }
    }

    public T peak() {
        T var = top.data;
        return var;
    }

    public void Traverse() {
        Node temp = top;
        System.out.println("-------------------------------------");
        while (temp != null) {
            System.out.print(temp.data + " | ");
            temp = temp.link;
        }
        System.out.println("\n-------------------------------------");
    }

    public int size() {
        return size;
    }

}
