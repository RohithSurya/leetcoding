class Solution {
    public int[] sortArrayByParity(int[] nums) {
        int n=nums.length;
        var result = new int[n];
        int i=0;
        int j=nums.length-1;
        for(var num: nums) {
            if(num%2==0) result[i++]=num;
            else result[j--]=num;
        }
        return result;
    }
}