package easy;

public class Solution464 {
    public void sortIntegers2(int[] A) {
        mergeSort(A, 0, A.length-1);
    }

    public void mergeSort(int[] A, int p, int r){
        if(p < r){
            int mid = (p + r) / 2;
            mergeSort(A, p, mid);
            mergeSort(A, mid+1, r);
            merge(A, p, mid, r);
        }
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
}
