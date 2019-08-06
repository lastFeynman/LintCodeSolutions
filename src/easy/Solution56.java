package easy;

import java.util.HashMap;
import java.util.Map;

public class Solution56 {
    public int[] twoSum(int[] numbers, int target) {
        int[] indexes = {-1, -1};
        Map<Integer, Integer> map = new HashMap();
        for(int i =0; i<numbers.length; i++){
           map.put(numbers[i], i);
        }
        for(int i =0; i<numbers.length; i++){
            if (map.containsKey(target-numbers[i])){
                int t = map.get(target-numbers[i]);
                if(i != t){
                    indexes[0] = i;
                    indexes[1] = t;
                    break;
                }
            }
        }
        return indexes;
    }
    public static void main(String[] args) {

    }
}
