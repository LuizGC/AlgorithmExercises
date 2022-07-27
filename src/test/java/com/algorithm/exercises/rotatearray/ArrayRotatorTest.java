package com.algorithm.exercises.rotatearray;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertThrowsExactly;

class ArrayRotatorTest {

    @Test
    void rotate() {
        // Given
        int[] array = new int[]{1,2,3,4,5,6,7};
        int k = 3;
        ArrayRotator rotator = new ArrayRotator();

        // when
        int[] rotatedArray = rotator.rotate(array, k);

        // then
        int[] expected = new int[]{5,6,7,1,2,3,4};
        assertArrayEquals(expected, rotatedArray);
    }

    @Test
    void exceptionWhenKisBiggerThanArraySize() {
        // Given
        int[] array = new int[]{1,2};
        int k = 3;
        ArrayRotator rotator = new ArrayRotator();

        // Then
        assertThrowsExactly(IllegalArgumentException.class, () -> rotator.rotate(array, k));
    }

    @Test
    void exceptionWhenKIsLowerThanZero() {
        // Given
        int[] array = new int[]{1,2};
        int k = -1;
        ArrayRotator rotator = new ArrayRotator();

        // Then
        assertThrowsExactly(IllegalArgumentException.class, () -> rotator.rotate(array, k));
    }

    @Test
    void exceptionWhenArrayIsNull() {
        // Given
        int[] array = null;
        int k = 3;
        ArrayRotator rotator = new ArrayRotator();

        // Then
        assertThrowsExactly(IllegalArgumentException.class, () -> rotator.rotate(array, k));
    }
}