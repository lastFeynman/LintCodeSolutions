package easy;

import java.util.ArrayList;
import java.util.List;

public class Solution920 {
	public boolean canAttendMeetings(List<Interval> intervals) {
		int maxTime=0;
		for (Interval interval : intervals) {
			if(maxTime<interval.end)
				maxTime = interval.end;
		}
		int[] timeLine = new int[maxTime];
		for (Interval interval : intervals) {
			for(int j=interval.start;j<interval.end;j++) {
				if(timeLine[j] == 1)
					return false;
				timeLine[j] = 1;
			}
		}
		
		return true;
    }
	public static void main(String[] args) {
		ArrayList<Interval> intervals = new ArrayList<>();
		intervals.add(new Interval(0, 2));
		intervals.add(new Interval(2, 3));
		intervals.add(new Interval(3, 10));
		intervals.add(new Interval(11, 23));
		intervals.add(new Interval(22, 24));
		System.out.println(new Solution920().canAttendMeetings(intervals));
	}

}

class Interval {
	int start, end;
	Interval(int start, int end) {
		this.start = start;
		this.end = end;
	}
}