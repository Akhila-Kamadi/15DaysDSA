import java.util.Arrays;

public class MergeSort {

    public static void merge(int[] A, int s, int m , int e){
        int[] dummy = new int[e-s+1];
        int p1 = s, p2 = m+1, i = 0;
        while(p1<=m && p2<=e){
            if(A[p1]<=A[p2]){
                dummy[i++] = A[p1++];
            }
            else{
                dummy[i++] = A[p2++];
            }
        }
        while (p1<=m){
            dummy[i++] = A[p1++];
        }
        while (p2<=e){
            dummy[i++] = A[p2++];
        }
        i = 0;
        for(int j = s; j <= e; j++){
            A[j] = dummy[i++];
        }
    }
    static void mergeSort(int[] A, int s, int e){
        if(s==e){
            return;
        }
        int m = (e+s)/2;
        mergeSort(A,s,m);
        mergeSort(A,m+1,e);
        merge(A,s,m,e);
    }
    public static int[] solve(int[] A) {
        mergeSort(A,0,A.length-1);
        return A;
    }

    public static void main(String[] args) {
        int[] A = {1,4,10,2,1,5};
        int[] ans = solve(A);
        for (int ele : ans) {
            System.out.print(ele+" ");
        }
    }
}
