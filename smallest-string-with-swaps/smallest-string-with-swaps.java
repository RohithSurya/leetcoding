class Solution {
    
    private Map<Integer, Node> map = new HashMap<>();

    class Node {
        int data;
        Node parent;
        int rank;
    }
    
    Node findSet(Node n) {
        if(n.parent==n) {
            return n;
        }
        n.parent=findSet(n.parent);
        return n.parent;
    }
    
    Node findSet(int data) {
        return findSet(map.get(data));
    }

    boolean union(int d1, int d2) {
        return union(map.get(d1), map.get(d2));
    }

    boolean union(Node n1, Node n2) {
        Node p1 = findSet(n1);
        Node p2 = findSet(n2);
        if(p1==p2) return false;
        if(p1.rank>=p2.rank) {
            p1.rank= (p1.rank==p2.rank) ? p1.rank+1 : p1.rank;
            p2.parent=p1;
        } else {
            p1.parent = p2;
        }
        return true;
    }

    Node makeSet(int data) {
        Node node = new Node();
        node.parent=node;
        node.data=data;
        node.rank=0;
        map.put(data, node);
        return node;
    }
    
    public String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {
        int slength = s.length();
        Map<Integer, List<Integer>> numMap = new HashMap<>();
        Map<Integer, List<Character>> charMap = new HashMap<>();
        char[] schars = s.toCharArray();
        for(int i=0; i<slength; i++) {
            makeSet(i);
        }
        
        for(List<Integer> pair: pairs) {
            union(pair.get(0), pair.get(1));
        }
        for(int i=0; i<slength; i++) {
            Node n = findSet(i);
            int index = n.data;
            numMap.putIfAbsent(index, new ArrayList<>());
            charMap.putIfAbsent(index, new ArrayList<>());
            numMap.get(index).add(i);
            charMap.get(index).add(schars[i]);
        }
        for(int key: numMap.keySet()) {
            List<Character> chars = charMap.get(key);
            if(chars.size()>1) {
                Collections.sort(chars);
                List<Integer> nIndexes = numMap.get(key);
                for(int i=0; i<chars.size(); i++) {
                    schars[nIndexes.get(i)] = chars.get(i);
                }
            }
        }
        return new String(schars);
    }
}