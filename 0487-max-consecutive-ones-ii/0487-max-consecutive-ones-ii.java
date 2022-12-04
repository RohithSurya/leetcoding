class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int start=0, count=0, prev=0;
        for(int i=0; i<nums.length; i++) {
            if(nums[i]==1) {
                if(prev==0) start=i;
                count++;
            } else if(nums[i]==0) {
                if(prev==1) {
                    nums[start]=count;
                    nums[i-1]=count;
                    count=0;
                }
            }
            prev=nums[i];
        }
        if(nums[nums.length-1]==1) {
            nums[start]=count;
            nums[nums.length-1]=count;
        }
        
        int maxOnes=0;
        for(int i=0; i<nums.length; i++) {
            if(nums[i]>=1) maxOnes = Math.max(maxOnes, nums[i]);
            if(nums[i]==0) {
                count=1;
                if(i>0) count+=nums[i-1];
                if(i<nums.length-1) count+=nums[i+1];
                maxOnes = Math.max(count, maxOnes);
            }
        }
        return maxOnes;
        
    }
}