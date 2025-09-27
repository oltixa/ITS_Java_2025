/**
 * Завдання 1:
 * Обчислити суму ряду:
 * S = sum_{i=1..k} sqrt( m * (1.0 / i) ) * sin(m * i)
 *
 * Обмеження:
 *   - k ≤ 30 (мінімально доцільне значення k = 1)
 *   - m ≥ 0
 *   - m має бути скінченним числом
 *
 * Метод обчислення не повинен взаємодіяти з користувачем через консоль.
 */
public class Task1 {

    public static void main(String[] args) {
        // Допустимі приклади
        printResults(1.0, 5);
        printResults(2.0, 10);
        printResults(0.5, 3);

        // Граничний випадок
        printResults(1.0, 30);

        // Недопустимі приклади
        printResults(1.0, 31);      // k > 30
        printResults(-1.0, 10);     // m < 0
        printResults(Double.NaN, 5); 
        printResults(Double.POSITIVE_INFINITY, 5);
    }

    /**
     * Обчислення суми:
     *   S = sum_{i=1..k} sqrt(m * (1.0/i)) * sin(m*i)
     *
     * @param m параметр m (має бути >= 0 та скінченним числом)
     * @param k верхня межа (1 ≤ k ≤ 30)
     * @return значення суми
     * @throws IllegalArgumentException якщо k > 30 або m некоректне
     */
    public static double computeFiniteSum(double m, int k) {
        if (k < 1 || k > 30) {
            throw new IllegalArgumentException("k має бути в межах 1..30. k = " + k);
        }
        if (Double.isNaN(m) || Double.isInfinite(m)) {
            throw new IllegalArgumentException("m має бути скінченним числом. m = " + m);
        }
        if (m < 0.0) {
            throw new IllegalArgumentException("m має бути невід’ємним. m = " + m);
        }

        double sum = 0.0;
        for (int i = 1; i <= k; i++) {
            double underRoot = m * (1.0 / i); // вираз під коренем
            if (underRoot < 0.0) {
                throw new IllegalArgumentException("Від’ємне значення під коренем для i=" + i);
            }
            double term = Math.sqrt(underRoot) * Math.sin(m * (double) i);
            sum += term;
        }
        return sum;
    }

    // Допоміжний метод для виводу результатів
    static void printResults(double m, int k) {
        System.out.print("m:" + m + " k:" + k + " результат: ");
        try {
            System.out.println(computeFiniteSum(m, k));
        } catch (IllegalArgumentException e) {
            System.out.println("ПОМИЛКА! " + e.getMessage());
        }
    }
}