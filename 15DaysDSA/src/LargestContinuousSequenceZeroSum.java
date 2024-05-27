import java.util.HashMap;

public class LargestContinuousSequenceZeroSum {
    public static int[] lszero(int[] A) {
        int n = A.length;
        HashMap<Long,Integer> hm = new HashMap<>();
        long[] pf = new long[n];
        pf[0] = A[0];
        for(int i = 1; i < n; i++){
            pf[i] = pf[i-1] + A[i];
        }
        int len = Integer.MIN_VALUE, start = -1, end = -1;
        for(int i = 0; i < n; i++){
            if(pf[i] == 0){
                if(i+1 > len){
                    len = Math.max(len, i+1);
                    start = 0;
                    end = i;
                }
            }
            if(hm.containsKey(pf[i])){
                if(i-hm.get(pf[i]) > len){
                    len = Math.max(len, i-hm.get(pf[i]));
                    start = hm.get(pf[i])+1;
                    end = i;
                }
            }
            else{
                hm.put(pf[i], i);
            }
        }
        if(len == Integer.MIN_VALUE){
            return new int[0];
        }
        int[] ans = new int[len];
        int l = 0;
        for(int i = start;  i <= end; i++){
            ans[l++] = A[i];
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] A = {-19,8,2,-8,19,5,-2,-23};
        int[] ans = lszero(A);
        for (int a: ans) {
            System.out.print(a+" ");
        }
    }
}
