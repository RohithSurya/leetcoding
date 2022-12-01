class Solution {
    public int minMeetingRooms(int[][] intervals) {
        int n=intervals.length;
        int[] starts = new int[n];
        int[] ends = new int[n];
        for(int i=0; i<n; i++) {
            starts[i]=intervals[i][0];
            ends[i]=intervals[i][1];
        }
        Arrays.sort(starts);
        Arrays.sort(ends);
        int rooms=0;
        int sptr=0, eptr=0;
        while(sptr<n) {
            if(starts[sptr]>=ends[eptr]) {
                eptr++;
            } else rooms++;
            sptr++;
        }
        return rooms;
    }
} 