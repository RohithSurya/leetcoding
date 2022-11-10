/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        ArrayList al = new ArrayList<>();
        // inorder(root, al);
        if(root==null) return al;
        TreeNode curr = root;
        Stack<TreeNode> st = new Stack<>();
        while(!st.empty() || curr!=null) {
            while(curr!=null) {
                // System.out.println(curr.val);
                st.push(curr);
                curr=curr.left;
            }
            curr=st.pop();
            al.add(curr.val);
            curr=curr.right;
        }
        return al;
    }
    void inorder(TreeNode root, List num) {
        if(root!=null) {
            inorder(root.left, num);
            num.add(root.val);
            inorder(root.right, num);

        }
    }
}