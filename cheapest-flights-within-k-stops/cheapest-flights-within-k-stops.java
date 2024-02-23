class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        int[] weights = new int[n];
        Arrays.fill(weights, Integer.MAX_VALUE);
        weights[src]=0;
        for(int i=0; i<=k; i++) {
            int[] newWeights=Arrays.copyOf(weights, n);
            for(var flight: flights) {
                int u = flight[0], v=flight[1], w=flight[2];
                if(weights[u]!=Integer.MAX_VALUE) {
                    if(newWeights[v]>weights[u]+w) {
                        newWeights[v]=weights[u]+w;
                    }
                }
            }
            weights=newWeights;
        }
        return weights[dst]==Integer.MAX_VALUE ? -1: weights[dst];
    }
}