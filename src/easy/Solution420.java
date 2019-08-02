package easy;
import java.util.ArrayList;
public class Solution420 {
	char digit;
	int count;
	public Solution420(char digit,int count) {
		this.digit = digit;
		this.count = count;
	}
	public Solution420() {}
	public String countAndSay(int n) {
		ArrayList<Solution420> list = new ArrayList<>();
		String resultStr = "1";
		char tmpDigit;
		int tmpCount;
		for(int i=0;i<n-1;i++) {
			list.clear();
			tmpCount = 1;
			tmpDigit = resultStr.charAt(0);
			for(int j=1;j<resultStr.length();j++) {
				if(resultStr.charAt(j) != tmpDigit) {
					list.add(new Solution420(tmpDigit,tmpCount));
					tmpDigit = resultStr.charAt(j);
					tmpCount = 1;
				}else {
					tmpCount++;
				}
			}
			list.add(new Solution420(tmpDigit, tmpCount));
			resultStr = "";
			for(int j=0;j<list.size();j++)
				resultStr += list.get(j).count+""+list.get(j).digit;
		}
        return resultStr;
    }
	public static void main(String[] args) {
		Solution420 s = new Solution420();
		System.out.println(s.countAndSay(5));
	}
}
