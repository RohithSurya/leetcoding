class Solution {
    public int minimumSemesters(int n, int[][] relations) {
        Map<Integer, Set<Integer>> al = new HashMap<>();
        int[] inbounds = new int[n+1];
        int steps=0;
        int tnodes = 0;
        Queue<Integer> q = new LinkedList<>();
        for(int i=1; i<=n; i++) {
            al.put(i, new HashSet<>());
        }
        for(int i=0; i<relations.length; i++) {
            al.get(relations[i][0]).add(relations[i][1]);
            inbounds[relations[i][1]]++;
        }
        for(int i=1; i<=n; i++) {
            if(inbounds[i]==0) q.add(i);
        }
        while(!q.isEmpty()) {
            int qsize = q.size();
            tnodes+=qsize;
            steps++;
            for(int i=0; i<qsize; i++) {
                int el = q.remove();
                for(int neighbour: al.get(el)) {
                    inbounds[neighbour]--;
                    if(inbounds[neighbour]==0) q.add(neighbour);   
                }
            }
        }
        return tnodes==n ? steps : -1;
    }
}