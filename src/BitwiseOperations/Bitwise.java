package BitwiseOperations;

public class Bitwise {

    public static void main(String... args) {
        System.out.println(multiplyingByTwoToPowerOfN(3, 3));
    }

    public static boolean powerOfTwo(int n) {
        return n % (n - 1) == 0;
    }

    public static int multiplyingByTwoToPowerOfN(int multiplicant, int exponent) {
        return multiplicant<<exponent;
        // = multiplicant * 2^exponent
    }

    public static int divideByPowerOfTwo(int toBeDivided, int exponent) {
        return toBeDivided >> exponent; // Result:  (toBeDivided / 2^exponent)
    }

    public static boolean isEven(int n) {
        return (n & 1) == 0;
    }

    public static int countSetBits(int num) {
        int count = 0;
        while (num != 0) {
            count += num & 1;
            num >>>= 1;
        }
        return count;
    }

    public static boolean isPowerOfTwo(int num) {
        return (num > 0) && ((num & (num - 1)) == 0);
    }

    public static int hexToDec(String hexString) {
        // Parse the hexadecimal string and convert it to decimal
        return Integer.parseInt(hexString, 16);
    }

    public static int binToDec(String binString) {
        // Parse the binary string and convert it to decimal
        return Integer.parseInt(binString, 2);
    }
}
