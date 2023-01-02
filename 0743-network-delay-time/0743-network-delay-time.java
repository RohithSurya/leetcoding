class Solution {
    Map<Integer, List<Pair<Integer, Integer>>> adj = new HashMap<>();
    
    
    public void dfs(int[] sRecv, int k, int time) {
        if(time>=sRecv[k]) {
            return;
        }
        sRecv[k]=time;
        
        if(!adj.containsKey(k)) return;
        for(var pa: adj.get(k)) {
            var dest = pa.getKey();
            var weight = pa.getValue();
            dfs(sRecv, dest, time+weight);
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
        dfs(sRecv, k, 0);
        int minTime = Integer.MIN_VALUE;
        for(int i=1; i<sRecv.length; i++) {
            minTime = Math.max(sRecv[i], minTime);
        }
        return minTime==Integer.MAX_VALUE ? -1 : minTime;
    }
}