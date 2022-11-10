class Solution {
    public String alienOrder(String[] words) {
        Map<Integer, Set<Integer>> adjList = new HashMap<>();
        if(words.length==1) {
            String ste = words[0];
            char[] cAr = ste.toCharArray();
            Arrays.sort(cAr);
            StringBuilder sb = new StringBuilder();
            char prev='$';
            for(char c: cAr) {
                if(prev==c) continue;
                sb.append(c);
                prev=c;
            }
            
            return sb.toString();
        }
        int n=words.length;
        String f=null, s=null;
        boolean notFound=true;
        int cf, cs;
        for(int i=0; i<n-1; i++) {
            for(int j=i+1; j<n; j++) {
                f=words[i];
                s=words[j];
                int k=0, t=0;
                while(k<f.length() && k<s.length()) {
                    int f1 = f.charAt(k)-'a';
                    int s1 = s.charAt(k)-'a';
                    adjList.putIfAbsent(f1, new HashSet<>());
                    adjList.putIfAbsent(s1, new HashSet<>());
                    if(f1!=s1) {
                        adjList.get(f1).add(s1);
                        k++;
                        notFound=false;
                        break;
                    }
                    k++;
                }
                if(notFound==true && k==Math.min(f.length(), s.length()) && f.length()>s.length()) return "";
                t=k;
                while(t<f.length()) {
                    adjList.putIfAbsent(f.charAt(t)-'a', new HashSet<>());
                    t++;
                }
                t=k;
                while(t<s.length()) {
                    adjList.putIfAbsent(s.charAt(t)-'a', new HashSet<>());
                    t++;
                }
                
            }
        }
        
        Queue<Integer> q = new LinkedList<>();
        StringBuilder sb = new StringBuilder();
        int[] inbounds = new int[26];
        for(int i=0; i<inbounds.length; i++) {
            inbounds[i]=-1;
        }
        for(Integer f1: adjList.keySet()) {
            if(inbounds[f1]==-1) inbounds[f1]=0;
            for(Integer s1: adjList.get(f1)) {
                if(inbounds[s1]==-1) inbounds[s1]=0;
                inbounds[s1]++;
            }
        }
        
        for(int i=0; i<inbounds.length; i++) {
            if(inbounds[i]==0) q.add(i);
        }
        
        
        int count=0,curr=0;
        
        while(count<adjList.size()) {
            if(q.isEmpty()) break;
            curr=q.remove();
            for(int x: adjList.get(curr)) {
                inbounds[x]--;
                if(inbounds[x]==0) {
                    q.add(x);
                }
            }
            sb.append((char)(curr+'a'));
            count++;
        }
        if(count==adjList.size()) return sb.toString();
        return "";
    }
}