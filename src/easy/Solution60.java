package easy;

public class Solution60 {
    public int searchInsert(int[] A, int target) {
        if(A.length == 0)
            return 0;

        if(A[A.length-1] < target)
            return A.length;

        int low = 0;
        int high = A.length-1;
        int lastMid = 0;
        int mid = (low+high)/2;
        while(high > low && lastMid != mid){
            if(A[mid] == target)
                return mid;
            else if(A[mid] > target) {
                high = mid;
            }else{
                low = mid;
            }
            lastMid = mid;
            mid = (high+low)/2;
        }
        if(high==low){
            if(A[low] >= target)
                return low;
            else
                return low+1;
        }
        return high;
    }
}
