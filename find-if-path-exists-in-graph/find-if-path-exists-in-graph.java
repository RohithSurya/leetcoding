class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        Set<Integer> hs = new HashSet<>();
        List<List<Integer>> adjList = new ArrayList<>();
        for(int i=0; i<n; i++)
            adjList.add(new ArrayList<>());
        for(int[] edge: edges) {
            var f = edge[0];
            var s = edge[1];
            adjList.get(f).add(s);
            adjList.get(s).add(f);
        }
        
        Queue<Integer> q = new LinkedList<>();
        
        q.add(source);
        
        while(!q.isEmpty()) {
            var element = q.remove();
            if(element==destination) return true;
            if(!hs.contains(element)) {
                hs.add(element);
                for(var elt: adjList.get(element)) {
                    if(!hs.contains(elt)) q.add(elt);
                }
            }
        }
        return false;
        
    }
}