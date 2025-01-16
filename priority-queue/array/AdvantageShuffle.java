// leetcode 870
// priority-queue + two-pointers:left-right
// T: O(NlogN) // N: nums1.length()
// S: O(N)

import java.util.PriorityQueue;
import java.util.Arrays;

class Solution {
    // nested record
    private record IdxVal(int idx, int val) {}

    /** Return any perm of nums1[] max its advantage to nums2[] */
    public int[] advantageCount(int[] nums1, int[] nums2) {
        // const
        int N = nums1.length;
        // res
        int[] res = new int[N]; // perm of qualified nums1[]
        // pre
        Arrays.sort(nums1);
        // vars
        PriorityQueue<IdxVal> pq = new PriorityQueue<>( // max-heap
            (IdxVal a, IdxVal b) -> Integer.compare(b.val(), a.val())
        );
        for (int i = 0; i < N; i++)
            pq.offer(new IdxVal(i, nums2[i]));
        int left = 0;
        int right = N-1;
        // pass pq (nums2[]) && build res[]
        while (!pq.isEmpty()) {
            // poll
            IdxVal cur2 = pq.poll();
            int idx2 = cur2.idx();
            int val2 = cur2.val();
            if (val2 < nums1[right]) {
                res[idx2] = nums1[right];
                --right;
            } else {
                res[idx2] = nums1[left];
                ++left;
            }
        }
        // return
        return res;
    }
}
