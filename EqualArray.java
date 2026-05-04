import java.util.*;

public class EqualArray {

    public static int minOperations(int[] A, int K) {
        int n = A.length;

        // Step 1: Check feasibility
        int remainder = A[0] % K;
        for (int i = 1; i < n; i++) {
            if (A[i] % K != remainder) {
                return -1;
            }
        }

        // Step 2: Convert to B array
        int[] B = new int[n];
        for (int i = 0; i < n; i++) {
            B[i] = A[i] / K;
        }

        // Step 3: Sort
        Arrays.sort(B);

        // Step 4: Choose median
        int median = B[n / 2];

        // Step 5: Count operations
        int operations = 0;
        for (int i = 0; i < n; i++) {
            operations += Math.abs(B[i] - median);
        }

        return operations;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] A = new int[n];

        for (int i = 0; i < n; i++) {
            A[i] = sc.nextInt();
        }

        int K = sc.nextInt();5

        int result = minOperations(A, K);
        System.out.println(result);

        sc.close();
    }
}