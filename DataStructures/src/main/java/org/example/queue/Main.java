package org.example.queue;

import java.util.LinkedList;

public class Main {
    public static void main(String[] args) {
        LinkedList<Integer> tt = new LinkedList<>();
        MyQueue<Integer> q = new MyQueue<>();
        q.add(1);
        q.add(2);
        q.add(3);
        q.add(4);
        q.add(5);
        q.add(6);

        q.print();
        System.out.println(q.getSize());

        System.out.println(q.peek());
        q.print();

        System.out.println(q.poll());
        q.add(7);

        q.print();

    }
}
