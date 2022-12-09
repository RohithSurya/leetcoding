class Solution {
    public int pivotIndex(int[] nums) {
        int rsum =0;
        int n = nums.length;
        for(int i=0; i<n; i++) {
            rsum+=nums[i];
        }
        // if(rsum==0) return 0;
        int lsum=0;
        
        for(int i=0; i<n; i++) {
            if(i!=0)
                lsum+=nums[i-1];
            rsum-=nums[i];
            if(lsum==rsum) return i;
            // System.out.println(lsum+" "+rsum);
        }
        return -1;
    }
}