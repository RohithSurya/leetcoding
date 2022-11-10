class Solution {
    public int[] replaceElements(int[] a) {
        int max=-1, x;
        for(int i=a.length-1; i>=0; i--) {
            x=a[i];
            a[i]=max;
            max=Math.max(max,x);
        }
        return a;
    }
}