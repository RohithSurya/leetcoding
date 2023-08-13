class Solution {
    public int searchInsert(int[] nums, int target) {
        int l=0, h=nums.length-1, ans=0, m=0;
        
        while(l<=h) {
            m=l+(h-l)/2;
            if(nums[m]==target) {
                return m;
            } else if(nums[m]<target) {
                l=m+1;
            } else {
                h=m-1;
            }
        }
        return l;
    }
}