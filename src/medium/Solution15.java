package medium;

import java.util.ArrayList;
import java.util.List;

public class Solution15 {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> lists = new ArrayList<>();
        if(nums == null || nums.length == 0){
            List<Integer> list = new ArrayList<>();
            lists.add(list);
            return lists;
        }

        int[] fact = new int[nums.length+1];
        fact[0] = 1;
        for(int i=1;i<fact.length;i++){
            fact[i] = fact[i-1] * i;
        }

        for(int i=0; i<fact[nums.length]; i++){
            List<Integer> list = new ArrayList<>();
            int[] temp = copyArray(nums);
            int tempLength = temp.length;
            int positionCode = i;
            for(int j=nums.length;j>0;j--){
                int selected = positionCode / fact[j-1];
                list.add(temp[selected]);
                positionCode = positionCode % fact[j-1];
                tempLength--;
                swap(temp, selected, tempLength);
            }
            lists.add(list);
        }

        return lists;
    }

    public int[] copyArray(int[] A){
        int[] copy = new int[A.length];

        for(int i=0;i<copy.length; i++)
            copy[i] = A[i];

        return copy;
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
            swap(nums, p, i);
            List<List<Integer>> midResult = permuteRecursive(nums, p+1, r);
            swap(nums, p, i);
            for(List<Integer> list : midResult){
                list.add(0, nums[i]);
            }
            lists.addAll(midResult);
        }
        return lists;
    }

    public void swap(int[] A, int i, int j){
        int t = A[i];
        A[i] = A[j];
        A[j] = t;
    }

    public static void main(String[] args) {
        int[] nums = new int[10];
        for(int i=0;i<nums.length;i++)
            nums[i] = i+1;
        Solution15 solution15 = new Solution15();
        System.out.println(solution15.permute(nums));
    }
}
