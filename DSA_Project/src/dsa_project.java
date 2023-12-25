/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */

/**
 *
 * @author ameer
 */
public class dsa_project
{

    /**
     * @param args the command line arguments
     */
    public static void FactorialWithStack(int value)
    {
        LL_Stack<Integer> s = new LL_Stack<>();
        s.push(1);
        for (int i = value; i > 0; i--)
        {
            s.push(i);
            s.push(s.pop() * s.pop());
        }
        System.out.println("Factorial of " + value + " = " + s.pop());
    }

    public static String InfixToPostfixWithStack(String exp)
    {
        LL_Stack<Character> s = new LL_Stack<>();
        String cExp = "";
        for (int i = 0; i < exp.length(); i++)
        {
            char c = exp.charAt(i);
            if (Character.isLetterOrDigit(c))
            {
                cExp += c;
            }
            else if (c == '(')
            {
                s.push(c);
            }
            else if (c == ')')
            {
                while (!s.isEmpty() && s.peak() == '(')
                {
                    cExp += s.pop();
                }
                s.pop();
            }
            else
            {
                while (!s.isEmpty() && prec(c) < prec(s.peak()))
                {
                    cExp += s.pop();
                }
                s.push(c);
            }
        }
        while (!s.isEmpty())
        {
            cExp += s.pop();
        }
        return cExp;
    }

    public static String InfixToPrefixWithStack(String exp)
    {
        String reversedExp = "";
        for (int i = exp.length() - 1; i >= 0; i--)
        {
            if (exp.charAt(i) == '(')
            {
                reversedExp += ")";
            }
            else if (exp.charAt(i) == ')')
            {
                reversedExp += "(";
            }
            else
            {
                reversedExp += exp.charAt(i);
            }
        }
        LL_Stack<Character> s = new LL_Stack<>();
        String cExp = "";
        for (int i = 0; i < exp.length(); i++)
        {
            char c = exp.charAt(i);
            if (Character.isLetterOrDigit(c))
            {
                cExp += c;
            }
            else if (c == '(')
            {
                s.push(c);
            }
            else if (c == ')')
            {
                while (!s.isEmpty() && s.peak() == '(')
                {
                    cExp += s.pop();
                }
                s.pop();
            }
            else
            {
                while (!s.isEmpty() && prec(c) <= prec(s.peak()))
                {
                    cExp += s.pop();
                }
                s.push(c);
            }
        }
        while (!s.isEmpty())
        {
            cExp += s.pop();
        }
        String temp = cExp;

        String preExp = "";
        for (int j = temp.length() - 1; j >= 0; j--)
        {
            if (temp.charAt(j) == '(')
            {
                preExp += ")";
            }
            else if (temp.charAt(j) == ')')
            {
                preExp += "(";
            }
            else
            {
                preExp += temp.charAt(j);
            }
        }
        return preExp;
    }

    public static String InfixToPostfixWithDe_Queue(String exp)
    {
        Dequeue<Character> s = new Dequeue<>();
        String cExp = "";
        for (int i = 0; i < exp.length(); i++)
        {
            char c = exp.charAt(i);
            if (Character.isLetterOrDigit(c))
            {
                cExp += c;
            }
            else if (c == '(')
            {
                s.InsertAtEnd(c);
            }
            else if (c == ')')
            {
                while (!s.isEmpty() && s.peak() == '(')
                {
                    cExp += s.RemoveAtEnd();
                }
                s.RemoveAtEnd();
            }
            else
            {
                while (!s.isEmpty() && prec(c) < prec(s.peak()))
                {
                    cExp += s.RemoveAtEnd();
                }
                s.InsertAtEnd(c);
            }
        }
        while (!s.isEmpty())
        {
            cExp += s.RemoveAtEnd();
        }
        return cExp;
    }

