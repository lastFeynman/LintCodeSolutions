package easy;

public class Solution8 {
    public void rotateString(char[] str, int offset) {
        if(str.length > 1 && offset%str.length != 0){

            offset = offset%str.length;

            int i = 0, round = 0;
            while(i<str.length) {
                int end = offset + round;

                char pre = str[round], temp;
                str[round] = '\0';
                while (str[round] == '\0') {
                    temp = str[end];
                    str[end] = pre;
                    pre = temp;
                    end = (end + offset) % str.length;
                    i++;
                }
                round++;
            }
        }
    }

    public static void main(String[] args){
        Solution8 solution8 = new Solution8();
        char[] str = {'a','b','c','d','e','f','g','h'};
//        str = new char[1];
//        str[0] = 'a';
        solution8.rotateString(str, 2);
        System.out.println(str);
    }
}
