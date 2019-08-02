package easy;

public class Solution888 {
	public boolean validWordSquare(String[] words) {
		try {
			for(int i=0;i<words.length;i++) {
				for(int j=0;j<words[i].length();j++) {
					if(words[i].charAt(j) != words[j].charAt(i))
						return false;
				}
			}
		} catch (IndexOutOfBoundsException e) {
			return false;
		}
        return true;
    }
	public static void main(String[] args) {
		Solution888 s = new Solution888();
		String[] strings = {"abcd","bnr","crmy","dtye"};
		System.out.println(s.validWordSquare(strings));
	}
	
}
