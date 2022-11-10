class Solution {
    public void moveZeroes(int[] a) {
        int n=a.length, sp=0;
        for(int fp=0; fp<n; fp++) {
            if(a[fp]!=0) {
                a[sp++]=a[fp];
            }
        }
        while(sp<n) {
            a[sp++]=0;
        }
    }
}