class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        var hs = new HashSet<Integer>();
        var stack = new Stack<Integer>();
        stack.add(0);
        while(!stack.empty()) {
            var roomNumber = stack.pop();
            hs.add(roomNumber);
            var room = rooms.get(roomNumber);
            for(var key: room) {
                if(!hs.contains(key)) stack.add(key);
            }
        }
        return hs.size()==rooms.size();
    }
    
}