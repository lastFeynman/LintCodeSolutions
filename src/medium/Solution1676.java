package medium;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Solution1676 {
    public int getDistance(int n, int m, int target, List<Integer> d) {
        if(m >= n)
            return target;
        d.add(0, d.get(0));
        for(int i=1;i<d.size()-1;i++){
            d.set(i, d.get(i+1)-d.get(i));
        }
        d.set(d.size()-1, target-d.get(d.size()-1));

        for(int i=0;i<m;i++){
            int[] disCopy = new int[d.size()];
            for(int j=0;j<disCopy.length;j++)
                disCopy[j] = d.get(j);
            int min = select(disCopy, 1);
            int index = d.indexOf(min);

            if (index == d.size()-1 || (index != 0 && d.get(index - 1) < d.get(index + 1))) {
                d.set(index - 1, d.get(index - 1) + d.get(index));
            }else{
                d.set(index+1, d.get(index)+d.get(index+1));
            }
            d.remove(index);
        }
        int[] disCopy = new int[d.size()];
        for(int j=0;j<disCopy.length;j++)
            disCopy[j] = d.get(j);
        return select(disCopy, 1);
    }

    public int select(int[] A, int i){
        int p=0, r=A.length-1;
        while(true){
            if(p == r)
                return A[p];

            int q = randomPartition(A, p, r);
            int k = q - p + 1;
            if(k == i)
                return A[q];
            else if(i < k){
                r = q-1;
            }else{
                p = q+1;
                i = i-k;
            }
        }
    }

    public int randomPartition(int[] A, int p, int r){
        Random random = new Random();
        int i = random.nextInt(r-p+1)+p;
        int t = A[r];
        A[r] = A[i];
        A[i] = t;
        return partition(A, p, r);
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

    public static void main(String[] args) {
        List<Integer> d = new ArrayList<>();
        d.add(2);
        d.add(11);
        d.add(14);
        d.add(17);
        d.add(21);
        Solution1676 solution1676 = new Solution1676();
        System.out.println(solution1676.getDistance(5, 2, 25, d));
    }
}
