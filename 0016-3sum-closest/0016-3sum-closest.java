class Solution {
    public int threeSumClosest(int[] a, int target) {
        Arrays.sort(a);
        int n=a.length;
        int csum=9999999;
        for(int i=0; i<n-1; i++) {
            int temp = twoSum(a, i, target);
            if(Math.abs(temp-target)<Math.abs(csum-target)) {
                csum=temp;
            }
        }
        return csum;
    }
    
    public int twoSum(int[] a, int index, int target) {
        int gsum=9999999;
        for(int i=index+1; i<a.length; i++) {
            int temp = target - (a[index]+a[i]);
            int fIndex = binarySearchGreaterOrEqual(a, temp, i);
            int fsum=0, rsum=0;
            if(fIndex<a.length) {
                if(temp==a[fIndex]) return target;
                fsum = a[index]+a[i]+a[fIndex];
                gsum = Math.abs(gsum-target) > Math.abs(fsum-target) ? fsum: gsum;
            }
            int rIndex = binarySearchLessOrEqual(a,temp, i);
            if(rIndex>i) {
                if(temp==a[rIndex]) return target;
                rsum = a[index]+a[i]+a[rIndex];
                gsum = Math.abs(gsum-target) > Math.abs(rsum-target)  ? rsum: gsum;
            }
        }
        return gsum;
    } 
    
    public int binarySearchGreaterOrEqual(int[] a, int target, int start) {
        int n = a.length;
        int low=start+1;
        int high=n-1;
        int mid;
        while(low<high) {
            mid=(low+high)/2;
            if(a[mid]<target)
                low=mid+1;
            else
                high=mid;
        }
        return low;
    }

    public int binarySearchLessOrEqual(int[] a, int target, int start) {
        int n = a.length;
        int low=start+1;
        int high=n-1;
        int mid;
        while(low<=high) {
            mid=(low+high)/2;
            if(a[mid]>target) {
                high=mid-1;
            } else
                low=mid+1;
        }
        return high;
    }
}