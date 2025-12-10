/**
 * Завдання 15:
 * Обчислити нескінченну суму:
 * S = sum_{i=1..∞} (-1)^(i+1) / (i * (i+1) * (i+2))
 *
 * Правило зупинки:
 *   - Якщо |черговий доданок| < ε, то цей і всі наступні доданки
 *     більше не враховуються у сумі.
 *
 * Обмеження:
 *   - ε > 0
 *   - ε має бути скінченним числом
 */
public class Task15 {

    public static void main(String[] args) {
        // Допустимі приклади
        printResults(0.1);
        printResults(1e-3);
        printResults(1e-6);

        // Дуже мала точність
        printResults(1e-9);
        printResults(1e-12);

        // Недопустимі приклади
        printResults(-1e-3);   // ε < 0
        printResults(0.0);     // ε = 0
    }

    /**
     * Обчислення нескінченної суми
     *
     * @param eps точність (ε > 0)
     * @return значення часткової суми
     * @throws IllegalArgumentException якщо eps ≤ 0 або некоректне
     */
    public static double computeInfiniteSum(double eps) {
        if (!(eps > 0.0) || Double.isNaN(eps) || Double.isInfinite(eps)) {
            throw new IllegalArgumentException("ε має бути > 0 і скінченним. eps = " + eps);
        }

        double sum = 0.0;
        for (long i = 1; ; i++) {
            double denom = (double) i * (i + 1) * (i + 2);
            double sign = (i % 2 == 1) ? 1.0 : -1.0; // (-1)^(i+1)
            double term = sign / denom;

            // правило зупинки
            if (Math.abs(term) < eps) {
                break;
            }

            sum += term;

            // захист від "зациклення"
            if (i > 50_000_000L) {
                throw new IllegalArgumentException("ε надто мале, перевищено ліміт ітерацій (i=" + i + ")");
            }
        }
        return sum;
    }
// Допоміжний метод для виводу результатів
    static void printResults(double eps) {
        System.out.print("eps:" + eps + " результат: ");
        try {
            System.out.println(computeInfiniteSum(eps));
        } catch (IllegalArgumentException e) {
            System.out.println("ПОМИЛКА! " + e.getMessage());
        }
    }
    
}