class Solution {
    public int findNumbers(int[] nums) {
        int temp, cnt=0, numOfDigits;
        for(int num: nums) {
            temp=num;
            numOfDigits=0;
            while(temp>0) {
                temp/=10;
                numOfDigits++;
            }
            if (numOfDigits%2==0) cnt++;
        }
        return cnt;
    }
}