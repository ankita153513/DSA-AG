
import java.util.*;

public class CyclicSubst {

    public static int maxCyclicSum(String s) {
        int n = s.length();
        String t = s + s; // handle cyclic

        Set<Character> set = new HashSet<>();
        int left = 0, sum = 0, maxSum = 0;

        for (int right = 0; right < t.length(); right++) {
            char ch = t.charAt(right);

            while (set.contains(ch) || (right - left + 1) > n) {
                char leftChar = t.charAt(left);
                set.remove(leftChar);
                sum -= (leftChar - 'a' + 1);
                left++;
            }

            set.add(ch);
            sum += (ch - 'a' + 1);

            maxSum = Math.max(maxSum, sum);
        }

        return maxSum;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter string: ");
        String s = sc.nextLine();

        int result = maxCyclicSum(s);
        System.out.println("Maximum Sum: " + result);

        sc.close();
    }
}