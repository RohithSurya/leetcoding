class Solution {
    public int[] kWeakestRows(int[][] mat, int k) {
        int m, n;
        m = mat.length;
        n = mat[0].length;
        int sum;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->a[0]-b[0]==0 ? b[1]-a[1] : b[0]-a[0]);
        for(int i=0; i<m; i++) {
            pq.add(new int[]{noOfOnes(mat, i),i});
            if(pq.size()>k)
                pq.poll();
        }
        int[] res = new int[k];
        for(int i=k-1; i>=0; i--) {
            int[] kd = pq.poll();
            res[i]=kd[1];
        }
        return res;
    }
    
    
    int noOfOnes(int[][] mat, int row) {
        int[] matRow = mat[row];
        int low=0, high = matRow.length, mid=0;
        while(low<high) {
            mid=low+(high-low)/2;
            if(matRow[mid]==0) {
                high=mid;
            } else {
                low = mid+1;
            }
        }
        return low;
    }
}