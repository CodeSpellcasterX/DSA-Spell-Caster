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
        joinChild(root);
        return root;
        
        // Queue<Node> q = new LinkedList<>();
        // if(root==null) {
        //     return root;
        // }
        // q.add(root);
        // q.add(null);
        // while(q.size() > 1) {
        //     Node front = q.remove();
        //     Node peek = q.peek();
        //     if(front==null) {
        //         if(peek == null) {
        //             break;
        //         }
        //         q.add(null);
        //         continue;
        //     }
        //     front.next = peek;

        //     q.add(front.left);
        //     q.add(front.right);
        // }

        // return root;
    }

    public void joinChild(Node root) {
        // Base case: if the root is null, do nothing and return
        if(root == null) {
            return;
        }
        
        // Get the left and right child nodes of the root
        Node left = root.left;
        Node right = root.right;
        
        // If the left child exists, set its next pointer to the right child
        // If the left child exists, set its next pointer to the right child
        if(left != null) {
            left.next = right;
        }
        
        // If the right child and root's next are not null, 
        // set the right child's next pointer to the next left child
        if(right != null && root.next != null) {
            right.next = root.next.left;
        }
        
        // Recursively join children for the left and right nodes
        joinChild(left);
        joinChild(right);
    }
}