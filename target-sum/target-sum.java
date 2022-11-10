class Solution {
    int total;
    public int findTargetSumWays(int[] nums, int target) {
        total = Arrays.stream(nums).sum();
        int[][] memo = new int[nums.length][2*total+1];
        for(int[] row: memo) {
            Arrays.fill(row, Integer.MIN_VALUE);
        }
        return findTargetSum(nums, 0, 0, target, memo);
    }
    public int findTargetSum(int[] a, int i, int sum, int targetSum, int[][] memo) {
        if(i==a.length)
            return (targetSum==sum)? 1: 0;
        else {
            if(memo[i][total+sum]!=Integer.MIN_VALUE) 
                return memo[i][total+sum];
            int add = findTargetSum(a, i+1, sum+a[i], targetSum, memo);
            int sub = findTargetSum(a,i+1, sum-a[i], targetSum, memo);
            memo[i][sum+total] = add+sub;
            return memo[i][sum+total]; 
        }  
        

    }
}