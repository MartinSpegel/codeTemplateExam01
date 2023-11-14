package Kontrollstrukturen;

public class KS {

    public static void main(String ... args) {






    }


    public static int anzahlZiffern(int n) {
        int result = 1;
        n = n > 0 ? n : -n;
        while (n / 10 >= 1) {
            result++;
            n /= 10;
        }
        return result;
    }

    public static int reverseZahl(int n) {
        boolean isNegativ = n >= 0 ? false : true;
        n = isNegativ ? -n : n;
        int result = 0;
        while (n / 10 >= 1) {
            result = result * 10 +  (n % 10);
            n /= 10;
        }
        result = n % 10 != 0 ? result * 10 + n % 10 : 0;
        if (isNegativ) return -result;
        return result;
    }

    public static boolean palindromeZahl(int n) {
        return n == reverseZahl(n);
    }

    public static String reverseString(String s) {
        if (s == null || s.isEmpty()) return "";
        StringBuilder out = new StringBuilder();
        for (int i = s.length() - 1; i >= 0; i--) {
            out.append(s.charAt(i));
        }
        return out.toString();
    }

    public static boolean palindromeString(String s) {
        return s.equals(reverseString(s));
    }

    public static int ziffernRichtigeReihenfolge(int n) {
        int length = anzahlZiffern(n);
        int[] helper = new int[length];
        for (int i = 0; i < length; i++) {
            helper[i] = n % 10;
            n /= 10;
        }
        sortArray(helper);
        int out = 0;
        for (int i : helper) {
            out = 10 * out + i;
        }
        return out;
    }

    public static void sortArray(int[] in) {
        for (int i = 0; i < in.length - 1; i++) {
            for (int j = i + 1; j < in.length; j++) {
                if (in[i] > in[j]) {
                    int temp = in[i];
                    in[i] = in[j];
                    in[j] = temp;
                }
            }
        }
    }

    public static void primzahlen(int n) {
        int temp;
        while (n != 0) {
            temp = n % 10;
            if (isPrimzahl(temp)) {
                System.out.println(n);
            }
            n /= 10;
        }
    }

    public static boolean isPrimzahl(int n) {
        if (n < 2) return false;
        if (n == 2) return true;
        for (int i = 2; i < n; i++) {
            if (n % i == 0) return false;
        }
        return true;
    }

    public static int nächstePrimzahl(int n) {
        if (isPrimzahl(n)) return n;
        int counter = 1;
        boolean found = false;
        while (true) {
            if (isPrimzahl( n - counter)) return n -counter;
            if (isPrimzahl(n + counter)) return n + counter;
            counter++;
        }
    }



}
