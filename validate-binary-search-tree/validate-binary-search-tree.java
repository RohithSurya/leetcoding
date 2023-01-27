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
    boolean notTree=false;
    public boolean isValidBST(TreeNode root) {
        if(root==null) return true;
        isValidBSTHelper(root);
        return !notTree;
    }
    
    
    int[] isValidBSTHelper(TreeNode root) {
        if(root==null) return null;
        int leftG=root.val, rightG=root.val;
        int[] leftS = isValidBSTHelper(root.left) ;
        if(leftS !=null) {
            if(root.val<=leftS[0] || root.val <= leftS[1]) notTree=true;
            leftG = Math.min(leftG, Math.min(leftS[0], leftS[1]));
            rightG = Math.max(rightG, Math.max(leftS[0], leftS[1]));
        } else {
            leftG = rightG = root.val;
        }
        
        int[] rightS = isValidBSTHelper(root.right);
        if(rightS != null) {
            if(root.val>=rightS[0] || root.val>=rightS[1]) notTree=true;
            leftG = Math.min(leftG, Math.min(rightS[0], rightS[1]));
            rightG = Math.max(rightG, Math.max(rightS[0], rightS[1]));
        }
        return new int[]{leftG, rightG};
        
    }
}