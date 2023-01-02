class Solution {
    public boolean containsDuplicate(int[] nums) {
        var hm = new HashSet<Integer>();
        for(var num: nums) {
            if(hm.contains(num)) return true;
            hm.add(num);
        }
        return false;
    }
}