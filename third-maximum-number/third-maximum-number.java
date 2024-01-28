class Solution {
    public int thirdMax(int[] nums) {
        Queue<Integer> q = new PriorityQueue<>();
        Set<Integer> hs = new HashSet<>();
        int max=Integer.MIN_VALUE;
        for(int num: nums) {
            if(hs.contains(num)) continue;
            q.add(num);
            if(q.size()>3) q.poll();
            if(num>max) max=num;
            hs.add(num);
        }
        
        if(q.size()<3) return max;
        return q.peek();
        
    }
}