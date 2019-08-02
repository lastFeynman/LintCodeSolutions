package easy;

import java.util.ArrayList;
import java.util.List;

public class Solution44 {
	public int minSubArray(List<Integer> nums) {
//		ArrayList<Integer> negativeSumList = new ArrayList<>();
//		ArrayList<Integer> positiveSumList = new ArrayList<>();
//		int minPositive = Integer.MAX_VALUE;
//		int i=0;
//		while(i<nums.size()) {
//			if(nums.get(i)<0) {
//				negativeSumList.add(0);
//				while(i<nums.size() && nums.get(i)<=0) {
//					negativeSumList.set(negativeSumList.size()-1, negativeSumList.get(negativeSumList.size()-1)+nums.get(i));
//					i++;
//				}
//				if(i==nums.size())
//					break;
//				positiveSumList.add(0);
//				while(i<nums.size() && nums.get(i)>=0) {
//					positiveSumList.set(positiveSumList.size()-1, positiveSumList.get(positiveSumList.size()-1)+nums.get(i));
//					i++;
//				}
//			}else {
//				if(nums.get(i)<minPositive)
//					minPositive = nums.get(i);
//				i++;
//			}
//		}
//		if(negativeSumList.size()==0)
//			return minPositive;
//		int minSum = Integer.MAX_VALUE;
//		int tmpSum;
//		int localMinSum;
//		for(i=0;i<negativeSumList.size();i++) {
//			localMinSum = negativeSumList.get(i);
//			for(int j=i+1;j<negativeSumList.size();j++) {
//				tmpSum = negativeSumList.get(i);
//				for(int k=i+1;k<=j;k++) {
//					tmpSum += positiveSumList.get(k-1);
//					tmpSum += negativeSumList.get(k);
//				}
//				if(localMinSum>tmpSum)
//					localMinSum = tmpSum;
//			}
//			if(localMinSum<minSum)
//				minSum = localMinSum;
//		}
//		return minSum;
		int[] globalMin = new int[nums.size()];
		int[] localMin = new int[nums.size()];
		
		for(int i=0;i<nums.size();i++) {
			if(i==0) {
				globalMin[i] = localMin[i] = nums.get(i);
			}else {
				localMin[i] = Math.min(localMin[i-1]+nums.get(i), nums.get(i));
				globalMin[i] = Math.min(localMin[i], globalMin[i-1]);
			}
		}
		
		return globalMin[nums.size()-1];
    }
	
	public static void main(String[] args) {
		ArrayList<Integer> list = new ArrayList<>();
		Solution44 s = new Solution44();
		list.add(-19);
		list.add(1);
		list.add(-2);
		list.add(1);
		list.add(-2);
		list.add(1);
		list.add(-15);
		System.out.println(s.minSubArray(list));
	}

}
