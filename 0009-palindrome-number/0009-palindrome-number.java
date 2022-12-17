class Solution {
    public boolean isPalindrome(int x) {
        if(x<0) return false;
        StringBuilder sb = new StringBuilder();
        while(x!=0) {
            sb.append(x%10);
            x/=10;
        }
        int i=0, j=sb.length()-1;
        while(i<j) {
            if(sb.charAt(i++)!=sb.charAt(j--)) return false;
        }
        return true;
    }
}