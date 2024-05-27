import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class GenerateAllUniquePermutations {
    private static void swap(ArrayList<Integer> A, int s, int e){
        int temp = A.get(s);
        A.set(s, A.get(e));
        A.set(e, temp);
    }

//    private static void uniquePermutations(ArrayList<Integer> A, int n, int i, HashSet<ArrayList<Integer>> hs){
//        if (i == n){
//            hs.add(new ArrayList<>(A));
//        }
//        for (int j = i; j < n; j++) {
//            swap(A,i,j);
//            uniquePermutations(A,n,i+1,hs);
//            swap(A,i,j);
//        }
//    }

    static void allUniquePermutations(ArrayList<Integer> A, int n, int i, ArrayList<ArrayList<Integer>> ans) {
        if (i == n) {
            if (!ans.contains(A)){
                ans.add(new ArrayList<>(A));
            }
        }
        for (int j = i; j < n; j++) {
            swap(A, i, j);
            allUniquePermutations(A, n, i+1, ans);
            swap(A, i, j);
        }
    }

    public static ArrayList<ArrayList<Integer>> permute(ArrayList<Integer> A) {
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        allUniquePermutations(A, A.size(), 0, ans);
        return ans;
    }

    public static void main(String[] args) {
        ArrayList<Integer> A = new ArrayList<>();
        A.add(1);
        A.add(1);
        A.add(2);
        System.out.println(permute(A));
    }
}
