class Solution {
    List<List<Integer>> rList = new ArrayList<>();
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        var dest = graph.length-1;
        Set<Integer> visited = new HashSet<>();
        Queue<List<Integer>> q = new LinkedList<>();
        q.add(Arrays.asList(0));
        while(!q.isEmpty()) {
            var path = q.remove();
            var element = path.get(path.size()-1);
            if(element==dest) rList.add(path);
            visited.add(element);
                for(var el: graph[element]) {
                    // if(!visited.contains(el)) {
                        var nPath = new ArrayList<Integer>(path);
                        nPath.add(el);
                        q.add(nPath);
                    }
                // }
        }
        return rList;
    }
    
    
}