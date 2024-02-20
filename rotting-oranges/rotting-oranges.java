class Solution {
    public int orangesRotting(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        Queue<int[]> q = new LinkedList<>();
        boolean noFresh = true;
        
        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                if(grid[i][j]==2) q.add(new int[]{i,j});
                if(grid[i][j]==1) noFresh=false;
            }
        }
        if(noFresh) return 0;
        var directions = new int[][]{{0,1}, {1,0}, {-1,0}, {0,-1}};
        int time=-1;
        
        while(!q.isEmpty()) {
            int size = q.size();
            
            for(int i=0; i<size; i++) {
                var cor = q.remove();
                for(var direction: directions) {
                    int x = cor[0]+direction[0];
                    int y = cor[1]+direction[1];
                    if(x>=0 && x<m && y>=0 && y<n && grid[x][y]==1) {
                        grid[x][y]=2;
                        q.add(new int[]{x,y});
                    }
                }
            }
            time++;
        }
        
        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                if(grid[i][j]==1) return -1;
            }
        }
        return time;
    }
}