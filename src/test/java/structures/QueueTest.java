package structures;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class QueueTest {
    Queue<Object> q = new Queue<>();

    @BeforeEach
    void resetQueue() {
        q = new Queue<>();
    }

    @Test
    void emptyConstructor_isEmptyQueue() {
        assertTrue(q.isEmpty());
    }

    @Test
    void enqueue_increasesLengthByOne() {
        q.enqueue(1);
        assertEquals(1, q.length());
        q.enqueue(2);
        assertEquals(2, q.length());
    }

    @Test
    void enqueue_addsItemToEndOfQueue() {
        q.enqueue(1);
        q.enqueue(2);
        assertEquals("[1, 2]", q.toString());
    }

    @Test
    void dequeue_emptyQueueThrowsException() {
        assertThrows(NullPointerException.class, () -> q.dequeue());
    }

    @Test
    void dequeue_retrievesFirstAdded() {
        q.enqueue(1);
        q.enqueue(2);
        q.enqueue(3);
        assertEquals(1, q.dequeue());
        assertEquals(2, q.dequeue());
        assertEquals(3, q.dequeue());
        assertTrue(q.isEmpty());
    }

    @Test
    void dequeueEnqueueSequence_orderPreserved() {
        q.enqueue(1);
        q.enqueue(2);
        q.enqueue(3);
        q.dequeue();
        q.enqueue(4);
        q.dequeue();
        q.enqueue(5);
        q.dequeue();
        assertEquals(4, q.dequeue());
    }

    @Test
    void peek_emptyQueueThrowsException() {
        assertThrows(NullPointerException.class, () -> q.peek());
    }

    @Test
    void peek_doesNotRemoveElement() {
        q.enqueue(1);
        q.enqueue(2);
        q.peek();
        assertEquals(2, q.length());
    }

    @Test
    void length_variousLengths() {
        assertEquals(0, q.length());
        q.enqueue(1);
        assertEquals(1, q.length());
        q.enqueue(2);
        assertEquals(2, q.length());
        q.peek();
        assertEquals(2, q.length());
        q.dequeue();
        assertEquals(1, q.length());
    }

    @Test
    void toString_emptyQueue() {
        assertEquals("[]", q.toString());
    }

    @Test
    void variableConstructor_validInput() {
        q = new Queue<>(1, 2, 3, 4, 5);
        assertEquals(1, q.dequeue());
        assertEquals(2, q.peek());
        assertEquals(4, q.length());
        assertEquals("[2, 3, 4, 5]", q.toString());
    }

    @Test
    void toString_variousQueues() {
        Queue<Integer> q1 = new Queue<>(4, 5, 6, 7, 8);
        assertEquals("[4, 5, 6, 7, 8]", q1.toString());
        Queue<Integer> q2 = new Queue<>(-1, 1, 3, 5, 7);
        assertEquals("[-1, 1, 3, 5, 7]", q2.toString());
        Queue<String> q3 = new Queue<>(", ", ", ", ", ");
        assertEquals("[, , , , , ]", q3.toString());
    }

    @Test
    void equals_identitySameReturnsTrue() {
        Queue<Object> q0 = q;
        assertEquals(q0, q);
    }

    @Test
    void equals_notQueueReturnsFalse() {
        assertFalse(q.equals(new ArrayList<Integer>()));
    }

    @Test
    void equals_elementsSameTypeParameterSameReturnsTrue() {
        Queue<Integer> q0 = new Queue<>(1, 2, 3, 4, 5);
        Queue<Integer> q1 = new Queue<>(1, 2, 3, 4, 5);
        assertEquals(q0, q1);
    }

    @Test
    void equals_elementsSameTypeParameterDifferentReturnsTrue() {
        Queue<Object> q0 = new Queue<>(1, 2, 3, 4, 5);
        Queue<Integer> q1 = new Queue<>(1, 2, 3, 4, 5);
        assertEquals(q0, q1);
    }

    @Test
    void equals_elementsDifferentReturnsFalse() {
        Queue<Integer> q0 = new Queue<>(1, 2, 3, 4, 6);
        Queue<Integer> q1 = new Queue<>(1, 2, 3, 4, 5);
        assertNotEquals(q0, q1);
    }

    @Test
    void equals_elementsSameButDifferentOrderReturnsFalse() {
        Queue<Integer> q0 = new Queue<>(1, 2, 3, 5, 4);
        Queue<Integer> q1 = new Queue<>(1, 2, 3, 4, 5);
        assertNotEquals(q0, q1);
    }

    @Test
    void clear_variousQueuesGivesEmptyQueue() {
        q.clear();
        assertTrue(q.isEmpty());
        q.enqueue(1);
        q.enqueue(2);
        q.clear();
        assertTrue(q.isEmpty());
        Queue<Integer> q0 = new Queue<>(1, 2, 3, 4, 5);
        q0.clear();
        assertTrue(q0.isEmpty());
    }
}