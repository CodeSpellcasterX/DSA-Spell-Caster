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
    boolean ans = false;
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        boolean[] arr = new boolean[1];
        traverse(root, subRoot, arr);
        return arr[0];
    }

    private void traverse(TreeNode root, TreeNode subRoot, boolean[] arr) {
        if(root == null) {
            return;
        }
        if(root.val == subRoot.val) {
            arr[0] = arr[0] || checkSubtree(root, subRoot);
        } 
        traverse(root.left, subRoot, arr);
        traverse(root.right, subRoot, arr);
    }

    private boolean checkSubtree(TreeNode root, TreeNode subRoot) {
        if(root==null && subRoot==null) {
            return true;
        }

        if(root==null || subRoot==null) {
            return false;
        }

        return root.val==subRoot.val && checkSubtree(root.left, subRoot.left)
        && checkSubtree(root.right, subRoot.right);
    }
}