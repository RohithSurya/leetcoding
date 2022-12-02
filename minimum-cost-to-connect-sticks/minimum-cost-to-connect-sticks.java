class Solution {
    public int connectSticks(int[] sticks) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int stick: sticks) pq.offer(stick);
        int totalSum=0;
        while(pq.size()>1) {
            int sum = pq.poll()+pq.poll();
            totalSum+=sum;
            pq.offer(sum);
        }
        return totalSum;
    }
}