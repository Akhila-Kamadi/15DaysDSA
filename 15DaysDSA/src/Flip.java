public class Flip {
    public static int[] flip(String A) {
        int n = A.length();
        int[] arr = new int[n];
        for (int i = 0; i < A.length(); i++) {
            if(A.charAt(i) == '0'){
                arr[i] = 1;
            }
            else {
                arr[i] = -1;
            }
        }
        int sum = 0, maxSum = 0, start = -1, end = -1, temp = 0;
        for (int i = 0; i < n; i++) {
            sum = sum + arr[i];
            if(sum > maxSum){
                maxSum = sum;
                end = i;
                start = temp;
            }
            if (sum < 0){
                sum = 0;
                temp = i+1;
            }
        }
        if (start != -1 && end != -1){
            return new int[]{start+1,end+1};
        }
        return new int[]{};
    }

    public static void main(String[] args) {
        String A = "010";
        int[] ans = flip(A);
        for (int i : ans) {
            System.out.print(i+" ");
        }
    }
}
