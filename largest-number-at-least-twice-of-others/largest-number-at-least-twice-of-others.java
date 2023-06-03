class Solution {
    public int dominantIndex(int[] nums) {
        int max=0;
        for(int i=1; i< nums.length; i++) {
            if(nums[i]>nums[max])
                max=i;
        }
        int maxNumber = nums[max];
        for(int i=0; i< nums.length; i++) {
            if(i!=max && nums[max]<nums[i]*2) {
                return -1;
            }
        }
        return max;
    }
}