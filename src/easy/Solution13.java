package easy;

import java.util.HashMap;
import java.util.Map;

public class Solution13 {
    // O(nm)
    public int strStr(String source, String target) {
        for(int i=0;i<source.length()-target.length()+1;i++){
            int j = 0;
            for (;j<target.length();j++){
                if (source.charAt(i+j) != target.charAt(j))
                    break;
            }
            if (j == target.length())
                return i;
        }
        return -1;
    }

    // O(nm) Hash table, this method maybe output other index rather than first
//    public int strStr(String source, String target) {
//        Map<String, Integer> map = new HashMap<>();
//        for (int i=0;i<source.length()-target.length()+1;i++){
//            map.put(source.substring(i,i+target.length()), i);
//        }
//        Integer index = map.get(target);
//        if (index == null)
//            return -1;
//        return index;
//    }

    // TODO implement KMP algorithm

    public static void main(String[] args) {
        Solution13 solution13 = new Solution13();
        String source = "abcdabcdefg";
        String target = "bcd";
        System.out.println(solution13.strStr(source, target));

    }
}
