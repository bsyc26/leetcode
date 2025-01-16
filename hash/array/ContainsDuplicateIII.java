// leetcode 220
// hash:tree-set
// T: O(NlogK) // N: nums.length, K: indexDiff
// S: O(k)

import java.util.TreeSet;

class Solution {
    /** Return true if existing pair diff (i, j), else false
      * abs(i-j) lteq indexDiff; abs(nums[i]-nums[j]) lteq valueDiff */
    public boolean containsNearbyAlmostDuplicate(int[] nums, int indexDiff, int valueDiff) {
        // const
        int N = nums.length;
        // edge cases
        if (N == 0 || N == 1 || indexDiff <= 0 || valueDiff < 0) return false;
        // vars
        TreeSet<Integer> set = new TreeSet<>(); // contains nums[i] indexDiff range
        // pass nums[]
        for (int i = 0; i < N; i++) {
            int cur = nums[i];
            Integer ceil = set.ceiling(cur);
            if (ceil != null && ceil-cur <= valueDiff)
                return true;
            Integer floor = set.floor(cur);
            if (floor != null && cur-floor <= valueDiff)
                return true;
            // update set
            set.add(cur);
            if (set.size() > indexDiff)
                set.remove(nums[i-indexDiff]);
        }
        // return fallback
        return false;
    }
}
