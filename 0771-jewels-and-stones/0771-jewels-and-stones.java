class Solution {
    public int numJewelsInStones(String jewels, String stones) {
        HashSet<Character> hs = new HashSet<>();
        for(char ch: jewels.toCharArray())
            hs.add(ch);
        int count=0;
        for(char ch: stones.toCharArray()) {
            if(hs.contains(ch)) count++;
        }
        return count;
    }
}