package medium;

public class Solution143 {
    public void sortColors2(int[] colors, int k) {
        int position = colors.length-1;
        for(int i=k;i>0;i--){
            for(int j=0;j<position+1;j++){
                if(colors[j] == i){
                    colors[j] = colors[position];
                    colors[position] = i;
                    position--;
                    j--;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] A = {3,2,2,1,4};
        Solution143 solution143 = new Solution143();
        solution143.sortColors2(A, 4);
        System.out.println();
    }
}
