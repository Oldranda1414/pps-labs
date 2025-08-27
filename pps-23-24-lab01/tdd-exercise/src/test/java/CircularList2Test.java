import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.Iterator;

import tdd2.CircularList2;
import tdd2.CircularList2Impl;

public class CircularList2Test {

    private CircularList2 circularList;
    private int TEST_VALUE = 1;
    private int SECOND_TEST_VALUE = 2;

    @BeforeEach
    void beforeEach(){
        circularList = new CircularList2Impl();
    }

    @Test
    void testEmptyList(){
        assertAll(
            () -> assertTrue(circularList.isEmpty()),
            () -> assertEquals(0, circularList.size()),
            () -> assertEquals(Collections.emptyIterator(), circularList.forwardIterator()),
            () -> assertEquals(Collections.emptyIterator(), circularList.backwardIterator())
        );
    }
    
    @Test
    void testForwardIterator(){
        addTwoElements();
        Iterator<Integer> iter = circularList.forwardIterator();
        assertAll(
            () -> assertEquals(TEST_VALUE, iter.next()),
            () -> assertEquals(SECOND_TEST_VALUE, iter.next()),
            () -> assertEquals(TEST_VALUE, iter.next())
        );
    }

    @Test
    void testBackwardIterator(){
        addTwoElements();
        Iterator<Integer> iter = circularList.backwardIterator();
        assertAll(
            () -> assertEquals(TEST_VALUE, iter.next()),
            () -> assertEquals(SECOND_TEST_VALUE, iter.next()),
            () -> assertEquals(TEST_VALUE, iter.next())
        );
    }

    private void addTwoElements(){
        circularList.add(TEST_VALUE);
        circularList.add(SECOND_TEST_VALUE);
    }
}
