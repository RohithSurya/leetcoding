class Solution {
    public String longestCommonPrefix(String[] strs) {
        int i=0;
        boolean fullBreak=false;
        while(true) {
            char prev = 0;
            for(String str: strs) {
                if(i>=str.length()) {
                    return strs[0].substring(0,i);
                }
                if(prev==0) prev=str.charAt(i);
                else if(prev!=str.charAt(i)) {
                    return strs[0].substring(0,i);
                }
            }
            i++;
        }
    }
}