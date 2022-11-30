class Solution {
    
    class Element {
        int v;
        int r;
        int c;
        
        public Element(int v, int r, int c) {
            this.v=v;
            this.r=r;
            this.c=c;
        }
    }
    
    public int kthSmallest(int[][] matrix, int k) {
        PriorityQueue<Element> pq = new PriorityQueue<>((a,b)->a.v-b.v);
        int n = matrix.length;
        for(int i=0; i<Math.min(n,k);i++) {
            pq.offer(new Element(matrix[i][0], i, 0));
        }
        Element curr=null;
        int r,c,v;
        while(k-->0) {
            curr=pq.poll();
            if(curr.c+1<n) {
                pq.offer(new Element(matrix[curr.r][curr.c+1], curr.r, curr.c+1));
            }
        }
        return curr.v;
    }
}