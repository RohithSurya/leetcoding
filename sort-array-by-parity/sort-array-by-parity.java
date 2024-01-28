class Solution {
    public int[] sortArrayByParity(int[] nums) {
        int evenIndex=0;
        int temp;
        for(int i=0; i<nums.length; i++) {
            if(nums[i]%2==0) {
                temp=nums[i];
                nums[i]=nums[evenIndex];
                nums[evenIndex]=temp;
                evenIndex++;
            }
        }
        return nums;
    }
}