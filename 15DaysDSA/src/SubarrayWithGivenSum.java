import java.util.ArrayList;

public class SubarrayWithGivenSum {
    public static ArrayList<Integer> solve(ArrayList<Integer> A, int B) {
        ArrayList<Integer> ans = new ArrayList<>();
        int n = A.size();
        int s = 0, start = -1, end = -1;
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum = sum + A.get(i);
            while(sum > B && s < i){
                sum = sum - A.get(s);
                s++;
            }
            if(sum == B){
                start = s;
                end = i;
                break;
            }
        }
        if(start == -1 && end == -1){
            ans.add(-1);
        }
        else{
            for (int i = start; i <= end ; i++) {
                ans.add(A.get(i));
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        ArrayList<Integer> A = new ArrayList<>();
        A.add(2);
        A.add(6);
        A.add(5);
        A.add(31);
        A.add(11);
        A.add(8);
        System.out.println(solve(A,53));
    }
}
