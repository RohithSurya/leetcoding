class Solution {
    public int threeSumSmaller(int[] nums, int target) {
        Arrays.sort(nums);
        int n=nums.length;
        int sum=0;
        for(int i=0; i<n; i++) {
            sum+=twoSum(nums, i, target);
        }
        return sum;
    }
    public int twoSum(int[] nums, int i, int target) {
        int low= i+1;
        int high = nums.length-1;
        int total = 0;
        while(low<high) {
            int sum = nums[i]+nums[low]+nums[high];
            if(sum>=target) {
                high--;
            } else {
                total+=(high-low);
                low++;
            }
        }
        return total;
    }
}