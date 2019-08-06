package easy;

public class Solution1 {
    public int aplusb(int a, int b) {
        while(b != 0){
            int carry = a & b;
            a = a ^ b;
            b = carry << 1;
        }
        return a;
    }

    public static void main(String[] args){
        Solution1 cat1 = new Solution1();
        System.out.println(3^4);
    }
}