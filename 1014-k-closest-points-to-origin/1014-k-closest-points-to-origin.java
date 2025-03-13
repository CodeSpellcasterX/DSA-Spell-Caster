class Solution {
    public int[][] kClosest(int[][] points, int k) {
        // Max-Heap (storing {distance, x, y})
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> b[0] - a[0]);

        for (int i = 0; i < points.length; i++) {
            int dist = points[i][0] * points[i][0] + points[i][1] * points[i][1]; // Squared distance
            pq.add(new int[]{dist, points[i][0], points[i][1]});

            if (pq.size() > k) {
                pq.poll(); // Remove the farthest point
            }
        }

        // Prepare result array
        int[][] ans = new int[k][2];
        int index = 0;
        while (!pq.isEmpty()) {
            int[] point = pq.poll();
            ans[index][0] = point[1];
            ans[index][1] = point[2];
            index++;
        }

        return ans;
    }
}
