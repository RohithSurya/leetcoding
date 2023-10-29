class Solution {
    public boolean checkIfExist(int[] arr) {
        var hs = new HashSet<Integer>();
        for(var num: arr) {
            if(hs.contains(num*2)) return true;
            if(num%2==0 && hs.contains(num/2)) return true;
            hs.add(num);
        }
        return false;
    }
}