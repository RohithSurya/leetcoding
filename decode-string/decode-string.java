class Solution {
    public String decodeString(String s) {
        return decodeHelper(1, s, 0, s.length()-1).toString();
    }
    
    StringBuilder decodeHelper(int t, String s, int start, int end) {
        StringBuilder sb = new StringBuilder();
        int i=start, newi, m, times;
        while(i<=end) {
            if(s.charAt(i)>='0' && s.charAt(i)<='9') {
                m =  parseInteger(i, s);
                times = Integer.parseInt(s.substring(i, m));
                newi = getEnd(m+1, s);
                sb.append(decodeHelper(times, s,  m+1, newi));
                i=newi+2;
            } else {
                sb.append(s.charAt(i));
                i++;
            }
        }
        String temp = sb.toString();
        
        for(int j=0;j<t-1;j++)
            sb.append(temp);
        
        return sb;
    }
    
    int getEnd(int i, String s) {
        int cnt=1;
        while(cnt>0) {
            if(s.charAt(i)=='[') cnt++;
            else if(s.charAt(i)==']') cnt--;
            i++;
        }
        return i-2;
    }
    
    int parseInteger(int i, String s) {
        while(true) {
            if(s.charAt(i)>='0' && s.charAt(i)<='9')
                i++;
            else
                break;
        }
        return i;
    }
}