package easy;

public class Solution895 {
	public int friendRequest(int[] ages) {
		int requestCount = 0;
		for(int i=0;i<ages.length-1;i++) {
			for(int j=i+1;j<ages.length;j++) {
				if(!(ages[i] <= ages[j]/2+7 || ages[i] > ages[j] || (ages[i]<100 && ages[j]>100)))
					requestCount++;
				if(!(ages[j] <= ages[i]/2+7 || ages[j] > ages[i] || (ages[j]<100 && ages[i]>100)))
					requestCount++;
			}
		}
        return requestCount;
    }
	
	public static void main(String[] args) {
		int ages[] = {10,39,50};
		Solution895 s = new Solution895();
		System.out.println(s.friendRequest(ages));
	}

}
