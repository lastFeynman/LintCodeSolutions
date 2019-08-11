package medium;

public class Solution461 {
    public int kthSmallest(int k, int[] nums) {
        int min = findMin(nums);
        int max = findMax(nums);
        int n = max - min + 1;
        int[] C = new int[n];
        for(int i=0;i<C.length;i++){
            C[i] = 0;
        }
        for(int i=0;i<nums.length;i++){
            C[nums[i]-min]++;
        }
        int count = 0;
        for(int i=0;i<C.length;i++){
            if(count >= k)
                return i+min-1;
            count += C[i];
        }
        return max;
    }
    public int findMax(int[] nums){
        int max = Integer.MIN_VALUE;
        for(int num : nums){
            if(num > max)
                max = num;
        }
        return max;
    }
    public int findMin(int[] nums){
        int min = Integer.MAX_VALUE;
        for(int num : nums){
            if(num < min)
                min = num;
        }
        return min;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5,6,8,9,10,7};
        Solution461 solution461 = new Solution461();
        solution461.kthSmallest(10, nums);
    }
}
