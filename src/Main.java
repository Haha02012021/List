/******************************************************************************

 Online Java Compiler.
 Code, Compile, Run and Debug java program online.
 Write your code in this editor and press "Run" button to execute it.

 *******************************************************************************/
import java.util.*;

class Node {
    int value;
    Node next;

    void add(int x) {
        value = x;
    }
}

class List {
    Node front;
    Node back;
    int size;

    void insertBack(int x) {
        // insert x to the end of list
        if (front == null) {
            front = new Node();
            front.add(x);
            back = front;
            size++;
        }
        else {
            back.next = new Node();
            back.next.add(x);
            back = back.next;
            size++;
        }
    }

    void insertK(int x, int k) {
        // insert x to the position k of list
        Node newNode1 = front;
        for (int i = 0; i < k - 1; i++) newNode1 = newNode1.next;
        Node tmp1 = newNode1.next;
        newNode1.next = new Node();
        newNode1.next.add(x);
        newNode1.next.next = tmp1;
        size++;
    }

    void insertFront(int x) {
        // insert x to the beginning of the list
        Node newNode = new Node();
        newNode.add(x);
        newNode.next = front;
        front = newNode;
        size++;
    }

    void removeFront() {
        front = front.next;
        size--;
    }

    void removeK(int k) {
        Node newNode = front;
        //remove the kth elemement
        for (int i = 0; i < k - 1; i++) newNode = newNode.next;
        newNode.next = newNode.next.next;
    }

    void removeBack() {
        Node newNode = front;
        while (newNode.next != back) {
            newNode = newNode.next;
        }
        newNode.next = null;
    }

    int getValue(int k) {
        Node newNode = front;
        for (int i = 0; i < k; i++) newNode = newNode.next;
        return newNode.value;
    }

    void setValue(int x, int k) {
        Node newNode = front;
        for (int i = 0; i < k; i++) newNode = newNode.next;
        newNode.next.value = x;
    }

    void printList() {
        Node newNode = front;
        while (newNode != null) {
            System.out.print(newNode.value + " ");
            newNode = newNode.next;
        }
        System.out.println();
    }
}

public class Main
{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List list = new List();
        for (int i = 0; i < n; i++) {
            int x = sc.nextInt();
            list.insertBack(x);
        }

        list.printList();
        list.removeBack();
        list.printList();
        list.removeK(3);
        list.insertK(5, 2);
        list.printList();
        System.out.println(list.getValue(4));
    }
}


