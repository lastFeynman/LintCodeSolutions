package easy;

import java.util.ArrayList;
import java.util.List;

public class Solution684 {
	public List<String> missingString(String str1, String str2) {
        String[] str1Words = str1.split(" ");
        String[] str2Words = str2.split(" ");
		
        List<String> words = new ArrayList<>();
        for(String word : str1Words){
        	words.add(word);
        }
        for(String word : str2Words) {
        	while(words.contains(word))
        		words.remove(word);
        }
        return words;
    }

	public static void main(String[] args) {
		Solution684 solution684 = new Solution684();
		List<String> list = solution684.missingString("This is an example is", "This");
		for(String word : list)
			System.out.println(word);
	}

}
