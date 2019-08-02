package naive;

public class Solution366 {
	public int fibonacci(int n) {
		if(n == 1)
			return 0;
		if(n == 2)
			return 1;
		
		int i1 = 0,i2 = 1,in = 0;
		for(int i=3; i<=n;i++) {
			in = i1 + i2;
			i1 = i2;
			i2 = in;
		}
		return in;
    }
	
	public static void main(String args[]) {
		Solution366 solution366 = new Solution366();
		
		for(int i=1;i<11;i++)
			System.out.println(solution366.fibonacci(i));
	}
}
