import java.util.*;

class Solution {
    public int countCompleteComponents(int n, int[][] edges) {
        int count = 0;
        List<Integer>[] adjLs = new ArrayList[n];

        for (int i = 0; i < n; i++) {
            adjLs[i] = new ArrayList<>();
        }

        // Add edges to adjacency list
        for (int i = 0; i < edges.length; i++) {
            adjLs[edges[i][0]].add(edges[i][1]);
            adjLs[edges[i][1]].add(edges[i][0]);
        }

        boolean[] vis = new boolean[n];

        for (int i = 0; i < n; i++) {
            if (!vis[i]) { 
                if (isCompleteComponent(i, vis, adjLs)) {
                    count++;
                }
            }
        }
        return count;
    }

    private boolean isCompleteComponent(int node, boolean[] vis, List<Integer>[] adjLs) {
        Queue<Integer> q = new LinkedList<>();
        Set<Integer> componentNodes = new HashSet<>();
        
        q.add(node);
        vis[node] = true;

        while (!q.isEmpty()) {
            int cur = q.remove();
            componentNodes.add(cur);

            for (int neighbor : adjLs[cur]) {
                if (!vis[neighbor]) {
                    vis[neighbor] = true;
                    q.add(neighbor);
                }
            }
        }

        // Check if the component forms a complete graph
        for (int n : componentNodes) {
            if (adjLs[n].size() != componentNodes.size() - 1) {
                return false;
            }
        }
        return true;
    }
}