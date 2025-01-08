/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
    public Node connect(Node root) {
        Queue<Node> q = new LinkedList<>();
        if(root==null) {
            return root;
        }
        q.add(root);
        q.add(null);
        while(q.size() > 1) {
            Node front = q.remove();
            Node peek = q.peek();
            if(front==null) {
                if(peek == null) {
                    break;
                }
                q.add(null);
                continue;
            }
            front.next = peek;

            q.add(front.left);
            q.add(front.right);
        }

        return root;
    }
}