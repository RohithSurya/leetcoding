class Solution {
    

    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        int[] visited = new int[n];
        Queue<Integer> q = new LinkedList<>();
        int count=0, temp=0;
        for(int i=0; i<n; i++) {
            if(visited[i]==0) {
                visited[i]=1;
                count++;
                q.add(i);
                while(!q.isEmpty()) {
                    temp=q.remove();
                    visited[temp]=1;
                    for(int j=0; j<n; j++) {
                        if(isConnected[temp][j]==1 && visited[j]==0) {
                            q.add(j);
                        }
                    }
                }   
            }   
        }
        return count;
    }
} 