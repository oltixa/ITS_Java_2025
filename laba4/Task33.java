import java.util.Arrays;


public class Task33 {
    // Метод, що формує новий масив за заданим правилом
    public static int[] transformArray(int[] array) {
        if (array == null)
            throw new NullPointerException("Масив не може бути null");

        int[] result = new int[array.length];

        for (int i = 0; i < array.length; i++) {
            if (array[i] < 0) {
                result[i] = array[i] * -1; // від’ємні -> помножити на -1
            } else if (array[i] > 0) {
                result[i] = array[i] - 3; // додатні -> зменшити на 3
            } else {
                result[i] = -2; // нулі -> -2
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[] arr1 = {-5, 0, 7, -3, 2};
        int[] arr2 = {3, 0, -1};
        int[] arr3 = {0, 0, 0};
        int[] arr4 = {-2, -8, 9, 4};

        System.out.println("Тест 1: " + Arrays.toString(transformArray(arr1)));
        System.out.println("Тест 2: " + Arrays.toString(transformArray(arr2)));
        System.out.println("Тест 3: " + Arrays.toString(transformArray(arr3)));
        System.out.println("Тест 4: " + Arrays.toString(transformArray(arr4)));

        try {
            System.out.println(transformArray(null));
        } catch (Exception e) {
            System.out.println("Помилка: " + e.getMessage());
        }
    }
}
