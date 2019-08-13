package medium;

import java.util.Random;

public class Solution1753 {
//    public long doingHomework(int[] cost, int[] val) {
//        int sumAll = 0;
//        int sum = 0;
//        int remainCount = val.length;
//        for(int i=0;i<cost.length;i++){
//            sum += cost[i];
//            int count = 0;
//            for(int j=0;j<remainCount;j++) {
//                if (val[j] >= sum)
//                    count++;
//                else {
//                    swap(val, j, remainCount - 1);
//                    remainCount--;
//                    j--;
//                }
//            }
//            sumAll += count * cost[i];
//        }
//        return sumAll;
//    }
//    public long doingHomework(int[] cost, int[] val) {
//        int sumAll = 0;
//        int sum = 0;
//        int remainCount = val.length;
//        for(int i=0;i<cost.length;i++){
//            sum += cost[i];
//        }
//
//        for(int i=cost.length-1;i>=0;i--){
//            int count = 0;
//            for(int j=0;j<remainCount;j++) {
//                if (val[j] >= sum) {
//                    count++;
//                    swap(val, j, remainCount-1);
//                    remainCount--;
//                    j--;
//                }
//            }
//            sumAll += count * sum;
//            sum = sum - cost[i];
//        }
//        return sumAll;
//    }
    public long doingHomework(int[] cost, int[] val){
        quickSort(val,0,val.length-1);
        int sum = 0;
        int sumAll = 0;
        for(int i=0;i<cost.length;i++) {
            sum += cost[i];
            int indexL = biSearchL(val, sum);
            sumAll += (val.length-indexL) * cost[i];
        }
        return sumAll;
    }

    public int biSearchL(int[] A, int target){
        int start = 0;
        int end = A.length-1;
        while (start < end){
            int mid = start + (end - start) / 2;
            if(A[mid] >= target) {
                end = mid;
                continue;
            }
            if(A[mid] < target){
                start = mid+1;
            }
        }
        return start;
    }

    public void quickSort(int[] A, int p, int r){
        if(p < r){
            int mid = randomPartition(A, p, r);
            quickSort(A, p, mid-1);
            quickSort(A, mid+1, r);
        }
    }

    public int partition(int[] A, int p, int r){
        int x = A[r];
        int i = p-1;
        for(int j=p;j<r;j++){
            if(A[j]<=x){
                i++;
                int t = A[i];
                A[i] = A[j];
                A[j] = t;
            }
        }
        int t = A[i+1];
        A[i+1] = A[r];
        A[r] = t;
        return i+1;
    }

    public int randomPartition(int[] A, int p, int r){
        Random random = new Random();
        int i = random.nextInt(r-p+1)+p;
        int t = A[r];
        A[r] = A[i];
        A[i] = t;
        return partition(A, p, r);
    }

    public void swap(int[] A, int i, int j){
        int t = A[i];
        A[i] = A[j];
        A[j] = t;
    }

    public static void main(String[] args) {
        int[] A = {1,3,5,5,7};
        Solution1753 solution1753 = new Solution1753();
        System.out.println(solution1753.biSearchL(A, 7));
    }
}
