package org.example.queue;

import java.util.Objects;

public class MyQueue<T> {
    private Node<T> front;
    private Node<T> rear;
    private int size;

    private static class Node<T> {
        private T item;
        private Node<T> next;
        private Node<T> prev;

        public Node(Node<T> prev, T item, Node<T> next) {
            this.item = item;
            this.next = next;
            this.prev = prev;
        }
    }

    public MyQueue() {
    }

    public T getFront() {
        return front.item;
    }

    public T getRear() {
        return rear.item;
    }

    public int getSize() {
        return size;
    }

    public boolean add(T data) {
        if (front == null) {
            front = new Node<>(null, data, null);
            rear = front;
        } else {
            rear.next = new Node<>(rear, data, null);
            rear = rear.next;
        }
        size++;
        return true;
    }

    public T remove() {
        T current = front.item;
        Node<T> next = front.next;
        front = next;
        if (next == null) {
            rear = null;
        } else {
            next.prev = null;
        }
        size--;
        return current;
    }

    public T poll() {// получаем и удаляем
        Node<T> f = front;
        return (f == null) ? null : remove();
    }

    public T peek() {//получаем без удаления
        Node<T> f = front;
        return (f == null) ? null : f.item;
    }

    public boolean contains(T data) {
        Node<T> currentNode = front;
        for (int i = 0; i < size; i++) {
            if (currentNode.item.equals(data)) {
                return true;
            }
            currentNode = currentNode.next;
        }
        return false;
    }

    public void print() {
        System.out.print("[ ");
        Node<T> current = front;
        while (current != null) {
            System.out.print(current.item + " ");
            current = current.next;
        }
        System.out.println("]");
    }

    public boolean isEmpty() {
        return (size == 0);
    }

    @Override
    public String toString() {
        return "MyQueue{" +
                "front=" + front +
                ", rear=" + rear +
                ", size=" + size +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MyQueue<?> myQueue = (MyQueue<?>) o;
        return size == myQueue.size && Objects.equals(front, myQueue.front) && Objects.equals(rear, myQueue.rear);
    }

    @Override
    public int hashCode() {
        return Objects.hash(front, rear, size);
    }
}
