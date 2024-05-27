import java.util.ArrayList;

public class GenerateAllPermutations {

    static void swap(ArrayList<Integer> A, int s, int e) {
        int temp = A.get(s);
        A.set(s, A.get(e));
        A.set(e, temp);
    }

    static void allPermutations(ArrayList<Integer> A, int n, int i, ArrayList<ArrayList<Integer>> ans) {
        if (i == n) {
            ans.add(new ArrayList<>(A));
        }
        for (int j = i; j < n; j++) {
            swap(A, i, j);
            allPermutations(A, n, i+1, ans);
            swap(A, i, j);
        }
    }

    public static ArrayList<ArrayList<Integer>> permute(ArrayList<Integer> A) {
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        allPermutations(A, A.size(), 0, ans);
        return ans;
    }

    public static void main(String[] args) {
        ArrayList<Integer> A = new ArrayList<>();
        A.add(1);
        A.add(2);
        A.add(3);
        System.out.println(permute(A));
    }
}
