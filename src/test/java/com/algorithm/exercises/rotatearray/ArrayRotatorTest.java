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
        ArrayRotator rotator = new ArrayRotator(array);

        // when
        int[] rotatedArray = rotator.rotate(k);

        // then
        int[] expected = new int[]{5,6,7,1,2,3,4};
        assertArrayEquals(expected, rotatedArray);
    }

    @Test
    void exceptionWhenKisBiggerThanArraySize() {
        // Given
        int[] array = new int[]{1,2};
        int k = 3;
        ArrayRotator rotator = new ArrayRotator(array);

        // Then
        assertThrowsExactly(IllegalArgumentException.class, () -> rotator.rotate(k));
    }

    @Test
    void exceptionWhenKIsLowerThanZero() {
        // Given
        int[] array = new int[]{1,2};
        int k = -1;
        ArrayRotator rotator = new ArrayRotator(array);

        // Then
        assertThrowsExactly(IllegalArgumentException.class, () -> rotator.rotate(k));
    }

    @Test
    void exceptionWhenArrayIsNull() {
        // Then
        assertThrowsExactly(IllegalArgumentException.class, () -> new ArrayRotator(null));
    }
}