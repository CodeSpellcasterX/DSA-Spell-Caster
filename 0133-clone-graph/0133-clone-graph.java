/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {
        if(node==null) {
            return null;
        }
        HashMap<Node, Node> mp = new HashMap<>();
        return clonedUtil(node, mp);
    }

    public Node clonedUtil(Node node, HashMap<Node, Node> mp) {
        Node newNode = new Node(node.val);
        mp.put(node, newNode);
        for(Node neighborNode: node.neighbors) {
            if(!mp.containsKey(neighborNode)) {
                newNode.neighbors.add(clonedUtil(neighborNode, mp));
            } else {
                newNode.neighbors.add(mp.get(neighborNode));
            }
        }
        return newNode;
    }
}