public class Task11 {

    // Метод, що знаходить суму найбільшого та найменшого елементів масиву
    public static int sumOfMinAndMax(int[] array) {
        if (array == null) {
            throw new NullPointerException("Масив не може бути null");
        }
        if (array.length == 0) {
            throw new IllegalArgumentException("Масив не може бути порожнім");
        }

        int min = array[0];
        int max = array[0];

        for (int i = 1; i < array.length; i++) {
            if (array[i] < min) min = array[i];
            if (array[i] > max) max = array[i];
        }

        return min + max;
    }

    // Метод main для тестування
    public static void main(String[] args) {
        int[] arr1 = {5, -2, 8, 0, 4};
        int[] arr2 = {10, 10, 10};
        int[] arr3 = {-5, -1, -9, 0, 3};

        System.out.println("Тест 1: " + sumOfMinAndMax(arr1)); // очікується 8 + (-2) = 6
        System.out.println("Тест 2: " + sumOfMinAndMax(arr2)); // 10 + 10 = 20
        System.out.println("Тест 3: " + sumOfMinAndMax(arr3)); // -9 + 3 = -6

        try {
            int[] empty = {};
            System.out.println(sumOfMinAndMax(empty));
        } catch (Exception e) {
            System.out.println("Помилка: " + e.getMessage());
        }

        try {
            System.out.println(sumOfMinAndMax(null));
        } catch (Exception e) {
            System.out.println("Помилка: " + e.getMessage());
        }
    }
}