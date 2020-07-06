package hard;

import java.util.Random;

public class Solution1671 {
    public long playGames(int[] A) {
        int max = select(A, A.length);
        int min = select(A, 1);
        long sum = 0;
        while(max > 0){
            int sub = max - min;
            if(sub == 0){
                if(max%(A.length) != 0)
                    sub = max / (A.length) + 1;
                else
                    sub = max / (A.length);


                if(max < A.length){
                    for(int i=1;i<A.length;i++)
                        A[i] -= sub;
                    sum += sub;
                    max = select(A, A.length);
                    min = select(A, 1);
                    continue;
                }

                int x = sub * (A.length-1);
                sub = sub*A.length;
                for(int i=0;i<A.length;i++){
                    A[i] -= x;
                }
            }else{
                boolean flag = true;
                for (int i=0;i<A.length;i++){
                    if(A[i] != min)
                        A[i] -= sub;
                    else if(flag){
                        A[i] -= sub;
                        flag = false;
                    }
                }
            }
            sum += sub;
            max = select(A, A.length);
            min = select(A, 1);
        }
        return sum;
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
        Solution1671 solution1671 = new Solution1671();
        System.out.println(solution1671.playGames(new int[]{5,5,5,5,5}));
        System.out.println(solution1671.playGames(new int[]{46,46,46}));
    }
}
