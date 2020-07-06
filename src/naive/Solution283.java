package naive;

public class Solution283 {
    public int maxOfThreeNumbers(int num1, int num2, int num3) {
        if(num1 >= num2){
            if(num1 >= num3){
                return num1;
            }else{
                return num3;
            }
        }else{
            if(num2 >= num3){
                return num2;
            }else{
                return num3;
            }
        }
    }

    public static void main(String[] args) {
        Solution283 solution283 = new Solution283();
        System.out.println(solution283.maxOfThreeNumbers(1,2,2));
    }
}
