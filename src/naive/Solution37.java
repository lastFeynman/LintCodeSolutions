package naive;

public class Solution37 {
	public int reverseInteger(int number) {
        StringBuffer sb = new StringBuffer(number+"");
        sb.reverse();
        return Integer.parseInt(new String(sb));
    }

	public static void main(String[] args) {
		Solution37 s = new Solution37();
		System.out.println(s.reverseInteger(123));
	}

}
