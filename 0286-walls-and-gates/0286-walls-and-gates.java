class Solution {
    Queue<int[]> q= new LinkedList<>();
    public void wallsAndGates(int[][] rooms) {
        int m = rooms.length;
        int n = rooms[0].length;
        int[][] visited = new int[m][n];
        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                if(rooms[i][j]==0) {
                    q.add(new int[]{i,j});
                    visited[i][j]=1;
                }
            }
        }
        bfs(rooms, visited, m, n);
    }
    
    void clearVisited(int[][] visited, int m, int n) {
        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                visited[i][j]=0;
            }
        }
    }
    
    void bfs(int[][] rooms, int[][] visited, int m, int n) {
        int steps=0;
        int x, y, qsize, nx, ny;
        int [][] changes = {{0,1}, {0,-1}, {1,0}, {-1,0}};
        
        while(!q.isEmpty()) {
            qsize = q.size();
            for(int i=0; i<qsize; i++) {
                int[] point = q.poll();
                x = point[0];
                y=point[1];
                
                rooms[x][y]=steps; 
                for(int[] c: changes) {
                    nx=x+c[0];
                    ny=y+c[1];
                    if(nx>=0 && ny>=0 && nx<m && ny<n && visited[nx][ny]!=1 && rooms[nx][ny]>0) {
                        q.offer(new int[]{nx, ny});
                        visited[nx][ny]=1;
                    }
                }
            }
            steps++;
        }
    }
    
    
}