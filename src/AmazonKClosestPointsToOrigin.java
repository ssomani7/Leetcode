/**
 * time: O(NlogK)
 * space: O(K)
 */

import java.util.PriorityQueue;
import java.util.Comparator;

public class AmazonKClosestPointsToOrigin {
    public int[][] kClosest(int[][] points, int K) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparing(a -> -a[0] * a[0] - a[1] * a[1]));
        for (int[] p : points) {
            pq.offer(p);
            if (pq.size() > K) { pq.poll(); } // poll out the farthest among the K + 1 points.
        }
        int[][] ans = new int[K][2];
        while (K-- > 0) { ans[K] = pq.poll(); }
        return ans;
    }
}
