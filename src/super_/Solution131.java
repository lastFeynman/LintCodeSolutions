package super_;

import java.util.Date;
import java.util.ArrayList;
import java.util.List;

public class Solution131 {
//	public List<List<Integer>> buildingOutline(int[][] buildings) {
//        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
//        for(int[] building : buildings) {
//        	if(building[0]<min)
//        		min = building[0];
//        	if(building[1]>max)
//        		max = building[1];
//        }
//		
//		int[] horizen = new int[max-min];
//		for(int i=0;i<max-min;i++)
//			horizen[i] = Integer.MIN_VALUE;
//		for(int[] building : buildings) {
//			for(int i=0;i<building[1]-building[0];i++) {
//				if(horizen[building[0]-min+i] < building[2])
//					horizen[building[0]-min+i] = building[2];
//			}
//		}
//		
//		List<List<Integer>> skylines = new ArrayList<>();
//		for(int i=0;i<horizen.length;i++) {
//			if(horizen[i]>0) {
//				List<Integer> skyline = new ArrayList<>();
//				skyline.add(i+min);
//				skyline.add(horizen[i]);
//				while(i<horizen.length && horizen[i]==skyline.get(1))
//					i++;
//				skyline.add(1,i+min);
//				skylines.add(skyline);
//				i--;
//			}
//		}
//		
//		return skylines;
//		
//		
//		return null;
//    }
	
    
    public List<List<Integer>> buildingOutline(int[][] buildings) {
    	MaxHeap heap;
        int n = buildings.length;        
        // {x, h, id}
        ArrayList<int[]> es = new ArrayList<int[]>();
        
        for (int i = 0; i < n; ++i) {
            es.add(new int[]{ buildings[i][0], buildings[i][2], i});
            es.add(new int[]{ buildings[i][1], -buildings[i][2], i});
        }
        
        es.sort((e1, e2) -> {
            return e1[0] == e2[0] ? e2[1] - e1[1] : e1[0] - e2[0]; });
        
        
        List<List<Integer>> ans = new ArrayList<>();
        
        heap = new MaxHeap(n);

        Boolean flag = false;
        
        for (int[] e : es) {
            int x = e[0];
            int h = e[1];
            int id = e[2];
            
            Boolean entering = h > 0;
            h = Math.abs(h);
            
            if (entering) {
                if (h > heap.max()) {
                	if(flag) {
                		ans.get(ans.size()-1).add(1, x);
                	}
                	flag = true;
                	List<Integer> skyline = new ArrayList<>();
                	skyline.add(x);
                	skyline.add(h);
                    ans.add(skyline);
                }
                heap.add(h, id);
            } else {
                heap.remove(id);
                if (h > heap.max()) {
                	if(flag) {
                		ans.get(ans.size()-1).add(1, x);
                	}
                	if(heap.max()>0) {
                		flag = true;
                		List<Integer> skyline = new ArrayList<>();
                    	skyline.add(x);
                    	skyline.add(heap.max());
                		ans.add(skyline);
                	}else {
                		flag = false;
                	}
                }
            }
        }
        
        return ans;
    }
    
    private class MaxHeap {
        // (key, id)
        private List<int[]> nodes;
        
        // idx[i] = index of building[i] in nodes
        private int[] idx;
        
        public MaxHeap(int size) {
            idx = new int[size];
            nodes = new ArrayList<int[]>();
        }
        
        public void add(int key, int id) {
            idx[id] = nodes.size();
            nodes.add(new int[]{key, id});
            heapifyUp(idx[id]);
        }
        
        public void remove(int id) {
            int idx_to_evict = idx[id];
            swapNode(idx_to_evict, nodes.size() - 1);
            idx[id] = -1;
            nodes.remove(nodes.size() - 1);
            heapifyDown(idx_to_evict);
        }
        
        public Boolean empty() {
            return nodes.isEmpty();
        }
        
        public int max() {
            return empty() ? 0 : nodes.get(0)[0];
        }
        
        private void heapifyUp(int i) {            
            while (i != 0) {            
                int p = (i - 1) / 2;
                if (nodes.get(i)[0] <= nodes.get(p)[0])
                    return;
                
                swapNode(i, p);
                i = p;
            }
        }
        
        private void swapNode(int i, int j) {
            int tmpIdx = idx[nodes.get(i)[1]];
            idx[nodes.get(i)[1]] = idx[nodes.get(j)[1]];
            idx[nodes.get(j)[1]] = tmpIdx;
 
            int[] tmpNode = nodes.get(i);
            nodes.set(i, nodes.get(j));
            nodes.set(j, tmpNode);
        }
        
        private void heapifyDown(int i) {
            while (true) {
                int c1 = i*2 + 1;
                int c2 = i*2 + 2;
 
                if (c1 >= nodes.size()) return;
 
                int c = (c2 < nodes.size() 
                      && nodes.get(c2)[0] > nodes.get(c1)[0]) ? c2 : c1;
                
                if (nodes.get(c)[0] <= nodes.get(i)[0])
                    return;
                
                swapNode(c, i);
                i = c;
            }
        }
        
    }
	public static void main(String[] args) {
		Solution131 solution131 = new Solution131();
		int[][] buidings = {{1,10,3},{2,5,8},{7,9,8}};//{{1,3,3},{2,4,4},{5,6,1}};
		Date date1 = new Date();
		List<List<Integer>> list = solution131.buildingOutline(buidings);
		Date date2 = new Date();
		System.out.println(date2.getTime()-date1.getTime());
		for(int i=0;i<list.size();i++) {
			for(int j=0;j<list.get(i).size();j++)
				System.out.print(list.get(i).get(j)+" ");
			System.out.println();
		}
	}
	
}
