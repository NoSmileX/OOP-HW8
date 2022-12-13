package org.example.linkedlist;

public class Main {
    public static void main(String[] args) {
        MyLinkedList<Integer> list = new MyLinkedList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);
        list.add(7);
        list.add(8);
        list.add(9);
        list.add(10);


        list.remove(0);
        list.remove(2);
        list.remove(2);
        list.remove(6);
        System.out.println("---");
        System.out.println(list.get(5));
        System.out.println("---");
        System.out.println(list.contains(6));
        System.out.println("---");
        list.print();
    }
}
