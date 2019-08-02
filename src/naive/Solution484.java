package naive;

public class Solution484 {
	public void swapIntegers(int[] A, int index1, int index2) {
        int tmp;
        tmp = A[index1];
        A[index1] = A[index2];
        A[index2] = tmp;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
