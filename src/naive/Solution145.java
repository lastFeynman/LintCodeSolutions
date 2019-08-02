package naive;

public class Solution145 {
	public char lowercaseToUppercase(char character) {
        return (char)(character-32);
    }

	public static void main(String[] args) {
		Solution145 s = new Solution145();
		
		System.out.println(s.lowercaseToUppercase('a'));
	}

}
