package ru.mangadash;

import java.util.Arrays;

public class MergeSortTwo {
    public static void main(String[] args) {
        int[] array = {1, 4, 8, 10, 20, 13, 2, 0};

        System.out.println(Arrays.toString(sortArray(array)));
    }

    public static int[] sortArray(int[] array) {
        if (array == null) {
            return null;
        }

        if (array.length < 2) {
            return array;
        }

        int[] arrayA = new int[array.length / 2];
        System.arraycopy(array, 0, arrayA, 0, array.length / 2);

        int[] arrayB = new int[array.length - array.length / 2];
        System.arraycopy(array, array.length / 2, arrayB, 0, array.length - array.length / 2);

        sortArray(arrayA);
        sortArray(arrayB);

        mergeArray(array, arrayA, arrayB);

        return array;
    }

    private static void mergeArray(int[] array, int[] arrayA, int[] arrayB) {
        int positionA = 0;
        int positionB = 0;

        for (int i = 0; i < array.length; i++) {
            if (positionA == arrayA.length) {
                array[i] = arrayB[positionB];
                positionB++;
            } else if (positionB == arrayB.length) {
                array[i] = arrayA[positionA];
                positionA++;
            } else if (arrayA[positionA] < arrayB[positionB]) {
                array[i] = arrayA[positionA];
                positionA++;
            } else {
                array[i] = arrayB[positionB];
                positionB++;
            }
        }
    }
}