package medium;

public class Solution75 {
    public int findPeak(int[] A) {
        return findPeak(A, 0, A.length-1);
    }

    // exceed time limit
//    public int findPeak(int[] A, int p, int r){
//        int length = r - p + 1;
//        if(length <= 2)
//            return -1;
//        if(length == 3){
//            if(A[p+1] > A[p] && A[p+1] > A[r])
//                return p+1;
//        }
//
//        int mid = (p + r) / 2;
//        int left = findPeak(A, p, mid-1);
//        if(left != -1)
//            return left;
//        int right = findPeak(A, mid+1, r);
//        if(right != -1)
//            return right;
//
//        return merge(A, mid);
//    }
//
//    public int merge(int[] A, int mid){
//        if(A[mid] > A[mid+1] && A[mid] > A[mid-1])
//            return mid;
//        else if(mid-2>=0 && A[mid-1] > A[mid-2] && A[mid-1] > A[mid])
//            return mid-1;
//        else if(mid+2 < A.length && A[mid+1] > A[mid+2] && A[mid+1] > A[mid])
//            return mid+1;
//        else
//            return -1;
//    }

    public int findPeak(int[] A, int p, int r){
        int mid = (r + p) / 2;
        if(A[mid] > A[mid-1] && A[mid] > A[mid+1])
            return mid;
        else if(A[mid] < A[mid-1])
            return findPeak(A, p, mid);
        else
            return findPeak(A, mid, r);
    }

    public static void main(String[] args) {
        int[] A = {13,20,21,7};
    }
}
