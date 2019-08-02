package easy;

public class Solution749 {
	public String isBuild(int x) {
		if(x%3 == 0 || x%7 == 0)
			return "YES";
		for(int i=1;i<x/3+1;i++) {
			for(int j=1;j<x/7+1;j++) {
				if(i*3+j*7 == x)
					return "YES";
			}
		}
		
		return "NO";
    }

	public static void main(String[] args) {
		Solution749 s = new Solution749();
		System.out.println(s.isBuild(5));
	}

}
