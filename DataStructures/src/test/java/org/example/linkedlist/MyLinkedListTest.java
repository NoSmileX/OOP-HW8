package org.example.linkedlist;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MyLinkedListTest {

    MyLinkedList<Integer> list = new MyLinkedList<>();

    @BeforeEach
    public void fillList(){
        list.add(1);
        list.add(3);
        list.add(2);

    }

    @Test
    void testAdd() {
        assertTrue(list.add(1));
    }

    @Test
    void testRemove() {
        assertTrue(list.remove(0));
    }

    @Test
    void testGet() {
        int result = list.get(1);
        int expected = 3;
        assertEquals(expected, result);
    }

    @Test
    void testContains() {
        assertTrue(list.contains(2));
    }
}