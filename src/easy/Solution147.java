package easy;

import javax.sound.sampled.Line;
import java.util.LinkedList;
import java.util.List;

public class Solution147 {
    public List<Integer> getNarcissisticNumbers(int n) {
        List<Integer> list = new LinkedList<Integer>();
        int low, span;
        low = (int)Math.pow(10, n-1);

        span = 9 * low;
        if (n == 1) {
            low = 0;
            span = 10;
        }
        for (int i=low; i<low+span; i++){
            int sum = 0;
            int[] digits = divide(n, i);
            for(int j=0; j<n; j++){
                sum = sum + (int)Math.pow(digits[j],n);
            }
            if (sum == i)
                list.add(i);
        }
        return list;
    }
    public int[] divide(int n, int num){
        int[] digits = new int[n];
        for (int i=0; i<n; i++){
            digits[i] = num % 10;
            num = num / 10;
        }
        return digits;
    }

    public static void main(String[] args) {
        Solution147 solution147 = new Solution147();
        System.out.println(solution147.divide(3, 375)[0]);
        System.out.println(solution147.getNarcissisticNumbers(3));
    }
}
