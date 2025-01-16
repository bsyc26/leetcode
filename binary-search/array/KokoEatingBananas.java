// leetcode 875
// binary-search:lower-bound:mapping-function
// T: O(Nlog(max(piles))) // N: piles.length
// S: O(1)

import java.util.Arrays;

class Solution {
    /** Return the min k to make all bananas eaten within h hours
      * k: bananas-per-hour eating speed, at most one pile one hour */
    public int minEatingSpeed(int[] piles, int h) {
        // edge cases
        if (piles.length == 0) return 0;
        // vars
        int lo = 1; // k is at least 1
        int hi = Arrays.stream(piles).max().getAsInt(); // k is at most max(piles)
        // pass k range
        while (lo <= hi) {
            int mid = lo + (hi-lo)/2;
            long midH = getHours(piles, mid);
            if (midH > h)
                lo = mid+1;
            else if (midH < h)
                hi = mid-1;
            else
                hi = mid-1;
        }
        // return
        return lo;
    }

    // Return the h hours under k eating-speed
    private long getHours(int[] piles, int k) {
        // res
        long hours = 0;
        // pass piles[]
        for (int i = 0; i < piles.length; i++)
            hours += (piles[i] + k - 1) / k; // ceil division
        // return
        return hours;
    }
}
