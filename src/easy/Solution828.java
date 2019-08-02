package easy;

import java.util.HashMap;

public class Solution828 {
	public boolean wordPattern(String pattern, String str) {
		String[] patternArr = pattern.split("");
		String[] strArr = str.split(" ");
		if(patternArr.length != strArr.length)
			return false;
		if(patternArr.length == 0 || patternArr.length == 1)
			return true;
		
		HashMap<String, String> patternMap = new HashMap<>();
		patternMap.put(patternArr[0], strArr[0]);
		
		for(int i=1;i<strArr.length;i++) {
			if(!patternMap.containsKey(patternArr[i])) {
				if(patternMap.containsValue(strArr[i]))
					return false;
				patternMap.put(patternArr[i],strArr[i]);
				continue;
			}
			if(!patternMap.get(patternArr[i]).equals(strArr[i])) {
				return false;
			}
		}
		
        return true;
    }

	public static void main(String[] args) {
		Solution828 s = new Solution828();
		System.out.println(s.wordPattern("abba", "dog dog dog dog"));
	}

}
