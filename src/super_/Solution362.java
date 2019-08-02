package super_;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class Solution362 {
	public ArrayList<Integer> maxSlidingWindow(int[] nums, int k) {
		
//		暴力解法超时
//		ArrayList<Integer> maxs = new ArrayList<>();
//		if(nums.length==0)
//			return maxs;
//		for(int i=0;i<nums.length-k+1;i++) {
//			int max = nums[i];
//			for(int j=1;j<k;j++) {
//				if(nums[i+j]>max) {
//					max = nums[i+j];
//				}
//			}
//			maxs.add(max);
//		}
//		
//        return maxs;
		
//		双向队列解法
//		Deque<Integer> indexs = new LinkedList<>();
//		ArrayList<Integer> maxs = new ArrayList<>();
//		for(int i=0;i<nums.length;i++) {
//			while(indexs.size()>0 && nums[i] >= nums[indexs.getLast()])
//				indexs.removeLast();
//			
//			indexs.addLast(i);
//			if(i-k+1 >= 0)
//				maxs.add(nums[indexs.getFirst()]);
//			if(indexs.getFirst() <= i-k+1)
//				indexs.removeFirst();
//		}
//		
//		return maxs;
		
//		左右两数组解法
		int n = nums.length;
		int[] left = new int[n];
		int[] right = new int[n];
		
		ArrayList<Integer> maxs = new ArrayList<>();
		if(nums.length==0)
			return maxs;
		
		left[0] = nums[0];
		right[n-1] = nums[n-1];
		for(int i=1;i<n;i++) {
			if(i%k==0)
				left[i] = nums[i];
			else
				left[i] = Math.max(nums[i], left[i-1]);
			
			if((n-i-1)%k==0)
				right[n-i-1] = nums[n-i-1];
			else
				right[n-i-1] = Math.max(nums[n-i-1], right[n-i]);
		}
		
		for(int i=0;i<n-k+1;i++) {
			maxs.add(Math.max(right[i], left[i+k-1]));
		}
		return maxs;
    }
	
	public static void main(String[] args) {
		Solution362 solution362 = new Solution362();
		int[] arr = {1,2,3};
		List<Integer> list = solution362.maxSlidingWindow(arr,1);
		for(int max : list) {
			System.out.println(max);
		}
	}

}
