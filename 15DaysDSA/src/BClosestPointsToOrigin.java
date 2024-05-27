import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class BClosestPointsToOrigin {

    static class SortingComparator implements Comparator<int[]>{

        @Override
        public int compare(int[] o1, int[] o2) {
            double dist1 = getEuclideanDistance(o1);
            double dist2 = getEuclideanDistance(o2);
            if (dist1 <= dist2){
                return -1;
            }
            return 1;
        }
        private double getEuclideanDistance(int[] a){
            return Math.sqrt(a[0]*a[0]+a[1]*a[1]);
        }
    }
    public static int[][] solve(int[][] A, int B) {
        int[][] ans = new int[B][2];
        int n = A.length;
        int minDistance = -1, x = 0;
        Arrays.sort(A, new SortingComparator());
        while(x<B){
            ans[x] = A[x];
            x++;
        }
        return ans;
    }

    public static void main(String[] args) {
        int[][] A = {{26,41},{40,47},{47,7},{50,34},{18,28}};
        int B = 4;
        int[][] ans = solve(A,B);
        for (int i = 0; i < ans.length; i++) {
            System.out.print("["+ ans[i][0]+" "+ans[i][1]+"] ");
        }
    }
}

