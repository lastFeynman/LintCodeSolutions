package medium;

public class Solution61 {
    public int[] searchRange(int[] A, int target) {
        int start = biSearchL(A, 0, A.length-1, target);
        int end = biSearchR(A, 0, A.length-1, target);
        return new int[]{start, end};
    }

    public int biSearchL(int[] A, int p, int r, int target){
        int length = r - p + 1;
        if(length <= 0 || (length == 1 && A[p] != target))
            return -1;
        if(length == 2){
            if(A[p] == target)
                return p;
            else if(A[r] == target)
                return r;
            else
                return -1;
        }

        int mid = (p + r) / 2;

        if(A[mid] == target && ( mid - 1 < p || A[mid-1] != target)){
            return mid;
        } else if(A[mid] == target || A[mid] > target){
            return biSearchL(A, p, mid-1, target);
        }else{
            return biSearchL(A, mid+1, r, target);
        }
    }

    public int biSearchR(int[] A, int p, int r, int target){
        int length = r - p + 1;
        if(length <= 0 || (length == 1 && A[p] != target))
            return -1;
        if(length == 2){
            if(A[r] == target)
                return r;
            else if(A[p] == target)
                return p;
            else
                return -1;
        }

        int remain = (p + r) % 2;
        int mid = (p + r) / 2;
        if(remain == 1)
            mid++;

        if(A[mid] == target && (mid + 1 > r || A[mid+1] != target)){
            return mid;
        } else if(A[mid] > target){
            return biSearchR(A, p, mid-1, target);
        }else{
            return biSearchR(A, mid+1, r, target);
        }
    }

    public static void main(String[] args) {
        int[] A = {5,7,7,8,8,10};
        Solution61 solution61 = new Solution61();
        int[] a = solution61.searchRange(A, 8);
        System.out.println(a[0]+" "+a[1]);
    }
}
