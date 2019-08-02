package easy;

import java.util.ArrayList;
import java.util.List;

public class Solution784 {
	
	public int the_longest_common_prefix(List<String> dic, String target) {
		int theLongestPrefix = 0;
		int prefix;
		for(int i=0;i<dic.size();i++) {
			prefix = 0;
			for(int j=0;j<dic.get(i).length()&&j<target.length();j++) {
				if(dic.get(i).charAt(j) == target.charAt(j))
					prefix++;
				else
					break;
			}
			if(prefix>theLongestPrefix)
				theLongestPrefix = prefix;
		}
		
        return theLongestPrefix;
    }

	public static void main(String[] args) {
		ArrayList<String> dic = new ArrayList<String>();
		dic.add("qeqwdwcq");
		dic.add("qwefq");
		dic.add("efwegerwgq");
		dic.add("qerwth5yeujq");
		
		Solution784 s = new Solution784();
		System.out.println(s.the_longest_common_prefix(dic, "qeqwd"));
	}

}
