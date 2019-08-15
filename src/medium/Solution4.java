package medium;

public class Solution4 {
    // easiest method
//    public int nthUglyNumber(int n) {
//        int count = 0;
//        int uglyNumber = 0;
//        while(count < n){
//            uglyNumber++;
//            int test = uglyNumber;
//            while(test%2 == 0){
//                test /= 2;
//            }
//            while(test%3==0){
//                test /= 3;
//            }
//            while(test%5==0){
//                test /= 5;
//            }
//            if(test == 1){
//                count++;
//            }
//        }
//        return uglyNumber;
//    }

    // dynamic programming
    public int nthUglyNumber(int n) {
        int[] ugly = new int[n];
        ugly[0] = 1;
        int i2 = 0, i3 = 0, i5 = 0;
        int multiply2 = 2;
        int multiply3 = 3;
        int multiply5 = 5;
        int nextUgly = 1;
        for(int i=1;i<n;i++){
            nextUgly = Math.min(multiply2, Math.min(multiply3, multiply5));
            ugly[i] = nextUgly;
            if(nextUgly == multiply2){
                i2++;
                multiply2 = ugly[i2] * 2;
            }
            if(nextUgly == multiply3){
                i3++;
                multiply3 = ugly[i3] * 3;
            }
            if(nextUgly == multiply5){
                i5++;
                multiply5 = ugly[i5] * 5;
            }
        }
        return nextUgly;
    }

    public static void main(String[] args) {
        Solution4 solution4 = new Solution4();
        System.out.println(solution4.nthUglyNumber(150));
    }
}
