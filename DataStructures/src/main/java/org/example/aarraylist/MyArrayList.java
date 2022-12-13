package org.example.aarraylist;


import java.util.Arrays;
import java.util.Objects;

public class MyArrayList<T> {
    private final int ARRAY_SIZE = 16;
    private final int CUT_RATE = 4;
    private T[] array = (T[]) new Object[ARRAY_SIZE];
    private int counter = 0;

    public MyArrayList() {

    }

    public int size() {
        return counter;
    }

    public boolean add(T data) {
        if (counter == array.length) {
            resize(array.length * 2);
        }
        array[counter++] = data;
        return true;
    }

    private void resize(int newSize) {
        Object[] newArray = new Object[newSize];
        System.arraycopy(array, 0, newArray, 0, counter);
        array = (T[]) newArray;
    }

    public boolean remove(int index) {
        if (index < 0 || array.length <= index) {
            throw new IndexOutOfBoundsException("Такой позиции в массиве нет.");
        }
        for (int i = index; i < counter; i++) {
            array[i] = array[i + 1];
            if (array.length > ARRAY_SIZE && counter < array.length / CUT_RATE) {
                resize(array.length / 2);
            }
        }
        counter--;
        return true;
    }

    public T get(int index) {
        if (index < 0 || array.length <= index) {
            throw new IndexOutOfBoundsException("Такой позиции в массиве нет.");
        }
        return (T) array[index];
    }

    public void print() {
        System.out.print("[");
        for (int i = 0; i < counter; i++) {
            System.out.print(" " + array[i] + " ");
        }
        System.out.println("]");
    }

    public boolean contains(T data) {
        for (int i = 0; i < counter; i++) {
            if (data == null && array[i] == null) {
                return true;
            } else if (array[i].equals(data)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        return "MyArrayList{" +
                "ARRAY_SIZE=" + ARRAY_SIZE +
                ", CUT_RATE=" + CUT_RATE +
                ", array=" + Arrays.toString(array) +
                ", counter=" + counter +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MyArrayList<?> that = (MyArrayList<?>) o;
        return ARRAY_SIZE == that.ARRAY_SIZE && CUT_RATE == that.CUT_RATE && counter == that.counter && Arrays.equals(array, that.array);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(ARRAY_SIZE, CUT_RATE, counter);
        result = 31 * result + Arrays.hashCode(array);
        return result;
    }
}
