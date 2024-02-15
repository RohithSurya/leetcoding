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
        
        Stack<Integer> st = new Stack<Integer>();
        st.push(source);
        while(!st.empty()) {
            var vert = st.pop();
            if(vert==destination) return true;
            if(hs.contains(vert)) continue;
            hs.add(vert);
            for(var edge: adjList.get(vert)) {
                if(!hs.contains(edge)) {
                    st.push(edge);
                }
            }
        }
        return false;
        
    }
}