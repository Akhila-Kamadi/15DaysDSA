import java.util.Arrays;

public class DungeonPrincess {
    private static int minHP(int[][] A, int i, int j, int n, int m, int[][] dp) {
        if (i >= n || j >= m){
            return Integer.MAX_VALUE;
        }
        if (i == n-1 && j == n-1){
            return Math.max(1, 1 - A[i][j]);
        }
        if(dp[i][j] == -1){
            int a = minHP(A,i+1,j,n,m,dp);
            int b = minHP(A,i,j+1,n,m,dp);
            dp[i][j] = Math.max(1, Math.min(a,b)-A[i][j]);
        }
        return dp[i][j];
    }

    public static int calculateMinimumHP(int[][] A) {
        int n = A.length, m = A[0].length;
        int[][] dp = new int[n][m];
        for (int[] arr : dp) {
            Arrays.fill(arr, -1);
        }
        return minHP(A,0,0,n,m,dp);
    }

    public static void main(String[] args) {
        int[][] A = {{1, -1, 0},{-1, 1, -1},{1, 0, -1}};
        System.out.println(calculateMinimumHP(A));
    }
}
