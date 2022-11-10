class Solution {
    
    public int climbStairs(int n) {
        int[] m = new int[n+1];
        // Arrays.fill(m, -1);
        return helperClimb(m, n);
    }
    
    public int helperClimb(int[] m, int n) {
        if(n==0) return 1;
        else if (n<0) return 0;
        else if(m[n]!=0) return m[n];
        else {
            m[n]=helperClimb(m, n-1)+helperClimb(m, n-2);
            return m[n];
        }
    }
}