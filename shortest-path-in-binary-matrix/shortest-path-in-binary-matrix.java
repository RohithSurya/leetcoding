class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{0,0,1});
        int m = grid.length;
        int n = grid[0].length;
        if(grid[0][0]==1) return -1;
        
        int[][] visited = new int[m][n];
        
        var directions = new int[][]{{0,1},{1,0},{1,1}, {0,-1}, {-1,0}, {-1,-1}, {1,-1}, {-1,1}};
        
        while(!q.isEmpty()) {
            int[] cNode = q.remove();
            int x = cNode[0];
            int y = cNode[1];
            int distance = cNode[2];
            if(visited[x][y]==1) continue; 
            visited[x][y]=1;
            if(x == m-1 && y== n-1) return distance;
            for(var direction: directions) {
                int i = x+direction[0];
                int j = y+direction[1];
                if(i>=0 && i<m && j>=0 && j<n && grid[i][j]==0 && visited[i][j]==0) {
                    q.add(new int[]{i,j,distance+1});
                }
            }
        }
        return -1;
    }
}