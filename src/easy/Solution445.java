package easy;
public class Solution445 {
	public double cosineSimilarity(int[] A, int[] B) {
		if(A.length != B.length || A.length==0 || B.length==0)
			return 2;
		
		int innerProduct=0;
		double lengthOfA=0,lengthOfB=0;
		
		for(int i=0;i<A.length;i++) {
			innerProduct += A[i]*B[i];
			lengthOfA += A[i]*A[i];
			lengthOfB += B[i]*B[i];
		}
		lengthOfA = Math.sqrt(lengthOfA);
		lengthOfB = Math.sqrt(lengthOfB);
		if(lengthOfA==0 || lengthOfB==0)
			return 2;
		double cos = innerProduct/(lengthOfA*lengthOfB);
        return cos;
    }
}
