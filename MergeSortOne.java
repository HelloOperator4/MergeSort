package ru.mangadash;

import java.util.Arrays;

public class MergeSortOne {
    public static void main(String[] args) {
        int[] array = {3, 2, 14, 6, 97, 1, 16, 32, 7};
        sort(array, 0, array.length - 1);
        System.out.println(Arrays.toString(array));
    }

    public static void sort(int[] A, int p, int r) {
        if (p < r) {
            int q = (p + r) / 2;
            sort(A, p, q);
            sort(A, q + 1, r);
            merge(A, p, q, r);
        }
    }

    public static void merge(int[] array, int p, int q, int r) {
        int leftLength = q - p + 1;
        int rightLength =  r - q;

        int[] left = new int[leftLength];
        int[] right = new int[rightLength];

        System.arraycopy(array, p, left, 0, leftLength);
        System.arraycopy(array, q + 1, right, 0, rightLength);

        int positionA = 0;
        int positionB = 0;

        while (positionA < leftLength && positionB < rightLength) {
            if (left[positionA] <= right[positionB]) {
                array[p] = left[positionA];
                positionA++;
            } else {
                array[p] = right[positionB];
                positionB++;
            }
            p++;
        }

        while (positionA < leftLength) {
            array[p] = left[positionA];
            positionA++;
            p++;
        }

        while (positionB < rightLength) {
            array[p] = right[positionB];
            positionB++;
            p++;
        }
    }
}
