public class laba2 {
    public static void main(String[] args) {
        // ---------------- Задача 1 ----------------
        double a1 = -1.49;
        double b1 = 23.4;
        double c1 = 1.23;
        double d1 = 2.542;

        double numerator1 = 4 * Math.log(b1);
        double denominator1 = Math.pow(c1, d1);
        double expression1 = Math.sin(a1) - (numerator1 / denominator1);
        double y1 = Math.sqrt(Math.abs(expression1));

        System.out.println("Задача 1:");
        System.out.println("y = " + y1);

        // ---------------- Задача 2 ----------------
        double a2 = 0.478;
        double b2 = -1.26;
        double c2 = 2.68;
        double d2 = 18.24;

        double part1 = 9 * (Math.asin(a2) / Math.cos(Math.sqrt(Math.abs(b2))));
        double part2 = Math.pow(2.43, d2);
        double part3 = Math.log(c2);
        double y2 = part1 + part2 + part3;

        System.out.println("\nЗадача 2:");
        System.out.println("y = " + y2);


        // ---------------- Задача 3 ----------------
        
        double a3 = -2.54;
        double b3 = 1.23;
        double c3 = -2.14;
        double d3 = -0.23;

        System.out.println("\nЗадача 3:");
        if (b3 == 0.0) {
            System.out.println("  Помилка: b3 == 0 — ділення на нуль.");
        } else {
            double lnArg = Math.abs(a3 / b3);
            if (lnArg <= 0.0) {
                // ln|a/b|: аргумент > 0. (ln(0) не дозволено)
                System.out.println("  Помилка: аргумент ln(|a3/b3|) <= 0.");
            } else {
                double lnPart = Math.log(lnArg);                    // ln|a/b|
                double radicand = Math.cos(c3) + Math.exp(d3);     // cos(c) + e^d
                if (Double.isNaN(radicand)) {
                    System.out.println("  Помилка: підкореневий вираз дав NaN.");
                } else if (radicand < 0.0) {
                    System.out.println("  Помилка: підкореневий вираз від'ємний — sqrt(NaN).");
                } else {
                    double sqrtPart = Math.sqrt(radicand);
                    double y3 = 3.0 * (lnPart + sqrtPart);
                    System.out.printf("  y = %.6f%n", y3);
                }
            }
        }
    }
}