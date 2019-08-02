package easy;
import java.util.HashSet;
public class Solution488 {
	public boolean isHappy(int n) {
		if(n <= 0)
			return false;
		
		StringBuffer nStr = new StringBuffer();
		int nCopy = n;
		HashSet<Integer> oldN = new HashSet<>();
		oldN.add(nCopy);
		while(!oldN.contains(1)) {
			nStr.replace(0, nStr.length(), nCopy+"");
			nCopy = 0;
			for(int i=0;i<nStr.length();i++) {
				nCopy += (nStr.charAt(i)-48)*(nStr.charAt(i)-48);
			}
			
			if(nCopy!=1 && oldN.contains(nCopy))
				return false;
			oldN.add(nCopy);
		}
		
		return true;
    }

	public static void main(String[] args) {
		System.out.println(new Solution488().isHappy(19));
	}

}
