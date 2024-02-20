/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
    public List<List<Integer>> levelOrder(Node root) {

        List<List<Integer>> rList = new ArrayList<>();
        if(root==null) return rList;
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        
        while(!q.isEmpty()) {
            int size = q.size();
            var curr = new ArrayList<Integer>();
            for(int i=0; i<size; i++) {
                var el = q.remove();
                curr.add(el.val);
                q.addAll(el.children);
            }
            rList.add(curr);
        }
        return rList;
    }
}