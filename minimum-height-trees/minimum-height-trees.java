class Solution {
    
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        if(n<2) {
            return Arrays.asList(0);
        }
        List<Set<Integer>> al = new ArrayList<>();
        Queue<Integer> q = new LinkedList<>();
        for(int i=0; i<n; i++)
            al.add(new HashSet<>());
        for(int i=0; i<edges.length; i++) {
            int[] edge = edges[i];
            int f=edge[0], s=edge[1];
            al.get(f).add(s);
            al.get(s).add(f);
        }
        
        for(int i=0; i<n; i++) {
            if(al.get(i).size()==1) q.add(i);
        }
        
        int remNodes = n;
        Integer temp, qsize, neighbour;
        
        while(remNodes>2) {
            remNodes-=q.size();
            qsize = q.size();
            for(int i=0; i<qsize; i++) {
                temp = q.remove();
                neighbour = al.get(temp).iterator().next();
                al.get(neighbour).remove(temp);
                if(al.get(neighbour).size()==1) q.add(neighbour);
            }
        }
        
        return new ArrayList<>(q);
        
    }
}