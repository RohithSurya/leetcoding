class Solution {
    public int openLock(String[] deadends, String target) {
        Queue<String> q = new LinkedList<>();
        Queue<String> q2 = new LinkedList<>();
        Queue<String> temp;
        String curr=null;
        boolean found=false;
        int steps=0;
        Set<String> visited = new HashSet<>();
        for(String deadEnd: deadends) {
            visited.add(deadEnd);
        }
        q.add("0000");
        q2.add(target);
        while(!q.isEmpty() && !q2.isEmpty()) {
            int size = q.size();
            for(int i=0;i<size; i++) {
                curr = q.peek();
                q.poll();
                if(q2.contains(curr)) {
                    return steps;
                }
                if(visited.contains(curr)) continue;
                visited.add(curr);
                for(int j=0;j<4;j++) {
                    int c = curr.charAt(j)-'0';
                        String n = curr.substring(0,j) + (c+1)%10 + curr.substring(j+1, curr.length());
                        if(!visited.contains(n)) {
                            q.add(n);
                        }
                        n = curr.substring(0,j) + (c-1+10)%10 +curr.substring(j+1, curr.length());
                        if(!visited.contains(n)) {
                            q.add(n);   
                        }
                }
                
            }
            temp=q;
            q=q2;
            q2=temp;
            // if(found) break;
            steps++;
        }
        return -1;
    }
}