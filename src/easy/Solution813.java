package easy;

public class Solution813 {
	public int[] anagramMappings(int[] A, int[] B) {
		int[] answer = new int[A.length];
		for(int i=0;i<A.length;i++) {
			for(int j=0;j<B.length;j++) {
				if(B[j]==A[i]) {
					answer[i] = j;
					break;
				}
			}
		}
		
        return answer;
    }

	public static void main(String[] args) {
		
		// TODO Auto-generated method stub

	}

}
