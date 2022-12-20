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
    
    public int minCostToSupplyWater(int n, int[] wells, int[][] pipes) {
        for(int i=1; i<=n+1; i++)
            makeSet(i);
        List<List<Integer>> edges = new ArrayList<>();
        for(int[] pipe: pipes) {
            edges.add(Arrays.asList(pipe[0], pipe[1], pipe[2]));
        }
        for(int i=0; i<n; i++) {
            edges.add(Arrays.asList(n+1, i+1, wells[i]));
        }
        edges.sort((a,b)->a.get(2)-b.get(2));
        int edgeCount=0;
        int totalWeight=0;
        for(int i=0; i<edges.size(); i++) {
            if(edgeCount==n) break;
            var edge = edges.get(i);
            if(union(edge.get(0), edge.get(1))) {
                edgeCount++;
                totalWeight+=edge.get(2);
            }
        }
        return totalWeight;
    }
}