package easy;

public class Solution1775 {
    public int getSum(int A, int B) {
        if (A == B && A % 3 == 0){
            return A;
        }

        int i = A;
        while(i % 3 != 0){
            i++;
        }
        int n = (B - i) / 3;
        int remain = (B - i) % 3;
        if (remain == 1 || remain == 2){
            n++;
        }
        int sum = n * i + ((int)Math.pow(n, 2) - n) / 2 * 3;
        return sum;
    }

    public static void main(String[] args) {
        Solution1775 solution1775 = new Solution1775();
        System.out.println(solution1775.getSum(3,3));
    }
}
