package easy;
import java.util.ArrayList;
import java.util.List;
public class Solution671 {
	public int countRotateWords(List<String> words) {
        ArrayList<String[]> dicList = new ArrayList<>();
        outer:for(int i=0;i<words.size();i++) {
        	for(int j=0;j<dicList.size();j++) {
        		for(int k=0;k<dicList.get(j).length;k++) {
        			if(words.get(i).equals(dicList.get(j)[k])) {
        				continue outer;
        			}
        		}
        	}
        	dicList.add(new String[words.get(i).length()]);
        	String tmpString = words.get(i);
        	char[] tmpArr;
        	char tmpChar;
        	for(int j=0;j<words.get(i).length();j++) {
        		dicList.get(dicList.size()-1)[j] = tmpString;
        		tmpChar = tmpString.charAt(tmpString.length()-1);
        		tmpArr = tmpString.toCharArray();
        		for(int k=tmpString.length()-1;k>0;k--) {
        			tmpArr[k] = tmpArr[k-1];
        		}
        		tmpArr[0] = tmpChar;
        		tmpString = new String(tmpArr);
        	}
        }
		return dicList.size();
    }

	public static void main(String[] args) {
		Solution671 s = new Solution671();
		List<String> list = new ArrayList<String>();
		list.add("picture");
		list.add("turepic");
		list.add("icturep");
		list.add("word");
		list.add("rdwo");
		list.add("lint");
		
		System.out.println(s.countRotateWords(list));
	}

}
