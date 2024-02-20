class Solution {
    
    public int minCostConnectPoints(int[][] points) {
        int n = points.length;
        PriorityQueue<int[]> pq = new PriorityQueue<>((x,y)->x[2]-y[2]);
        var start = points[0];
        for(int i=1; i<n; i++) {
            var point = points[i];
            var cost = Math.abs(start[0]-point[0])+Math.abs(start[1]-point[1]);
            pq.add(new int[]{0,i,cost});
        }
        
        var visited = new int[n];
        visited[0]=1;
        var totalCost = 0;
        
        while(!pq.isEmpty()) {
            var edge = pq.remove();
            var j = edge[1];
            if(visited[j]==0) {
                visited[j]=1;
                totalCost+=edge[2];
                var curr = points[j];
                for(int i=0; i<n; i++) {
                    if(visited[i]==0) {
                        var temp = points[i];
                        var cost = Math.abs(temp[0]-curr[0])+Math.abs(temp[1]-curr[1]);
                        pq.add(new int[]{j,i,cost});
                    }
                }
            }
        }
        
        return totalCost;
    }
}