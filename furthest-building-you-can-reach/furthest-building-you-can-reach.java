class Solution {
    public int furthestBuilding(int[] heights, int bricks, int ladders) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int i=1;
        int jump;
        for(i=1; i<heights.length; i++) {
            jump=heights[i]-heights[i-1];
            if(jump<=0) continue;
            pq.offer(jump);
            if(pq.size()>ladders) {
                int least = pq.poll();
                if(least>bricks) {
                    System.out.println(i);
                    break;
                }
                bricks-=least;
            }
        }
        return i-1;
    }
}