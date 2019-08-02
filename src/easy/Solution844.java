package easy;

public class Solution844 {
	public int pairNumbers(Point[] p) {
        int count = 0;
        for(int i=0;i<p.length-1;i++) {
        	for(int j=i+1;j<p.length;j++) {
        		if((p[i].x+p[j].x)%2==0 && (p[i].y+p[j].y)%2==0) {
        			count++;
        		}
        	}
        	
        }
        
        return count;
    }

	public static void main(String[] args) {
		Point[] points = new Point[3];
		points[0] = new Point(1, 2);
		points[1] = new Point(3, 4);
		points[2] = new Point(5, 6);
		//points[0] = new Point(1, 2);
		System.out.println(new Solution844().pairNumbers(points));
	}

}

class Point{
	int x;
	int y;
	public Point(int x,int y) {
		this.x = x;
		this.y = y;
	}
}