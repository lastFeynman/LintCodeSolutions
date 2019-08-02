package easy;

public class Solution415 {
	public boolean isPalindrome(String s) {
        s = s.toLowerCase();
        int i=0,j=s.length()-1;
        while(i!=j && i<j) {
        	if(s.charAt(i) < 48 || (s.charAt(i) > 57 && s.charAt(i) < 97) || s.charAt(i) > 122) {
        		i++;
        		continue;
        	}
        	if(s.charAt(j) < 48 || (s.charAt(j) > 57 && s.charAt(j) < 97) || s.charAt(j) > 122) {
        		j--;
        		continue;
        	}
        	if(s.charAt(i) != s.charAt(j))
        		return false;
        	
        	i++;
        	j--;
        }
		
		return true;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution415 s = new Solution415();
		System.out.println(s.isPalindrome("2"));
	}

}
