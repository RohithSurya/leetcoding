class Solution {
    public int[][] kClosest(int[][] points, int k) {
        HashMap<int[], Integer> hm = new HashMap<>();
        for(int[] point: points) {
            hm.put(point, point[0]*point[0]+point[1]*point[1]);
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)-> (hm.get(b)-hm.get(a)));
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