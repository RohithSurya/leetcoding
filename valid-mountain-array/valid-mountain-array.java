class Solution {
    public boolean validMountainArray(int[] a) {
        int i=1;
        // if(a.length<3) return false;
        while(i<a.length && a[i]>a[i-1])
            i++;
        if(i==a.length || i==1) return false;
        
        while(i<a.length && a[i]<a[i-1])
            i++;
        return i==a.length;
    }
}