    public static String InfixToPrefixWithDe_Queue(String exp)
    {
        String reversedExp = "";
        for (int i = exp.length() - 1; i >= 0; i--)
        {
            if (exp.charAt(i) == '(')
            {
                reversedExp += ")";
            }
            else if (exp.charAt(i) == ')')
            {
                reversedExp += "(";
            }
            else
            {
                reversedExp += exp.charAt(i);
            }
        }
        Dequeue<Character> s = new Dequeue<>();
        String cExp = "";
        for (int i = 0; i < exp.length(); i++)
        {
            char c = exp.charAt(i);
            if (Character.isLetterOrDigit(c))
            {
                cExp += c;
            }
            else if (c == '(')
            {
                s.InsertAtEnd(c);
            }
            else if (c == ')')
            {
                while (!s.isEmpty() && s.peak() == '(')
                {
                    cExp += s.RemoveAtEnd();
                }
                s.RemoveAtEnd();
            }
            else
            {
                while (!s.isEmpty() && prec(c) <= prec(s.peak()))
                {
                    cExp += s.RemoveAtEnd();
                }
                s.InsertAtEnd(c);
            }
        }
        while (!s.isEmpty())
        {
            cExp += s.RemoveAtEnd();
        }
        String temp = cExp;

        String preExp = "";
        for (int j = temp.length() - 1; j >= 0; j--)
        {
            if (temp.charAt(j) == '(')
            {
                preExp += ")";
            }
            else if (temp.charAt(j) == ')')
            {
                preExp += "(";
            }
            else
            {
                preExp += temp.charAt(j);
            }
        }
        return preExp;
    }

    private static int prec(char op)
    {
        if (op == '^')
        {
            return 3;
        }
        else if (op == '*' && op == '/')
        {
            return 2;
        }
        else if (op == '+' && op == '-')
        {
            return 1;
        }
        else
        {
            return 0;
        }
    }

    public static void PostfixEvaluationWithStack(String exp)
    {
        LL_Stack<Double> st = new LL_Stack<>();
        String[] temp = exp.split(" ");
        for (int i = 0; i < temp.length; i++)
        {
            if (Character.isDigit(temp[i].charAt(0)))
            {
                st.push(Double.parseDouble(temp[i]));
            }
            else
            {
                double op2 = st.pop();
                double op1 = st.pop();
                double d = calculate(op1, temp[i], op2);
                st.push(d);
            }
        }
        System.out.println("Postfix Evaluaton With Stack = " + st.pop());
    }

    public static void PrefixEvaluationWithStack(String exp)
    {
        LL_Stack<Double> st = new LL_Stack<>();
        String[] temp = exp.split(" ");
        for (int i = temp.length - 1; i >= 0; i--)
        {
            if (Character.isDigit(temp[i].charAt(0)))
            {
                st.push(Double.parseDouble(temp[i]));
            }
            else
            {
                double op2 = st.pop();
                double op1 = st.pop();
                double d = calculate(op1, temp[i], op2);
                st.push(d);
            }
        }
        System.out.println("Postfix Evaluaton With Stack = " + st.pop());
    }

    public static double calculate(double op1, String op, double op2)
    {
        if (op.equals("+"))
        {
            return op1 + op2;
        }
        else if (op.equals("-"))
        {
            return op1 - op2;
        }
        else if (op.equals("*"))
        {
            return op1 * op2;
        }
        else if (op.equals("/"))
        {
            return op1 / op2;
        }
        else if (op.equals("%"))
        {
            return op1 % op2;
        }
        else
        {
            return Math.pow(op1, op2);
        }
    }

    public static void PostfixEvaluationWithDe_Queue(String exp)
    {
        Dequeue<Double> de = new Dequeue<>();
        String[] temp = exp.split(" ");
        for (int i = 0; i < temp.length; i++)
        {
            if (Character.isDigit(temp[i].charAt(0)))
            {
                de.InsertAtStart(Double.parseDouble(temp[i]));
            }
            else
            {
                double op2 = de.RemoveAtStart();
                double op1 = de.RemoveAtStart();
                double d = calculate(op1, temp[i], op2);
                de.InsertAtStart(d);
            }
        }
        System.out.println("Postfix Evaluaton With DeQueue= " + de.RemoveAtStart());
    }

    public static void PrefixEvaluationWithDe_Queue(String exp)
    {
        Dequeue<Double> de = new Dequeue<>();
        String[] temp = exp.split(" ");
        for (int i = temp.length - 1; i >= 0; i--)
        {
            if (Character.isDigit(temp[i].charAt(0)))
            {
                de.InsertAtStart(Double.parseDouble(temp[i]));
            }
            else
            {
                double op2 = de.RemoveAtStart();
                double op1 = de.RemoveAtStart();
                double d = calculate(op1, temp[i], op2);
                de.InsertAtStart(d);
            }
        }
        System.out.println("Postfix Evaluaton With DeQueue= " + de.RemoveAtStart());
    }

