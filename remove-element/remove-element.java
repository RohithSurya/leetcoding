class Solution {
    public int removeElement(int[] nums, int val) {
        int dups=0, deIndex=nums.length-1,t;
        for(int i=nums.length-1; i>=0; i--) {
            if(nums[i]==val) {
                swap(nums, i, deIndex);
                deIndex--;
                dups++;
            }
        }
        return nums.length-dups;
        
    }
    
    void swap(int[] nums, int m, int n) {
        int t;
        t=nums[m];
        nums[m]=nums[n];
        nums[n]=t;
    }
}