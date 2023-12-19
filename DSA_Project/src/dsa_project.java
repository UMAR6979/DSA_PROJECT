/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */

/**
 *
 * @author ameer
 */
public class dsa_project {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ARRAY_Stack l=new ARRAY_Stack();
        l.push(10);
        l.push(20);
        l.push(12);
        l.push(43);
        l.push(60);
        l.push(70);
        l.push(30);
        l.pop();
        l.push(50);
        l.push(52);
        l.push(88);
        l.push(34);
        l.push(50);
        System.out.println(l.peak());
        System.out.println(l.size());
        l.Traverse();
    }
    
}
