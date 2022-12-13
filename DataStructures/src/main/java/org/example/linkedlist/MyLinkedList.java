package org.example.linkedlist;

import java.util.Objects;

public class MyLinkedList<T> {
    private int size = 0;
    private Node<T> first;
    private Node<T> last;


    public MyLinkedList() {
    }

    public int getSize() {
        return size;
    }

    public boolean add(T data) {

        if (first == null) {
            first = new Node<>(null, data, null);
            last = first;
        } else {
            last.next = new Node<>(last, data, null);
            last = last.next;
        }
        size++;
        return true;
    }

    public boolean remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Ошибка. Несуществующая позиция в списке.");
        }
        if (index == 0) {
            first = first.next;
            if (first != null) {
                first.prev = null;
            }
        } else if (index == size - 1) {
            last = last.prev;
            last.next = null;
        } else {
            if (size / 2 >= index) {
                Node<T> currentNode = first;
                for (int i = 0; i < index; i++) {
                    currentNode = currentNode.next;
                }
                currentNode.prev.next = currentNode.next;
                if (currentNode.next != null) {
                    currentNode.next.prev = currentNode.prev;
                }
            } else {
                Node<T> currentNode = last;
                for (int i = size - 1; i > index; i--) {
                    currentNode = currentNode.prev;
                }
                currentNode.next.prev = currentNode.prev;
                if (currentNode.prev != null) {
                    currentNode.prev.next = currentNode.next;
                }
            }

        }

        size--;
        return true;
    }

    public T get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Ошибка. Несуществующая позиция в списке.");
        }
        if (size / 2 >= index) {
            Node<T> currentNode = first;
            for (int i = 0; i < index; i++) {
                currentNode = currentNode.next;
            }
            return currentNode.item;
        } else {
            Node<T> currentNode = last;
            for (int i = size - 1; i > index; i--) {
                currentNode = currentNode.prev;
            }
            return currentNode.item;
        }
    }

    public void print() {
        Node<T> current = first;
        while (current != null) {
            System.out.println(current.item);
            current = current.next;
        }
    }

    public boolean contains(T data) {
        Node<T> currentNode = first;
        for (int i = 0; i < size; i++) {
            if (currentNode.item.equals(data)) {
                return true;
            }
            currentNode = currentNode.next;
        }
        return false;
    }

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

    @Override
    public String toString() {
        return "MyLinkedList{" +
                "size=" + size +
                ", first=" + first +
                ", last=" + last +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MyLinkedList<?> that = (MyLinkedList<?>) o;
        return size == that.size && Objects.equals(first, that.first) && Objects.equals(last, that.last);
    }

    @Override
    public int hashCode() {
        return Objects.hash(size, first, last);
    }
}
