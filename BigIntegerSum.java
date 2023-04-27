import java.math.BigInteger;

public class BigIntegerSum {
    public static void main(String[] args) {
        String a = "123456789012345678901234567890123456789012345678901234567890";
        String b = "12345678901234567890123456789012345678901234567890";

        String a1 = a.length() >= b.length() ? a : "0".repeat(b.length() - a.length()) + a;
        String b1 = b.length() >= a.length() ? b : "0".repeat(a.length() - b.length()) + b;

        StringBuilder res = new StringBuilder();
        int prevDigit = 0;
        for (int i = a1.length() - 1; i >= 0; i--) {
            int digit1 = Integer.parseInt(String.valueOf(a1.charAt(i)));
            int digit2 = Integer.parseInt(String.valueOf(b1.charAt(i)));
            int sum = digit1 + digit2 + prevDigit;
            if (sum > 9) {
                prevDigit = 1;
                sum = sum % 10;
            } else {
                prevDigit = 0;
            }
            res.insert(0, sum);
        }
        if (prevDigit != 0) {
            res.insert(0, prevDigit);
        }

        System.out.println(res.toString());
        System.out.println(new BigInteger(a).add(new BigInteger(b))); // For comparison
    }
}
