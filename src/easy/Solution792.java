package easy;

import java.util.ArrayList;

public class Solution792 {
	public int kthPrime(int n) {
		ArrayList<Integer> primeNumList = new ArrayList<Integer>();
		outer:for(int i=2;i<n;i++) {
			for(int j=2;j<=Math.sqrt(i);j++) {
				if(i%j==0)
					continue outer;
			}
			primeNumList.add(i);
		}
		primeNumList.add(n);
        return primeNumList.size();
    }

	public static void main(String[] args) {
		Solution792 s = new Solution792();
		System.out.println(s.kthPrime(7));
	}

}
