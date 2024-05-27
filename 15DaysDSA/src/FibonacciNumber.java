import java.util.Scanner;

public class FibonacciNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int A = sc.nextInt();
        if (A <= 1) {
            System.out.println(A);
        } else {
            int x = 0, y = 1, z = 0;
            for (int i = 2; i <= A; i++) {
                z = x + y;
                x = y;
                y = z;
            }
            System.out.println(z);
        }

    }
}