    public static void main(String[] args)
    {
//        FactorialWithStack(5);
//        System.out.println("Postfix Expression With Stack= " + InfixToPostfixWithStack("a+b*c"));
//        System.out.println("Postfix Expression With DeQueue= " + InfixToPostfixWithDe_Queue("a+b*c"));
//        PostfixEvaluationWithStack("9 7 2 * +");
//        PostfixEvaluationWithDe_Queue("9 7 2 * +");
//        System.out.println("Prefix Expression With Stack= " + InfixToPrefixWithStack("a+b*c"));
//        System.out.println("Prefix Expression With DeQueue= " + InfixToPrefixWithDe_Queue("a+b*c"));
//        PrefixEvaluationWithDe_Queue("+ 2 * 9 2");
//        PrefixEvaluationWithStack("+ 2 * 9 2");

//
//        ARRAY_Stack l = new ARRAY_Stack();
//        l.push(10);
//        l.push(20);
//        l.push(12);
//        l.push(43);
//        l.push(60);
//        l.push(70);
//        l.push(30);
//        l.pop();
//        l.push(50);
//        l.push(52);
//        l.push(88);
//        l.push(34);
//        l.push(50);
//        System.out.println(l.peak());
//        System.out.println(l.size());
//        l.Traverse();
//        queue<Integer> q1 = new queue<>();
//        q1.enqueue(10);
//        q1.enqueue(31);
//        q1.Traverse();
//        q1.dequeue();
//        q1.dequeue();
//        q1.Traverse();
//        CircularQueue<Integer> c = new CircularQueue<>();
//        c.enqueue(10);
//        c.enqueue(20);
//        c.enqueue(30);
//        c.enqueue(40);
//        c.enqueue(50);
//        c.dequeue();
//        c.Traverse();
//        Dequeue<Integer> d = new Dequeue<>();
//        d.InsertAtEnd(10);
//        d.InsertAtEnd(11);
//        d.InsertAtEnd(12);
//        d.InsertAtEnd(13);
//        d.InsertAtStart(9);
//        System.out.println(d.size());
//        d.RemoveAtEnd();
//        d.RemoveAtStart();
//        d.RemoveAtStart();
//        System.out.println(d.size());
//        d.RemoveAtStart();
//        d.RemoveAtStart();
//        d.Traverse();
//        ArrayDequeue arr = new ArrayDequeue();
//        arr.enqueueAtstart(10);
//        arr.enqueueAtstart(20);
//        arr.enqueueAtlast(30);
//        arr.dequeueAtLast();
//        arr.dequeueAtstart();
//        arr.traverse();
//        PriorityQueue<Integer> pq = new PriorityQueue<>();
//        pq.enqueue(10, 3);
//        pq.enqueue(20, 2);
//        pq.enqueue(30, 1);
//        pq.enqueue(40, 3);
//        pq.enqueue(250, 1);
//        pq.dequeue();
//        pq.dequeue();
//        pq.dequeue();
//        pq.Traverse();
//        ArrayQueue a = new ArrayQueue();
//        a.enqueue(10);
//        a.enqueue(20);
//        a.enqueue(30);
//        a.enqueue(40);
//        a.enqueue(50);
//        a.dequeue();
//        a.traverse();
//        BinaryTree<Integer> b = new BinaryTree<>();
//        b.insertRoot(10);
//        b.insertAtleft(30, 10);
//        b.insertAtright(40, 30);
//        b.insertAtright(5, 10);
//        b.traverse();
//        BinarySearchTree bt = new BinarySearchTree();
//        bt.insert(10);
//        bt.insert(20);
//        bt.insert(5);
//        bt.insert(25);
//        bt.insert(27);
//        bt.insert(21);
//        bt.delete(5);
//        bt.search(101);
//        bt.traverse();
//        AvlTree tree = new AvlTree();
//        tree.insert(5);
//        tree.insert(3);
//        tree.insert(7);
//        tree.insert(2);
//        tree.insert(4);
//        tree.insert(6);
//        tree.insert(8);
//        tree.delete(3);
//        tree.PreOrder();
    }

}
