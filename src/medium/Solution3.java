package medium;
import java.util.ArrayList;

public class Solution3 {

	
	public int digitCounts(int k, int n) {
		ArrayList<String> list = new ArrayList<String>();
		int numK = 0,x;
		for(int i=0;i<n+1;i++) {
			x = 0;
			for(int j=0;j<(i+"").length();j++) {
				if((i+"").charAt(j) == k+48) {
					numK++;
					x++;
				}
			}
			if(x != 0) {
				list.add(i+"");
			}
		}
		
		return numK;
        
    }
    
	public static void main(String[] args) {
		
	}
}
