package medium;

public class Solution31 {
    public int partitionArray(int[] nums, int k) {
        if(nums.length == 0){
            return 0;
        }
        int i = 0, minBigger = Integer.MAX_VALUE, minIndex = nums.length;
        for(;i<nums.length;i++){
            if(nums[i] == k){
                break;
            } else if(nums[i] > k && nums[i] < minBigger){
                minIndex = i;
                minBigger = nums[i];
            }
        }
        if(i == nums.length && minIndex == nums.length){
            return nums.length;
        } else if(i < nums.length){
            swap(nums, i, nums.length-1);
        }else{
            swap(nums, minIndex, nums.length-1);
        }
        return partition(nums, 0, nums.length-1);
    }

    public int partition(int[] A, int p, int r){
        int x = A[r];
        int i = p-1;
        for(int j=p;j<r;j++){
            if(A[j]<x){
                i++;
                swap(A, i, j);
            }
        }
        swap(A, i+1, r);
        return i+1;
    }

    public void swap(int[] A, int i, int j){
        int t = A[i];
        A[i] = A[j];
        A[j] = t;
    }
}
