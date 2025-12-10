package laba6;

public class Task7 {

    public static int countWords(String s) {
        if (s == null) {
            throw new NullPointerException("String is null");
        }

        s = s.trim();
        if (s.isEmpty()) {
            return 0;
        }

        // слова = послідовності a-z A-Z 0-9
        String[] parts = s.split("[^a-zA-Z0-9]+");
        return parts.length;
    }

    public static void main(String[] args) {

        // ✔ твої власні приклади
        printResult("Hello world 2025 is awesome");   // 4 слова
        printResult("Java123 is better_than C99");     // 4 слова
        printResult("User007 has 3cats and 2dogs");    // 6 слів

        //  приклад з умови (для контролю)
        printResult("The user with the nickname koala757677 this month left 3 times more comments than the user with the nickname croco181dile181920 4 months ago");

        //  тестування помилок
        try { printResult(null); }
        catch (Exception e) { System.out.println(e); }

        printResult("   "); // 0 слів
        printResult("");    // 0 слів
    }

    private static void printResult(String s) {
        int count = countWords(s);
        System.out.println("Input: \"" + s + "\"  ->  Words: " + count);
    }
}


