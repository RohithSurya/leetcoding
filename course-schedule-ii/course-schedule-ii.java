class Solution {
    boolean possible=true;
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] visited = new int[numCourses];
        int[] result = new int[numCourses];
        int[] temp;
        List<List<Integer>> al = new LinkedList<>();
        for(int i=0; i<numCourses; i++)
            al.add(new ArrayList<>());
        for(int i=0; i<prerequisites.length; i++) {
            temp=prerequisites[i];
            al.get(temp[1]).add(temp[0]);
        }
        Stack<Integer> st = new Stack<>();
        for(int i=0; i<numCourses; i++) {
            if(visited[i]==0)
                dfs(al, visited, i, st);   
        }
        if(!possible) return new int[0];
        for(int i=0; i<numCourses; i++) {
            result[i]=st.pop();
        }
        return result;
        
    }
    
    void dfs(List<List<Integer>> al, int[] visited, int curr, Stack<Integer> st) {
        if(!possible) return;
        visited[curr]=1;
        for(int x: al.get(curr)) {
            if(visited[x]==0)
            dfs(al, visited, x, st);
            else if(visited[x]==1) {
                possible=false;
                return;
            }
        }
        visited[curr]=2;
        st.push(curr);
        
    }
}