public class CyclicPermutations {
    private static int[] findLps(String C){
        int n = C.length();
        int[] lps = new int[n];
        lps[0] = 0;
        for(int i = 1; i < n; i++){
            int x = lps[i-1];
            while(C.charAt(i) != C.charAt(x)){
                if(x == 0) {
                    x = -1;
                    break;
                }
                x = lps[x-1];
            }
            lps[i] = x+1;
        }
        return lps;
    }
    private static int kmpAlgo(String A, String B){
        int[] lps = findLps(A+"@"+B+B);
        int c = 0;
        int len = A.length() + 2 * B.length() + 1;
        for(int i = 0; i < len; i++){
            if(lps[i] == A.length()){
                c++;
            }
        }
        if(A.equals(B)){
            return c-1;
        }
        return c;
    }
    public static int solve(String A, String B) {
        return kmpAlgo(A,B);
    }

    public static void main(String[] args) {
        String A = "1101111111", B = "1101111111";
        System.out.println(solve(A,B));
    }
}
