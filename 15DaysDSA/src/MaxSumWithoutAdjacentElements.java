import java.util.Arrays;

public class MaxSumWithoutAdjacentElements {

    private static int maxSum(int[] arr, int i, int[] dp) {
        if (i < 0){
            return 0;
        }
        if(dp[i] == -1){
            dp[i] = Math.max(maxSum(arr, i-1,dp), maxSum(arr,i-2,dp)+arr[i]);
        }
        return dp[i];
    }

    public static int adjacent(int[][] A) {
        int n = A[0].length;
        int[] arr = new int[n];
        for (int j = 0; j < n; j++) {
            int first = A[0][j], second = A[1][j];
            arr[j] = Math.max(first, second);
        }
        int[] dp = new int[n];
        Arrays.fill(dp, -1);
        return maxSum(arr, n - 1, dp);
    }

    public static void main(String[] args) {
        int[][] A = {{1,2,3,4},{2,3,4,5}};
        System.out.println(adjacent(A));
    }
}
