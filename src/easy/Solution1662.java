package easy;

public class Solution1662 {
    public int getAns(int[] a) {
        int[] b  = new int[a.length];
        for (int i=0;i<a.length;i++){
            b[i] = a[i];
        }
        mergeSort(a, 0, a.length-1);
        int mid = a[(a.length-1)/2];
        for(int i=0;i<b.length;i++){
            if (b[i] == mid)
                return i;
        }
        return -1;
    }
    public void merge(int[] A, int p, int q, int r){
        int n1 = q - p + 1;
        int n2 = r - q;

        int[] left = new int[n1];
        int[] right = new int[n2];
        for(int i=p;i<=q;i++){
            left[i-p] = A[i];
        }
        for(int i=q+1;i<=r;i++){
            right[i-q-1] = A[i];
        }

        int i=0,j=0,k=p;
        while(k<r+1 && i<left.length && j<right.length){
            if (left[i] <= right[j]) {
                A[k] = left[i];
                i++;
            }else{
                A[k] = right[j];
                j++;
            }
            k++;
        }
        if(i<left.length){
            for (;i<left.length;i++,k++)
                A[k] = left[i];
        }else{
            for (;j<right.length;j++,k++)
                A[k] = right[j];
        }
    }
    public void mergeSort(int[] A, int p, int r){
        if(p < r) {
            int q = (p + r) / 2;
            mergeSort(A,p,q);
            mergeSort(A,q+1,r);
            merge(A, p, q, r);
        }
    }
}
