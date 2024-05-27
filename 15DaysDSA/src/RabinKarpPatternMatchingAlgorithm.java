public class RabinKarpPatternMatchingAlgorithm {
    static int search(String T, String W) {
        int n = T.length(), k = W.length();
        int mod = 1000000009, c = 0, prime = 23;
        int p = 1, ft = 0, fw = 0;
        //, ft = T.charAt(0), fw = W.charAt(0)
        for (int i = 0; i < k; i++) {
            //fw = fw + w[i]*(p^i); ft = ft + T[i]*(p^i);
            int curWChar = W.charAt(i), curTChar = T.charAt(i);
            int curWValue = (int) (((long) curWChar * p) % mod);
            int curTValue = (int) (((long) curTChar * p) % mod);
            fw = (int) (((long) fw + curWValue) % mod);
            ft = (int) (((long) ft + curTValue) % mod);
            p = (int) (((long) p * prime) % mod);
        }
        if (ft == fw) {
            c++;
        }
        int s = 1, e = k, stp = 1, ep = p;
        while (e < n) {
            int prevSChar = T.charAt(s - 1), curEChar = T.charAt(e);
            int prevSValue = (int) (((long) prevSChar * stp) % mod);
            int curEValue = (int) (((long) curEChar * ep) % mod);

            ft = (int) (((long) ft - prevSValue + mod) % mod);
            ft = (int) (((long) ft + curEValue) % mod);

            fw = (int) (((long) fw * prime) % mod);

            if (ft == fw) {
                c++;
            }

            stp = (int) (((long) stp * prime)%mod);
            ep = (int) (((long) ep * prime) % mod);

            s++;
            e++;
        }
        return c;
    }

    public static void main(String[] args) {
        String T = "abcbagddabagdbagd";
        String W = "bagd";
        System.out.println(search(T, W));
    }
}
