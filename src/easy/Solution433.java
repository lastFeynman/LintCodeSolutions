package easy;
public class Solution433 {
	public int numIslands(boolean[][] grid) {
        int count = 0;
        for(int i=0;i<grid.length;i++) {
        	for(int j=0;j<grid[i].length;j++) {
        		if(grid[i][j]) {
        			count++;
        			findIsland(grid,i,j);
        		}
        	}
        }
        return count;
    }
	public static void main(String[] args) {
		boolean[][] grid = {{true,true,false,false,false},
							{false,true,false,false,true},
							{false,false,false,true,true},
							{false,false,false,false,false},
							{false,false,false,false,true}};
		System.out.println(new Solution433().numIslands(grid));
	}
	public void findIsland(boolean[][] grid,int i,int j) {
		
		grid[i][j] = false;
		
		if(i-1>=0 && grid[i-1][j])
			findIsland(grid, i-1, j);
		if(i+1<grid.length && grid[i+1][j])
			findIsland(grid, i+1, j);
		if(j-1>=0 && grid[i][j-1])
			findIsland(grid, i, j-1);
		if(j+1<grid[i].length && grid[i][j+1])
			findIsland(grid, i, j+1);
	}
}
