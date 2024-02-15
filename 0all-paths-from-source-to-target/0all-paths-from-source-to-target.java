class Solution {
    List<List<Integer>> rList = new ArrayList<>();
    List<List<Integer>> adjList = new ArrayList<>();
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        dfs(graph, 0, graph.length-1, new ArrayList<>());
        return rList;
    }
    
    void dfs(int[][] graph, int source, int destination, ArrayList<Integer> cl) {
        cl.add(source);
        if(source==destination) 
            rList.add(new ArrayList<>(cl));
        else {
            for(var edge: graph[source]) {
                dfs(graph, edge, destination, cl);
            }
        }
        cl.remove(cl.size()-1);
    }
    
}