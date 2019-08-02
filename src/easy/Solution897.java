package easy;

public class Solution897 {
	boolean flag = false;
	public int numIslandCities(int[][] grid) {
		int count = 0;
		for(int i=0;i<grid.length;i++) {
			for(int j=0;j<grid[i].length;j++) {
				if(grid[i][j] != 0) {
					flag = false;
					if(searchCity(grid, i, j))
						count++;
				}
			}
		}
		
        return count;
    }
	public static void main(String[] args) {
		int[][] grid = {{1,2},
						{2,0}};
		System.out.println(new Solution897().numIslandCities(grid));
	}
	public boolean searchCity(int[][] grid,int i,int j) {
		if(grid[i][j] == 1) {
			grid[i][j] = 0;
		}else {
			delIsland(grid, i, j);
			flag = true;
		}
			
		if(i-1>=0 && grid[i-1][j]!=0)
			searchCity(grid, i-1, j);
		if(i+1<grid.length && grid[i+1][j]!=0)
			searchCity(grid, i+1, j);
		if(j-1>=0 && grid[i][j-1]!=0)
			searchCity(grid, i, j-1);
		if(j+1<grid[i].length && grid[i][j+1]!=0)
			searchCity(grid, i, j+1);
		return flag;
	}
	public void delIsland(int[][] grid,int i,int j) {
		grid[i][j] = 0;
		
		if(i-1>=0 && grid[i-1][j]!=0)
			delIsland(grid, i-1, j);
		if(i+1<grid.length && grid[i+1][j]!=0)
			delIsland(grid, i+1, j);
		if(j-1>=0 && grid[i][j-1]!=0)
			delIsland(grid, i, j-1);
		if(j+1<grid[i].length && grid[i][j+1]!=0)
			delIsland(grid, i, j+1);
	}
}
