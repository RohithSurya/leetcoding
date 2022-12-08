class Solution {
    public int lengthOfLongestSubstring(String s) {
        int count=0;
        int n=s.length();
        char ch;
        int start =0;
        int maxCount=0;
        Map<Character, Integer> hm = new HashMap<>();
        for(int i=0; i<n; i++) {
            ch=s.charAt(i);
            if(!hm.containsKey(ch) || start>hm.get(ch)) {
                hm.put(ch, i);
                count++;
                maxCount = Math.max(maxCount, count);
            } else {
                int t=hm.get(ch);
                count=i-t;
                start=t+1;
                hm.put(ch, i);
            }
        }
        return maxCount;
    }
}