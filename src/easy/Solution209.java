package easy;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;

public class Solution209 {
	// O(n) LinkedHashMap
	public char firstUniqChar(String str) {

		char tmpChar;
		Map<Character, Integer> map = new LinkedHashMap<>();
        for(int i=0;i<str.length();i++) {
        	tmpChar = str.charAt(i);
        	if(map.containsKey(tmpChar)) {
        		map.put(tmpChar, map.get(tmpChar)+1);
        	}else
        		map.put(tmpChar, 1);
        }
        for (Entry<Character, Integer> entry : map.entrySet()) {
			if(entry.getValue()==1)
				return entry.getKey();
		}
        return (char)-1;
    }
	public static void main(String[] args) {
		Solution209 s = new Solution209();
		System.out.println(s.firstUniqChar("abaccdeff"));
	}

}
