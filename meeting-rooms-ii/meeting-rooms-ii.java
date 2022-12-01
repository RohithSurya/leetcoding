class Solution {
    public int minMeetingRooms(int[][] intervals) {
        Arrays.sort(intervals, (a,b)->a[0]-b[0]);
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int rooms=0;
        for(int[] interval: intervals) {
            if(pq.size()==0 || pq.peek()>interval[0]) {
                pq.offer(interval[1]);
                rooms++;
            } else {
                int top = pq.poll();
                pq.offer(interval[1]);
            }
        }
        return rooms;
    }
} 