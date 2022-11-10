class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int n = rooms.size();
        boolean[] visited = new boolean[n];
        exploreRoom(rooms, 0, visited);
        for(boolean r: visited) {
            if(!r)
                return false;
        }
        return true;
    }
    
    void exploreRoom(List<List<Integer>> rooms, int i, boolean[] visited) {
        visited[i]=true;
        for(int r: rooms.get(i)) {
            if(!visited[r])
                exploreRoom(rooms, r, visited);
        }
    }
}