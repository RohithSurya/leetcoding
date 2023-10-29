class Solution {
    public int heightChecker(int[] heights) {
        var expectedHeights = heights.clone();
        int cnt=0;
        Arrays.sort(expectedHeights);
        for(int i=0; i<heights.length; i++) {
            if(expectedHeights[i]!=heights[i]) cnt++;
        }
        return cnt;
    }
}