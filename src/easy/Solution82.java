package easy;

public class Solution82 {
    public int singleNumber(int[] A) {
        for(int i=0;i<A.length;i++){
            int j = 0;
            for(;j<A.length;j++){
                if(j != i && A[i] == A[j])
                    break;
            }
            if(j == A.length){
                return A[i];
            }
        }
        return 0;
    }

    public static void main(String[] args){
        int[] A = {1,1,2,2,3,4,4};
        Solution82 solution82 = new Solution82();
        System.out.println(solution82.singleNumber(A));
    }
}
