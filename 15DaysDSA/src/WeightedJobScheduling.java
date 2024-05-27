import java.util.Arrays;
import java.util.Comparator;

public class WeightedJobScheduling {
    static class Job {
        int start, end, profit;

        Job(int start, int end, int profit) {
            this.start = start;
            this.end = end;
            this.profit = profit;
        }
    }

    static class EndTimeComparator implements Comparator<Job> {

        @Override
        public int compare(Job o1, Job o2) {
            if (o1.end < o2.end) {
                return -1;
            }
            if (o1.end > o2.end) {
                return 1;
            }
            return o1.start - o2.start;
        }
    }

    static int binarySearch(Job[] jobs, int i) {
        int l = 0, h = i - 1, ans = -1;
        while (l <= h) {
            int mid = (l + h) / 2;
            if (jobs[mid].end <= jobs[i].start) {
                ans = mid;
                l = mid + 1;
            } else {
                h = mid - 1;
            }
        }
        return ans;
    }

    public static int solve(int[][] A) {
        int n = A.length;
        Job[] jobs = new Job[n];
        for (int i = 0; i < n; i++) {
            jobs[i] = new Job(A[i][0], A[i][1], A[i][2]);
        }
        Arrays.sort(jobs, new EndTimeComparator());
        int[] dp = new int[n];
        dp[0] = jobs[0].profit;
        for (int i = 1; i < n; i++) {
            int currentProfit = jobs[i].profit;
            int prevProfit = dp[i - 1];

            int idx = binarySearch(jobs, i);
            if (idx != -1) {
                currentProfit += dp[idx];
            }

            dp[i] = Math.max(prevProfit, currentProfit);
        }
        return dp[n - 1];
    }

    public static void main(String[] args) {
        int[][] A = {{3, 6, 3},
                {6, 7, 8},
                {3, 7, 7},
                {3, 10, 9},
                {7, 8, 7},
                {6, 6, 3},
                {1, 5, 7},
                {2, 5, 1},
                {5, 7, 8}};
        System.out.println(solve(A));
    }
}
