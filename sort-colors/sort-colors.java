class Solution {
    public void sortColors(int[] nums) {
        int[] count = new int[4];
        for(var num: nums) {
            count[num+1]++;
        }
        count[2]+=count[1];
        count[3]+=count[2];
        for(int i=0; i<3; i++) {
            for (int j=count[i]; j<count[i+1];j++) {
                nums[j]=i;
            }
        }
    }
}