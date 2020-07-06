package medium;


import java.util.Random;

public class Solution5 {
    public int kthLargestElement(int n, int[] nums) {
        int p=0, r=nums.length-1;
        while(true){
            if(p == r){
                return nums[p];
            }
            int q = partition(nums, p, r);
            int k = q - p + 1;
            if(k == n){
                return nums[q];
            }else if(k > n){
                r = q - 1;
            }else{
                p = q + 1;
                n = n - k;
            }
        }
    }

    public int partition(int[] A, int p, int r){
        int x = A[r];
        int i = p-1;
        for(int j=p;j<r;j++){
            if(A[j]>=x){
                i++;
                int t = A[i];
                A[i] = A[j];
                A[j] = t;
            }
        }
        int t = A[i+1];
        A[i+1] = A[r];
        A[r] = t;
        return i+1;
    }
    public int randomPartition(int[] A, int p, int r){
        Random random = new Random();
        int i = random.nextInt(r-p+1)+p;
        int t = A[r];
        A[r] = A[i];
        A[i] = t;
        return partition(A, p, r);
    }
}
