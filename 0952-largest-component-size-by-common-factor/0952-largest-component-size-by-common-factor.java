class Solution {
    private Map<Integer, Node> map = new HashMap<>();

    class Node {
        int data;
        Node parent;
        int rank;
        int count;
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

    int union(int d1, int d2) {
        return union(map.get(d1), map.get(d2));
    }

    int union(Node n1, Node n2) {
        Node p1 = findSet(n1);
        Node p2 = findSet(n2);
        if(p1==p2) return p1.count;
        if(p1.rank>=p2.rank) {
            p1.rank= (p1.rank==p2.rank) ? p1.rank+1 : p1.rank;
            p1.count+=p2.count;
            p2.parent=p1;
            return p1.count;
        } else {
            p1.parent = p2;
            p2.count+=p1.count;
            return p2.count;
        }
    }

    Node makeSet(int data) {
        Node node = new Node();
        node.parent=node;
        node.data=data;
        node.rank=0;
        node.count=1;
        map.put(data, node);
        return node;
    }
    
    int gcd(int a, int b) {
        int rem=0;
        while((rem=a%b)!=0) {
            a=b;
            b=rem;
        }
        return b;
    }

    public int largestComponentSize(int[] nums) {
        int maxValue = Arrays.stream(nums).reduce(nums[0], (x,y)-> x>y?x:y);
        for(int i=1; i<maxValue+1; i++) {
            makeSet(i);
        }
        for(int num: nums) {
            for(int i=2; i<=(int)(Math.sqrt(num)); i++) {
                if(num%i==0) {
                    union(num, i);
                    union(num, num/i);
                }
            }
        }
        var map = new HashMap<Integer, Integer>();
        int maxSize=0;
        for(int num: nums) {
            int root = findSet(num).data;
            int gCount = map.getOrDefault(root, 0);
            maxSize = Math.max(maxSize, gCount+1);
            map.put(root, gCount+1);
        }
        return maxSize;
        
    }
}