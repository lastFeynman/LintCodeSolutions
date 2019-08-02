package easy;

import java.util.ArrayList;

public class Solution830 {
	char character;
	int frequency = 0;
	public Solution830(char character) {
		this.character = character;
	}
	public Solution830() {}
	
	public String stringSort(String str) {
		ArrayList<Solution830> frequencyList = new ArrayList<Solution830>();
		for(int i=0;i<26;i++)
			frequencyList.add(new Solution830((char)(97+i)));
		
		for(int i=0;i<str.length();i++) {
			frequencyList.get(str.charAt(i)-97).frequency++;
		}
		StringBuffer sb = new StringBuffer();
		int maxFrequency;
		int maxIndex;
		while(frequencyList.size() != 0) {
			maxFrequency = frequencyList.get(0).frequency;
			maxIndex = 0;
			for(int i=0;i<frequencyList.size();i++) {
				if(frequencyList.get(i).frequency>maxFrequency) {
					maxFrequency = frequencyList.get(i).frequency;
					maxIndex = i;
				}
			}
			if(maxFrequency==0)
				break;
			
			for(int i=0;i<maxFrequency;i++)
				sb.append(frequencyList.get(maxIndex).character);
			
			frequencyList.remove(maxIndex);
		}
		String sortedStr = new String(sb);
        return sortedStr;
    }

	public static void main(String[] args) {
		Solution830 s = new Solution830();
		System.out.println(s.stringSort("bloomberg"));
	}

}