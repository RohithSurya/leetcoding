class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)-> (b[0]*b[0]+b[1]*b[1])-(a[0]*a[0]+a[1]*a[1]));
        for(int[] point: points) {
            pq.offer(point);
            if(pq.size()>k) pq.poll();
        }
        int size = pq.size();
        int[][] result = new int[pq.size()][2];
        for(int i=0; i<size; i++) {
            result[i]=pq.poll();
        }
        return result;
    }
}