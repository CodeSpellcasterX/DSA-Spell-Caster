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
class FindElements {

    TreeNode finalRoot;
    public FindElements(TreeNode root) {
        createTree(root, 0);
        finalRoot = root;
    }

    public void createTree(TreeNode root, int toAssign) {
        if(root==null) {
            return;
        }
        root.val = toAssign;
        if(root.left!=null) {
            createTree(root.left, 2*toAssign + 1);
        }
        if(root.right!=null) {
            createTree(root.right, 2*toAssign + 2);
        }
        return;
    }
    
    public boolean find(int target) {
        return findTarget(finalRoot, target);
    }

    public boolean findTarget(TreeNode node, int target) {
        if(node.val == target) {
            return true;
        }
        if(node.left !=null && findTarget(node.left, target)) { 
            return true;
        }
        if(node.right !=null && findTarget(node.right, target)) {
            return true;
        }
        return false;
    }
}

/**
 * Your FindElements object will be instantiated and called as such:
 * FindElements obj = new FindElements(root);
 * boolean param_1 = obj.find(target);
 */