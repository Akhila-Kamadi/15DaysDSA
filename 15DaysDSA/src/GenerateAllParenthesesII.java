import java.util.ArrayList;

public class GenerateAllParenthesesII {

//    static void generate(int A, int openCount, int closeCount, String s, ArrayList<String> ans) {
//        if (s.length() == 2 * A) {
//            ans.add(s);
//            return;
//        }
//        if (openCount < A) {
//            generate(A, openCount + 1, closeCount, s+"(", ans);
//        }
//        if (closeCount < openCount) {
//            generate(A, openCount, closeCount + 1, s+")", ans);
//        }
//    }

    static void generate(int A, int openCount, int closeCount, StringBuilder s, ArrayList<String> ans) {
        if (s.length() == 2 * A) {
            ans.add(s.toString());
            return;
        }
        if (openCount < A) {
            s.append("(");
            generate(A, openCount + 1, closeCount, s, ans);
            s.deleteCharAt(s.length()-1);
        }
        if (closeCount < openCount) {
            s.append(")");
            generate(A, openCount, closeCount + 1, s, ans);
            s.deleteCharAt(s.length()-1);
        }
    }

    public static ArrayList<String> generateParenthesis(int A) {
        ArrayList<String> ans = new ArrayList<>();
//        generate(A, 0, 0, "", ans);
        generate(A, 0, 0, new StringBuilder(), ans);
        return ans;
    }

    public static void main(String[] args) {
        int A = 2;
        System.out.println(generateParenthesis(A));
    }
}
