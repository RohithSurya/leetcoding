class Solution {
    
    int[] root;
    int[] rank;
    int components;
    
    public void initialize(int size) {
        root = new int[size];
        rank = new int[size];

        for(int i=0; i<root.length; i++) {
            root[i]=i;
            rank[i]=i;
        }
    }
    
    public int find(int x) {
        if(x==root[x]) return x;
        return root[x]=find(root[x]);
    }
    
    public void union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);

        if(rootX!=rootY) {
            if(rank[rootX]>rank[rootY]) {
                root[rootY]=rootX;
            } else if(rank[rootX]<rank[rootY]) {
                root[rootX]=rootY;
            } else {
                root[rootY]=rootX;
                rank[rootX]+=1;
            }
            components--;
        }
    }
    
    
    public int minCostConnectPoints(int[][] points) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((x,y)->x[2]-y[2]);
        int n = points.length;
        for(int i=0; i<n; i++) {
            for(int j=i+1; j<n; j++) {
                int[] px=points[i], py=points[j];
                var cost = Math.abs(px[0]-py[0])+Math.abs(px[1]-py[1]);
                pq.add(new int[]{i,j,cost});
            }
        }
        
        initialize(n);
        int totalCost = 0;
        
        while(!pq.isEmpty()) {
            var edge = pq.remove();
            int i=edge[0], j=edge[1], cost=edge[2];
            if(find(i)!=find(j)) {
                union(i,j);
                totalCost+=cost;
            }
        }
        return totalCost;
    }
}