package medium;

import java.util.ArrayList;
import java.util.List;

public class Solution1666 {
    public boolean isPrime(int n) {
        for (int i = 2; i < Math.sqrt(n); i++) {
            if (n % i == 0)
                return false;
        }
        return true;
    }

    public List<List<Integer>> findCombination(int[] a, int head, int length) {
        List<List<Integer>> lists = new ArrayList<>();
        if (length == 0) {
            List<Integer> list = new ArrayList<>();
            lists.add(list);
            return lists;
        }
        for (int i = head + 1; i < a.length - length + 1; i++) {
            List<List<Integer>> list = findCombination(a, i, length - 1);
            for (List<Integer> l : list) {
                if (i >= 0) {
                    l.add(0, a[i]);
                }
            }
            lists.addAll(list);
        }
        return lists;
    }

    public int getWays(int[] a, int k) {
        List<List<Integer>> lists = findCombination(a, -1, k);
        int count = 0;
        for (List<Integer> list : lists) {
            int sum = 0;
            for (int x : list) {
                sum += x;
            }
            if (isPrime(sum))
                count++;
        }
        return count;
    }

    public static void main(String[] args) {
        int[] a = {3, 7, 12, 19};
        Solution1666 solution1666 = new Solution1666();
        System.out.println(solution1666.getWays(a, 3));
    }
}
