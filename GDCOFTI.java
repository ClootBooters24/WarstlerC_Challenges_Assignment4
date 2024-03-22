import java.util.*;

public class GDCOFTI {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        long num1 = scanner.nextLong();
        long num2 = scanner.nextLong();
        long num3 = scanner.nextLong();
    
        long result = gcd(gcd(num1, num2), num3);
        System.out.println(result);

        scanner.close();
    }

    public static long gcd(long a, long b) {
        if (b == 0) {
            return a;
        } else {
            return gcd(b, a % b);
        }
    }
}