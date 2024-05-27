import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class LongestConsecutiveSequence {
    public static int longestConsecutive(final List<Integer> A) {
        HashMap<Integer, Integer> mp = new HashMap<>();
        int maxCount = 0;
        for (int ele : A) {
            if (!mp.containsKey(ele)) {
                int lCount = 0;
                int rCount = 0;
                // lCount stores longest consecutive element till the current element - 1
                if (mp.containsKey(ele - 1)) {
                    lCount = mp.get(ele - 1);
                }
                // rCount stores longest consecutive element from the current element + 1
                if (mp.containsKey(ele + 1)) {
                    rCount = mp.get(ele + 1);
                }
                mp.put(ele, lCount + 1 + rCount);

                mp.put(ele - lCount, mp.get(ele));
                mp.put(ele + rCount, mp.get(ele));

                maxCount = Math.max(maxCount, lCount + rCount + 1);
            }
        }
        return maxCount;
    }

    public static void main(String[] args) {
        List<Integer> A = Arrays.asList(100, 4, 200, 1, 3, 2);
        System.out.println(longestConsecutive(A));
    }
}
