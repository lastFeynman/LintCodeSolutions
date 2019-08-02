package naive;

public class Solution463 {
	public void sortIntegers(int[] A) {
		int tmp;
        for(int i=0;i<A.length-1;i++) {
        	for(int j=0;j<A.length-i-1;j++) {
        		if(A[j] > A[j+1]) {
        			tmp = A[j];
        			A[j] = A[j+1];
        			A[j+1] = tmp;
        		}
        	}
        }
    }

	public static void main(String[] args) {
		int[] A = {1,2,3,1,1,8,2};
		Solution463 s = new Solution463();
		s.sortIntegers(A);
		for(int i=0;i<A.length;i++)
			System.out.print(A[i]+" ");
	}

}
