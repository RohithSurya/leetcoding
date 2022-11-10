class Solution {
    
    
    public int[] topKFrequent(int[] nums, int k) {
        if(k==nums.length) return nums;
        int[] res = new int[k];
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0;i<nums.length;i++)
            map.put(nums[i], map.getOrDefault(nums[i],0)+1);
        
        PriorityQueue<Integer> pq = new PriorityQueue<>((x,y)->map.get(x)-map.get(y));
        for(int x: map.keySet()) {
            pq.add(x);
            if(pq.size()>k) pq.poll();
        }
        for(int i=0; i<k; i++) {
            res[i]=pq.poll();
        }
        return res;
    }
}