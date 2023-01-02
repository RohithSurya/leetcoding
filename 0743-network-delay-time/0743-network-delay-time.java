class Solution {
    Map<Integer, List<Pair<Integer, Integer>>> adj = new HashMap<>();
    
    
    public void dijtras(int[] sRecv, int k, int n) {
        Queue<Pair<Integer, Integer>> q = new PriorityQueue<>(Comparator.comparing(Pair::getKey));
        sRecv[k]=0;
        q.offer(new Pair(0, k));
        while(!q.isEmpty()) {
            Pair<Integer, Integer> tp = q.remove();
            int currNode = tp.getValue();
            int currNodeValue = tp.getKey();
            if(sRecv[currNode]<currNodeValue) continue;
            if(!adj.containsKey(currNode)) continue;
            
            for(var adjNodes: adj.get(currNode)) {
                int dest = adjNodes.getKey();
                int weight = adjNodes.getValue();
                if(currNodeValue+weight<sRecv[dest]) {
                    sRecv[dest] = weight+currNodeValue;
                    q.offer(new Pair(sRecv[dest], dest));
                }
            }
        }
        
        
    }
    public int networkDelayTime(int[][] times, int n, int k) {
        for(int[] time: times) {
            int start = time[0];
            int end = time[1];
            int weight = time[2];
            adj.putIfAbsent(start, new ArrayList<>());
            adj.get(start).add(new Pair(end, weight));
        }
        
        for(int node: adj.keySet()) {
            Collections.sort(adj.get(node), (a,b)->a.getKey()-b.getKey());
        }
        
        
        int[] sRecv = new int[n+1];
        Arrays.fill(sRecv, Integer.MAX_VALUE);
        dijtras(sRecv, k, n);
        int minTime = Integer.MIN_VALUE;
        for(int i=1; i<sRecv.length; i++) {
            minTime = Math.max(sRecv[i], minTime);
        }
        return minTime==Integer.MAX_VALUE ? -1 : minTime;
    }
}