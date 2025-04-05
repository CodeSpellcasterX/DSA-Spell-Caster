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
    int maxLevel = 0;
    public TreeNode lcaDeepestLeaves(TreeNode root) {
        Map<Integer, TreeNode> parentMap = new HashMap<>();
        Map<Integer, Queue<TreeNode>> levelOrder = new HashMap<>();
        levelOrderTraversal(root, 0, null, parentMap, levelOrder);
        Queue<TreeNode> leafNodes = levelOrder.getOrDefault(maxLevel, null);
        if(leafNodes.size() == 1) return leafNodes.peek();
        while(!leafNodes.isEmpty()) {
            int size = leafNodes.size();
            TreeNode p = parentMap.getOrDefault(leafNodes.peek().val, null);
            boolean isSameParent = true;
            while(size-->0) {
                TreeNode node = leafNodes.poll();
                TreeNode currNodeParent = parentMap.getOrDefault(node.val, null);
                if(currNodeParent != p) {
                    isSameParent = false;
                }
                if(currNodeParent != null) {
                    leafNodes.add(currNodeParent);
                }
            }
            if(isSameParent) return p;
        }
        return null;
    }

    private void levelOrderTraversal(TreeNode node, int level, TreeNode parent, Map<Integer, TreeNode> parentMap, Map<Integer, Queue<TreeNode>> levelOrder) {
        if(node == null) return;
        parentMap.put(node.val, parent);
        maxLevel = Math.max(maxLevel, level);
        levelOrder.putIfAbsent(level, new LinkedList<>());
        levelOrder.get(level).add(node);
        levelOrderTraversal(node.left, level+1, node, parentMap, levelOrder);
        levelOrderTraversal(node.right, level+1, node, parentMap, levelOrder);
    }
}