package easy;

public class Solution846 {
	
	public int[][] multiSort(int[][] array) {
		int[] tmp;
        for(int i=0;i<array.length-1;i++) {
        	for(int j=0;j<array.length-1-i;j++) {
        		if(array[j][0] > array[j+1][0]) {
        			tmp = array[j];
        			array[j] = array[j+1];
        			array[j+1] = tmp;
        		}
        	}
        }
		
        for(int i=0;i<array.length-1;i++) {
        	for(int j=0;j<array.length-1-i;j++) {
        		if(array[j][1] < array[j+1][1]) {
        			tmp = array[j];
        			array[j] = array[j+1];
        			array[j+1] = tmp;
        		}
        	}
        }
        
        return array;
    }
	public static void main(String[] args) {
		int[][] array = {{7,66},{4,77},{3,63},{5,81},{1,88},{9,86},{6,88},{2,82},{8,55},{10,95}};
		new Solution846().multiSort(array);
	}

}
