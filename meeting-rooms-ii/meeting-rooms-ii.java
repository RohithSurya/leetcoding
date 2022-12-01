class Solution {
    public int minMeetingRooms(int[][] intervals) {
        Arrays.sort(intervals, (a,b)->a[0]-b[0]);
        List<List<int[]>> lists = new ArrayList<>();
        boolean found=false;
        for(int[] interval: intervals) {
            int te = lists.size();
            for(int i=0; i<te; i++) {
                found=true;
                for(int[] t: lists.get(i)) {
                    if(((t[0]<=interval[0] && interval[0]<t[1]) || (t[0]<=interval[1] && interval[1]<t[1]))) {
                        found=false;
                        break;
                    }
                }
                if(found) {
                    lists.get(i).add(interval);
                    break;
                }
            }
            if(!found) {
                lists.add(new ArrayList<>());
                lists.get(lists.size()-1).add(interval);
            }
        }
        return lists.size();
    }
} 