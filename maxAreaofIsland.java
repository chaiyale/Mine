import java.util.LinkedList;
import java.util.Queue;


public class maxAreaofIsland 
{
    public static int maxAreaOfIsland(int[][] grid) 
    {
        int maxArea = 0;
        int row = grid.length;  //行
    	int col = grid[0].length;  //列
    	
    	int[][] visit = new int[row][col];  //访问过的置为1，为访问的置为0
    	for(int i=0; i<row; i++)
    	{
    		for(int j=0; j<col; j++)
    		{
    			visit[i][j] = 0;
    		}
    	}
    	
    	for(int i=0; i<row; i++)
    	{
    		for(int j=0; j<col; j++)
    		{
    			if(grid[i][j] == 1 && visit[i][j]==0)  //作为源头 未被访问过
    			{
    				int max = 0;
    				Queue<String> q  = new LinkedList<String>();
    				q.add(i+","+j);
    				while(!q.isEmpty())
    				{
    					String[] entry = q.poll().split(",");
    					int k = Integer.parseInt(entry[0]);
    					int v = Integer.parseInt(entry[1]);
    					if(visit[k][v]==1) continue;
    					max += 1;  
    					visit[k][v]=1;
    					if(k-1>-1 && grid[k-1][v]==1 && visit[k-1][v]==0) q.add((k-1)+","+v);
    					if(v-1>-1 && grid[k][v-1]==1 && visit[k][v-1]==0) q.add(k+","+(v-1));
    					if(k+1<row && grid[k+1][v]==1 && visit[k+1][v]==0) q.add((k+1)+","+v);
    					if(v+1<col && grid[k][v+1]==1 && visit[k][v+1]==0) q.add(k+","+(v+1));
    				}
    				if(maxArea < max) maxArea = max;
    			}
    		}
    	}
        
        return maxArea;
    }
    
	public static void main(String[] args)
	{
		int[][] grid = {{1,1,0,0,0},
				        {1,1,0,0,0},
				        {0,0,0,1,1},
				        {0,0,0,1,1}};
		System.out.println(maxAreaOfIsland(grid));
	}
}
