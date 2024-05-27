import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

public class NQueens {

    private static ArrayList<String> getStringList(char[][] mat){
        ArrayList<String> list = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat.length; j++) {
                sb.append(mat[i][j]);
            }
            list.add(sb.toString());
            sb = new StringBuilder();
        }
        return list;
    }
    private static void placeNQueens(ArrayList<ArrayList<String>> ans, char[][] mat, int n, int i, HashSet<Integer> colSet,
                              HashSet<Integer> leftDSet, HashSet<Integer> rightDSet){
        if(i == n){
            ans.add(getStringList(mat));
        }
        for (int j = 0; j < n; j++) {
            if (colSet.contains(j) || leftDSet.contains(i-j) || rightDSet.contains(i+j)){
                continue;
            }

            colSet.add(j);
            leftDSet.add(i-j);
            rightDSet.add(i+j);
            mat[i][j] = 'Q';

            placeNQueens(ans,mat,n,i+1,colSet,leftDSet,rightDSet);

            colSet.remove(j);
            leftDSet.remove(i-j);
            rightDSet.remove(i+j);
            mat[i][j] = '.';
        }
    }
    public static ArrayList<ArrayList<String>> solveNQueens(int A) {
        char[][] mat = new char[A][A];
        for (char[] i : mat) {
            Arrays.fill(i, '.');
        }
        ArrayList<ArrayList<String>> ans = new ArrayList<>();
        placeNQueens(ans, mat, A, 0, new HashSet<>(), new HashSet<>(), new HashSet<>());
        return ans;
    }

    public static void main(String[] args) {
        int A = 4;
        System.out.println(solveNQueens(A));
        /*
        Output format:

        [
         [".Q..",  // Solution 1
          "...Q",
          "Q...",
          "..Q."],

         ["..Q.",  // Solution 2
          "Q...",
          "...Q",
          ".Q.."]
        ]
         */
    }
}
