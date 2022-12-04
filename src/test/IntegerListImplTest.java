package test;
import main.service.IntegerListImpl;
import main.exception.WorkingArrayIntegerListException;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class IntegerListImplTest {

    private final IntegerListImpl arrayToTest = new IntegerListImpl();

    @BeforeEach
    public void setUp(){
        arrayToTest.add(1);
        arrayToTest.add(2);
        arrayToTest.add(3);
        arrayToTest.add(4);
    }


    @Test
    public void shouldReturnAddIntegerToArray() {
        Integer result = arrayToTest.add(5);
        assertEquals(5, result);
        Integer[] actual = new Integer[] {1, 2, 3, 4, 5, null, null};
        Assertions.assertArrayEquals(arrayToTest.getArrayList(), actual);
    }

    @Test
    public void shouldThrowAddNullIntegerExceptionWhenParameterIsNull() {
        assertThrows(WorkingArrayIntegerListException.class, () -> arrayToTest.add(null));
    }

    @Test
    public void shouldReturnSetIntegerToArray() {
        Integer result = arrayToTest.set(2, 5);
        assertEquals(5, result);
        Integer[] actual = new Integer[] {1, 2, 5, 4, null, null, null};
        Assertions.assertArrayEquals(arrayToTest.getArrayList(), actual);
    }

    @Test
    public void shouldThrowSetNullIntegerExceptionWhenParameterIsNull() {
        assertThrows(WorkingArrayIntegerListException.class, () -> arrayToTest.set(2, null));
    }

    @Test
    public void shouldReturnRemoveIntegerToArray() {
        Integer result = arrayToTest.remove(3);
        assertEquals(4, result);
        Integer[] actual = new Integer[] {1, 2, 3, null, null, null, null};
        Assertions.assertArrayEquals(arrayToTest.getArrayList(), actual);
    }

    @Test
    public void shouldThrowRemoveNullIntegerExceptionWhenParameterIsNull() {
        assertThrows(WorkingArrayIntegerListException.class, () -> arrayToTest.remove(null));
    }

    @Test
    public void shouldReturnContainsIntegerToArray() {
        boolean result = arrayToTest.contains(3);
        assertEquals(true, result);
    }

    @Test
    public void shouldReturnIndexIntegerToArray() {
        Integer result = arrayToTest.indexOf(2);
        assertEquals(1, result);
    }

    @Test
    public void shouldReturnLastIndexIntegerToArray() {
        int result = arrayToTest.lastIndexOf(10);
        assertEquals(-1, result);
    }

    @Test
    public void shouldReturnGetIntegerToArray() {
        Integer result = arrayToTest.get(3);
        assertEquals(4, result);
    }

    @Test
    public void shouldReturnSizeArray() {
        int result = arrayToTest.size();
        assertEquals(4, result);
    }

    @Test
    public void shouldReturnIsEmptyArray() {
        arrayToTest.remove(0);
        arrayToTest.remove(0);
        arrayToTest.remove(0);
        arrayToTest.remove(0);
        boolean result = arrayToTest.isEmpty();
        assertEquals(true, result);
    }

    @Test
    public void shouldReturnIsNotEmptyArray() {
        boolean result = arrayToTest.isEmpty();
        assertEquals(false, result);
    }

    @Test
    public void shouldReturnEqualsIntegerToArray() {

        Integer[] actual = new Integer[]{1, 2, 3, 4, null, null, null};

        Assertions.assertArrayEquals(arrayToTest.getArrayList(), actual);
    }


}