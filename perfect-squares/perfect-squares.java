class Solution {
    public int numSquares(int n) {
        int[] a = new int[n+1];
        a[0]=0;
        a[1]=1;
        for(int i=2;i<=n;i++) {
            int sqrt = (int) Math.sqrt(i);
            if(i==sqrt*sqrt) {
                a[i]=1;
                continue;
            }
            int ans =i;
            for(int j=2;j*j<=i;j++) {
                ans = Math.min(ans, 1+a[i-j*j]);
            }
            a[i]=ans;
        }
        return a[n];
    }
}