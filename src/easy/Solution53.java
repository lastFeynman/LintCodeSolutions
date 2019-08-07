package easy;

import java.util.StringTokenizer;

public class Solution53 {
    public String reverseWords(String s) {
        StringTokenizer tokenizer = new StringTokenizer(s);
        StringBuffer stringBuffer = new StringBuffer();
        while(tokenizer.hasMoreTokens()){
            stringBuffer.append(tokenizer.nextToken()+" ");
        }
        s = new String(stringBuffer);

        String[] words = s.split(" ");
        for(int i=0;i<words.length/2;i++){
            words[i].replace(" ","");
            String t = words[i];
            words[i] = words[words.length-1-i];
            words[words.length-1-i] = t;
        }

        return String.join(" ", words);
    }

    public static void main(String[] args) {
        Solution53 solution53 = new Solution53();
        System.out.println(solution53.reverseWords("  Life  doesn't  always    give     us  the       joys we want."));
    }
}
