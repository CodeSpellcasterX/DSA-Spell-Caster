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
    public int kthSmallest(TreeNode root, int k) {
        int[] ans = new int[2];
        callMe(root, k, ans);
        return ans[0];
    }

    private void callMe(TreeNode root, int k, int[] ans) {
        if(root==null) {
            return;
        }
        callMe(root.left, k, ans);
        ans[1]++;
        if(ans[1]==k) {
            ans[0] = root.val;
            return;
        }
        callMe(root.right, k, ans);
    }
}