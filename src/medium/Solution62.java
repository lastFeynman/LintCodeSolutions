package medium;

public class Solution62 {
    public int search(int[] A, int target) {
        if(A == null || A.length == 0)
            return -1;

        int rotate = 0;
        if(A[0] > A[A.length-1]){
            rotate = findRotate(A, 0, A.length-1);
        }
        return biSearch(A, rotate, target);
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

    public int biSearch(int[] A, int rotate, int target){
        int end = rotate + A.length - 1;
        int start = rotate;
        while(start < end){
            int mid = start + (end - start) / 2;
            if(A[mid%A.length] == target)
                return mid%A.length;
            else if(A[mid%A.length] > target)
                end = mid - 1;
            else
                start = mid + 1;

        }
        if(start == end && A[start%A.length] == target)
            return start%A.length;
        return -1;
    }

    public static void main(String[] args) {
        int[] A = {4,3};
        Solution62 solution62 = new Solution62();
        System.out.println(solution62.search(A, 3));
    }
}
