class Solution {
    public int[] sortArrayByParity(int[] nums) {
        var res = new int[nums.length];
        int i=0, j=nums.length-1;
        for(var num: nums) {
            if(num%2==0) {
                res[i++]=num;
            } else {
                res[j--]=num;
            }
        }
        return res;
    }
}