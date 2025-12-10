public class Task22 {

    // Метод для обчислення середнього арифметичного між максимальним і третім елементом масиву
    public static double averageOfMaxAndThird(int[] array) {
        if (array == null)
            throw new NullPointerException("Масив не може бути null");

        if (array.length < 3)
            throw new IllegalArgumentException("Масив повинен містити щонайменше 3 елементи");

        int max = array[0];
        for (int num : array) {  // цикл for-each
            if (num > max) max = num;
        }

        int third = array[2];  // індекс 2 — це третій елемент (рахуємо з нуля)
        return (max + third) / 2.0;
    }

    public static void main(String[] args) {
        int[] arr1 = {4, 7, 2, 9, 1};     // max = 9, третій = 2 → (9+2)/2 = 5.5
        int[] arr2 = {10, 20, 30, 40};    // max = 40, третій = 30 → (40+30)/2 = 35.0
        int[] arr3 = {-5, 0, -10, -1};    // max = 0, третій = -10 → (0 + (-10))/2 = -5.0

        System.out.println("Тест 1: " + averageOfMaxAndThird(arr1));
        System.out.println("Тест 2: " + averageOfMaxAndThird(arr2));
        System.out.println("Тест 3: " + averageOfMaxAndThird(arr3));

        // Тести на помилки
        try {
            int[] shortArray = {1, 2};
            System.out.println(averageOfMaxAndThird(shortArray));
        } catch (Exception e) {
            System.out.println("Помилка: " + e.getMessage());
        }

        try {
            System.out.println(averageOfMaxAndThird(null));
        } catch (Exception e) {
            System.out.println("Помилка: " + e.getMessage());
        }
    }
}


