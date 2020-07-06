package medium;

import java.util.ArrayList;
import java.util.List;

public class Solution1667 {
    // O(n^2)
//    public long intervalStatistics(int[] arr, int k) {
//        List<Integer> zeros = new ArrayList<>();
//        for(int i=0;i<arr.length;i++){
//            if(arr[i] == 0)
//                zeros.add(i);
//        }
//        int count = zeros.size();
//        for(int i=0;i<zeros.size()-1;i++){
//            for(int j=i+1;j<zeros.size();j++){
//                int one = zeros.get(j)-zeros.get(i)-j+i;
//                if(one <= k){
//                    count++;
//                }else
//                    break;
//            }
//        }
//        return count;
//    }

    // O(n)
    public long intervalStatistics(int[] arr, int k) {
        if (arr == null || arr.length == 0) return 0;

        int left = 0, right = 0;
        long numOfOne = 0, sum = 0;

        while (right < arr.length){
            if (arr[right] == 1){
                numOfOne++;
                right++;
                continue;
            }

            if (arr[left] == 1){
                numOfOne--;
                left++;
                continue;
            }

            while (numOfOne > k){
                if (arr[left] == 1){
                    numOfOne--;
                }
                left++;
            }

            sum += right - left + 1 - numOfOne;

            right++;

        }

        return sum;
    }
}
