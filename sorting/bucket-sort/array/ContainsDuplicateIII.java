// leetcode 220
// bucket-sort + 
// T: O(N) // N: nums.length
// S: O(min(N, K)) // K: valueDiff

import java.util.HashMap;

class Solution {
    /** Return true if existing (i, j) pair (i != j), else false
      * abs(i-j) lteq indexDiff; abs(nums[i]-nums[j]) lteq valueDiff */
    public boolean containsNearbyAlmostDuplicate(int[] nums, int indexDiff, int valueDiff) {
        // const
        int N = nums.length;
        // edge cases
        if (N == 0 || N == 1 || indexDiff <= 0 || valueDiff < 0) return false;
        // var
    }
}
