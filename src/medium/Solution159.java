package medium;

public class Solution159 {
    public int findMin(int[] nums) {
        if(nums == null || nums.length == 0)
            return -1;

        int rotate = 0;
        if(nums[0] > nums[nums.length-1]){
            rotate = findRotate(nums);
        }
        return nums[rotate];
    }

    public int findRotate(int[] A, int p, int r){
        int mid = p + (r - p) / 2;
        if(r-p == 1)
            return A[p]>A[r]?r:p;

        if(A[mid] > A[p] && A[mid] > A[r])
            return findRotate(A, mid+1, r);
        if(A[mid] < A[p] && A[mid] < A[r])
            return findRotate(A, p, mid);
        return p;
    }

    public int findRotate(int[] A){
        int start = 0;
        int end = A.length-1;
        while(end - start > 1){
            int mid = start + (end - start) / 2;
            if(A[mid] > A[start] && A[mid] > A[end]) {
                start = mid + 1;
                continue;
            }
            if(A[mid] < A[start] && A[mid] < A[end]) {
                end = mid;
                continue;
            }
            return start;
        }
        if(end - start == 1)
            return A[start]>A[end]?end:start;
        return start;
    }

}
