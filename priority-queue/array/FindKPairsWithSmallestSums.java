// leetcode 373
// priority-queue:min-heap
// T: O(N1logK)
// S: O(K)

/*
   non-decreasing order: duplicates, N1 not necessary == N2

   X two-pointers: not viable due to potential pointer rewind

   min-heap: offer cur min from nums1[i] and nums2[0] -> 
*/


//- [1, 3], [2, 3]: pointers need rewind
//- N1 != N2
//- N1 == 0 || N2 == 0: return null

import java.util.List;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Arrays;

class Solution {
    // nested record
    private record Tuple(int num1, int num2, int index2) {}

    /** Return the k-th smallest pair of sorted non-decreasing nums1[], nums2[] */
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        // consts
        int N1 = nums1.length;
        int N2 = nums2.length;
        // edge cases
        if (N1 == 0 || N2 == 0) return null;
        // res
        List<List<Integer>> kMinPairs = new ArrayList<>();
        // vars
        PriorityQueue<Tuple> pq = new PriorityQueue<>(
            (a, b) -> Integer.compare((a.num1()+a.num2()), (b.num1()+b.num2()))
        ); 
        for (int i = 0; i < N1; i++)
            pq.offer(new Tuple(nums1[i], nums2[0], 0));
        // pass pq
        while (!pq.isEmpty() && k > 0) {
            // poll
            Tuple cur = pq.poll();
            int curIndex2 = cur.index2();            
            // update res
            kMinPairs.add(Arrays.asList(cur.num1(), cur.num2()));
            k--;
            // offer
            if (curIndex2 + 1 < N2)
                pq.offer(new Tuple(cur.num1(), nums2[curIndex2+1], curIndex2+1));
        }
        // return
        return kMinPairs;
    }
}
