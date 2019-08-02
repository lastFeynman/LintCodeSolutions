package easy;

public class Solution6 {
    /**
     * @param A: sorted integer array A
     * @param B: sorted integer array B
     * @return: A new sorted integer array
     */
    public int[] mergeSortedArray(int[] A, int[] B) {
        // write your code here
        int[] C = new int[A.length+B.length];
        int i = 0,j = 0;
        while(i<A.length && j<B.length){
            if(A[i] <= B[j]){
                C[i+j] = A[i];
                i++;
            }else{
                C[i+j] = B[j];
                j++;
            }
        }
        if(i==A.length){
            for(;j<B.length;j++){
                C[i+j] = B[j];
            }
        }else {
            for(;i<A.length;i++){
                C[i+j] = A[i];
            }
        }
        return C;
    }

    public static void main(String[] args){
        Solution6 solution6 = new Solution6();
        int[] A = {1,2,3,4};
        int[] B = {2,4,5,6};
        int[] C = solution6.mergeSortedArray(A,B);
        for(int i=0;i<C.length;i++) {
            System.out.printf(C[i]+" ");
        }
    }
}
