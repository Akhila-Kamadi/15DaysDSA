import java.util.Arrays;

public class AggressiveCows {
    private static boolean checkMinDistance(int dist, int[] A, int n, int cows){
        int lastcow = A[0], c = 1;
        for (int i = 1; i < n; i++) {
            if(A[i] - lastcow >= dist) {
                lastcow = A[i];
                c++;
                if (c == cows) {
                    return true;
                }
            }
        }
        if(c==cows){
            return true;
        }
        return false;
    }
    private static int arrangeCows(int[] A, int l, int h, int B){
        int ans = l;
        while(l<=h){
            int mid = (l+h)/2;
            if(checkMinDistance(mid, A, A.length, B)){
                ans = mid;
                l = mid + 1;
            }
            else{
                h = mid - 1;
            }
        }
        return ans;
    }
    public static int solve(int[] A, int B) {
        int n = A.length;
        Arrays.sort(A);
        int l = Integer.MAX_VALUE, h = A[n-1]-A[0];
        for (int i = 1; i < n; i++) {
            int dist = A[i]-A[i-1];
            l = Math.min(l, dist);
        }
        int ans = arrangeCows(A,l,h,B);
        return ans;
    }

    public static void main(String[] args) {
        int[] A = {5,17,100,11};
        int B = 2;
        System.out.println(solve(A,B));
    }
}
