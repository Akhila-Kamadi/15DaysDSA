import java.util.HashMap;

public class DistinctNumbersInWindow {
    public static int[] dNums(int[] A, int B) {
        int n = A.length;
        int[] ans = new int[n-B+1];
        HashMap<Integer, Integer> hm = new HashMap<>();
        for(int i = 0; i < B; i++){
            if (!hm.containsKey(A[i])) {
                hm.put(A[i],1);
            }
            else{
                hm.put(A[i], hm.get(A[i])+1);
            }
        }
        ans[0] = hm.size();
        int s = 1, e = B;
        int x = 1;
        while(e<n){
            hm.put(A[s-1], hm.get(A[s-1])-1);
            if(hm.get(A[s-1]).equals(0)){
                hm.remove(A[s-1]);
            }
            hm.put(A[e], hm.getOrDefault(A[e], 0)+1);
            ans[x++] = hm.size();
            s++;
            e++;
        }
        return ans;
    }
    public static void main(String[] args) {
        int[] A = {1, 2, 1, 3, 4, 3};
        int B = 3;
        int[] ans = dNums(A,B);
        for (int ele: ans) {
            System.out.print(ele+" ");
        }
    }
}
