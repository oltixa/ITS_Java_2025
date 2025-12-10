package laba6;

public class Task5 {

    public static int binaryStringToInt(String s) {
        if (s == null) {
            throw new NullPointerException("String is null");
        }
        if (s.isEmpty()) {
            throw new IllegalArgumentException("String is empty");
        }

        for (char c : s.toCharArray()) {
            if (c != '0' && c != '1') {
                throw new IllegalArgumentException("Not a binary string");
            }
        }

        int result = 0;
        for (char c : s.toCharArray()) {
            result = result * 2 + (c - '0');
        }
        return result;
    }

    public static void main(String[] args) {

        printResult("1010111");
        printResult("1011");

        // помилки
        try { printResult("10A01"); }
        catch (Exception e) { System.out.println(e); }

        try { printResult(""); }
        catch (Exception e) { System.out.println(e); }

        try { printResult(null); }
        catch (Exception e) { System.out.println(e); }
    }

    private static void printResult(String s) {
        int value = binaryStringToInt(s);
        System.out.println("Binary: " + s + "  ->  Decimal: " + value);
    }
}
