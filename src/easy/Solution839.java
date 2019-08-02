package easy;

import java.util.ArrayList;
import java.util.List;

public class Solution839 {
	public List<Interval> mergeTwoInterval(List<Interval> list1, List<Interval> list2) {
        int[] line;
        int min=Integer.MAX_VALUE,max=Integer.MIN_VALUE;
        for(int i=0;i<list1.size();i++) {
        	if(list1.get(i).start<min)
        		min = list1.get(i).start;
        	if(list1.get(i).end>max)
        		max = list1.get(i).end;
        }
        for(int i=0;i<list2.size();i++) {
        	if(list2.get(i).start<min)
        		min = list2.get(i).start;
        	if(list2.get(i).end>max)
        		max = list2.get(i).end;
        }
		line = new int[max-min];
		for(int i=0;i<list1.size();i++) {
			for(int j=list1.get(i).start;j<list1.get(i).end;j++) {
				if(line[j-min] == 0) {
					line[j-min]=1;
				}
			}
		}
		for(int i=0;i<list2.size();i++) {
			for(int j=list2.get(i).start;j<list2.get(i).end;j++) {
				if(line[j-min] == 0) {
					line[j-min]=1;
				}
			}
		}
		
		List<Interval> list = new ArrayList<>();
		
		for(int i=0;i<line.length;) {
			list.add(new Interval(i+min, 0));
			while(i<line.length && line[i] == 1) {
				i++;
			}
			list.get(list.size()-1).end = i+min;
			if(i==line.length)
				break;
			while(line[i] == 0) {
				i++;
			}
		}
		return list;
    }
	public static void main(String[] args) {
		List<Interval> list1 = new ArrayList<>();
		list1.add(new Interval(1, 2));
		list1.add(new Interval(3, 4));
		List<Interval> list2 = new ArrayList<>();
		list2.add(new Interval(2, 3));
		list2.add(new Interval(5, 6));
		
		List<Interval> list = new Solution839().mergeTwoInterval(list1, list2);
		System.out.println(list.size());
	}

}
