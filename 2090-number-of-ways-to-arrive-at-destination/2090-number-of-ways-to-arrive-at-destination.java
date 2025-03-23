class Solution {
    public int countPaths(int n, int[][] roads) {
        // Graph representation: List of lists of (neighbor, travel time)
        List<List<int[]>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++)
            graph.add(new ArrayList<>());
        
        // Populate the graph with bidirectional roads
        for (int[] road : roads) {
            int start = road[0], end = road[1], time = road[2];
            graph.get(start).add(new int[]{end, time});
            graph.get(end).add(new int[]{start, time});
        }
        
        // Distance array to track shortest time to reach each node
        long[] dist = new long[n];
        // Ways array to track number of ways to reach each node
        int[] ways = new int[n];
        
        // Initialize distances and ways
        Arrays.fill(dist, Long.MAX_VALUE); // Start with infinity distance
        dist[0] = 0; // Distance to start node is 0
        ways[0] = 1; // There is 1 way to be at the start node
        
        // Priority queue to process nodes with the current shortest distance
        PriorityQueue<long[]> pq = new PriorityQueue<>(Comparator.comparingLong(a -> a[0]));
        pq.offer(new long[]{0, 0}); // Start from node 0 with distance 0
        
        int MOD = 1_000_000_007; // Modulo value
        
        // Dijkstra's algorithm to find the shortest paths
        while (!pq.isEmpty()) {
            long[] curr = pq.poll();
            long currNodeDistance = curr[0];
            int currNode = (int) curr[1];
            
            // Skip if we already found a shorter path to the current node
            if (currNodeDistance > dist[currNode]) continue;
            
            // Traverse neighbors of the current node
            for (int[] neighbor : graph.get(currNode)) {
                int nextNode = neighbor[0];
                int nextNodeDistance = neighbor[1];
                
                // If a shorter path is found to the next node
                if (dist[currNode] + nextNodeDistance < dist[nextNode]) {
                    dist[nextNode] = dist[currNode] + nextNodeDistance;
                    ways[nextNode] = ways[currNode]; // Set ways to reach next node
                    pq.offer(new long[]{dist[nextNode], nextNode}); // Add to priority queue
                }
                // If the shortest path is the same as the one we found earlier
                else if (dist[currNode] + nextNodeDistance == dist[nextNode]) {
                    ways[nextNode] = (ways[nextNode] + ways[currNode]) % MOD; // Add ways
                }
            }
        }
        
        // Return the number of ways to reach the destination node (n-1)
        return ways[n - 1];
    }
}