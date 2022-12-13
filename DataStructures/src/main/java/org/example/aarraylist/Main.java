package org.example.aarraylist;

public class Main {
    public static void main(String[] args) {
        MyArrayList <Integer> arr = new MyArrayList<>();

        arr.add(1);
        arr.add(3);
        arr.add(1);
        arr.add(1);
        arr.add(4);

        arr.print();

        arr.remove(4);
        arr.print();
        System.out.println(arr.contains(1));
        System.out.println(arr.size());
    }
}
