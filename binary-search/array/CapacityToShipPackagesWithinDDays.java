// leetcode 1011
// binary-search:lower-bound:mapping-function
// T: O(Nlog(max(weights)) // N: weights.length
// S: O(1)

import java.util.Arrays;

class Solution {
    /** Return the least weight capacity to ship all weights[] withing days
      * each day can ship multiple weights[i] with sum lt capacity */
    public int shipWithinDays(int[] weights, int days) {
        // edge cases
        if (weights.length == 0) return 0;
        // vars
        long lo = Arrays.stream(weights).max().getAsInt(); // min cap: most day (N)
        long hi = Arrays.stream(weights).sum(); // max cap: least day (1)
        // pass the range of res cap
        while (lo <= hi) {
            long mid = lo + (hi-lo)/2;
            int midDays = getDays(weights, mid);
            if (midDays < days)
                hi = mid-1;
            else if (midDays > days)
                lo = mid+1;
            else
                hi = mid-1;
        }
        // return
        return (int)lo;
    }

    // return the need days under given capacity of shipping weight
    private int getDays(int[] weights, long capacity) { // cap: days
        // res
        int days = 1; // at least one day
        // var
        long ship = 0;
        // pass weights[]
        for (int weight : weights) {
            if (ship + weight > capacity) {
                ++days;
                ship = weight;
            } else {
                ship += weight;
            }
        }
        // return
        return days;
    }
}
