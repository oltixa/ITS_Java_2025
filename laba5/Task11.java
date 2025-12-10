package laba5;

import java.util.Arrays;

public class Task11 {
    public static void main(String[] args) {
        byte[] array = {12, 5, -3, 45, 0, 7, 22};

        System.out.println("Початковий масив:" + Arrays.toString(array) );

        // Копії масиву для різних методів
        byte[] selectionSorted = array.clone();
        byte[] insertionSorted = array.clone();

        selectionSort(selectionSorted);
        insertionSort(insertionSorted);

        System.out.println("Після Selection sort (за зростанням): " + Arrays.toString(selectionSorted));
        System.out.println("Після Insertion sort (за зростанням): " + Arrays.toString(insertionSorted));
    }

    // Selection sort
    public static void selectionSort(byte[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            byte temp = arr[i];
            arr[i] = arr[minIndex];
            arr[minIndex] = temp;
        }
    }

    // Insertion sort
    public static void insertionSort(byte[] arr) {
        for (int i = 1; i < arr.length; i++) {
            byte key = arr[i];
            int j = i - 1;

            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
        }
    }
}
