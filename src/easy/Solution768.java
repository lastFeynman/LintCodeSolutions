package easy;

import java.util.ArrayList;
import java.util.List;

public class Solution768 {
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<List<Integer>> calcYangHuisTriangle(int n) {
		ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
		
		for(int i=0;i<n;i++) {
			list.add(new ArrayList<Integer>());
			list.get(i).add(1);
			for(int j=0;j<i-1;j++) {
				list.get(i).add(list.get(i-1).get(j)+list.get(i-1).get(j+1));
			}
			if(i!=0)
				list.get(i).add(1);
		}
		
		return (List)list;
    }
	public static void main(String[] args) {
		
	}

}
