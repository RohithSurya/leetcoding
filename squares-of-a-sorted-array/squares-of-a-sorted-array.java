class Solution {
    public int[] sortedSquares(int[] nums) {
        int negIndex=0, posIndex;
        int[] ssquare = new int[nums.length];
        for(int i=0;i<nums.length; i++) {
            if(nums[i]<0) negIndex=i;
            nums[i]=nums[i]*nums[i];
        }
        int j=0;
        posIndex=negIndex+1;
        while(negIndex>=0 && posIndex<nums.length) {
            if(nums[negIndex]<nums[posIndex]) {
                ssquare[j++]=nums[negIndex--];
            } else {
                ssquare[j++]=nums[posIndex++];
            }
        }
        while(negIndex>=0) {
            ssquare[j++]=nums[negIndex--];
        }
        while(posIndex<nums.length) {
            ssquare[j++]=nums[posIndex++];
        }
        
        return ssquare;
    }
}