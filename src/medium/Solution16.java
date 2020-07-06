package medium;

import java.util.ArrayList;
import java.util.List;

public class Solution16 {
    public List<List<Integer>> permuteUnique(int[] nums) {
        return permuteRecursive(nums, 0, nums.length-1);
    }

    public List<List<Integer>> permuteRecursive(int[] nums, int p, int r){
        List<List<Integer>> lists = new ArrayList<>();
        if(p > r){
            List<Integer> list = new ArrayList<>();
            lists.add(list);
            return lists;
        }
        if(p == r){
            List<Integer> list = new ArrayList<>();
            list.add(nums[p]);
            lists.add(list);
            return lists;
        }

        for(int i=p;i<=r;i++){
            if(!shouldSwap(nums, p, i))
                continue;

            swap(nums, p, i);
            List<List<Integer>> midResult = permuteRecursive(nums, p+1, r);
            swap(nums, p ,i);
            for(List<Integer> list : midResult){
                list.add(0, nums[i]);
            }
            lists.addAll(midResult);
        }
        return lists;
    }

    public boolean shouldSwap(int[] nums, int p, int r){
        for(int i=p;i<r;i++){
            if(nums[i] == nums[r])
                return false;
        }
        return true;
    }

    public void swap(int[] A, int i, int j){
        int t = A[i];
        A[i] = A[j];
        A[j] = t;
    }
}
