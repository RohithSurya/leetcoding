class Solution {
    public int threeSumClosest(int[] a, int target) {
       int diff = Integer.MAX_VALUE;
        int n = a.length;
        Arrays.sort(a);
        for(int i=0; i<n && diff!=0; i++) {
            int low=i+1;
            int high=n-1;
            while(low<high) {
                int sum = a[i]+a[low]+a[high];
                if(Math.abs(sum-target)<Math.abs(diff))
                    diff=target-sum;
                if(sum<target) low++;
                else high--;
            }
        }
        return target-diff;
    }
    
    
}