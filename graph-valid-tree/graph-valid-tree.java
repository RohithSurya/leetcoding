class Solution {
    
    int[] root;
    int[] rank;
    
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
        }
    }
    
    public boolean isConnected(int x, int y) {
        return find(x) == find(y);
    }
    
    
    public boolean validTree(int n, int[][] edges) {
        initialize(n);
        int components=n;
        for(var edge: edges) {
            int x = edge[0],y = edge[1];
            System.out.println(find(x) + " "+find(y));
            if(isConnected(x, y)) {
                return false;
            }
            union(x,y);
            components--;
        }
        // System.out.println(components);
        if(components==1) return true;
        return false;
    }
}