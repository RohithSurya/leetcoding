class Solution {
    public int heightChecker(int[] heights) {
        var expHeights = heights.clone();
        var count=0;
        Arrays.sort(expHeights);
        for(int i=0; i<heights.length; i++) {
            if(expHeights[i]!=heights[i]) {
                count++;
            }
        }
        return count;
    }
}