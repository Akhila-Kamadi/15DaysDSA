public class PaintersPartitionProblem {
    private static boolean isMinTime(int time,int[] A,int n, int k){
        int sum = 0, c = 0;
        for(int i = 0; i < n; i++){
            sum += A[i];
            if(sum > time){
                c++;
                sum = A[i];
            }
        }
        if(sum != 0){
            c++;
        }
        return (c<=k);
    }
    private static int minTimeToPaint(int l, int h, int[] A,int k){
        int ans = h;
        while(l<=h){
            int mid = (l+h)/2;
            if(isMinTime(mid,A,A.length,k)){
                ans = mid;
                h = mid - 1;
            }
            else{
                l = mid + 1;
            }
        }
        return ans;
    }
    public static int paint(int A, int B, int[] C) {
        int n = C.length;
        int l = Integer.MIN_VALUE, h = 0;
        for(int i = 0; i < n; i++){
            l = Math.max(l,C[i]);
            h = h + C[i];
        }
        int ans = minTimeToPaint(l, h, C, A);
        int mod = 10000003;
        ans = (int)(((long)ans * B)%mod);
        return ans;
    }
    public static void main(String[] args) {
        int A = 1, B = 1000000;
        int[] C = {1000000,1000000};
        System.out.println(paint(A,B,C));
    }
}
