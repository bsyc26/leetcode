// leetcode 81
// binary-search
// T: O(logN)~O(N) // N: nums.length
// S: O(1)

class Solution {
    /** Return true if target in nums[] else false
      * non-decre nums[] is rotated at k */
    public boolean search(int[] nums, int target) {
        // const
        int N = nums.length;
        // vars
        int lo = 0;
        int hi = N-1;
        // binary search [lo..hi]
        while (lo <= hi) {
            // de-dup
            while (lo < hi && nums[lo] == nums[lo+1])
                ++lo;
            while (lo < hi && nums[hi] == nums[hi-1])
                --hi;
            int mid = lo + (hi-lo)/2;
            if (nums[mid] == target)
                return true;
            if (nums[lo] <= nums[mid]) { // in 1st non-decre half
                if (nums[lo] <= target && target < nums[mid])
                    hi = mid-1;
                else
                    lo = mid+1;
            } else { // in 2nd non-decre half
                if (nums[mid] < target && target <= nums[hi])
                    lo = mid+1;
                else
                    hi = mid-1;
            }
        }
        // return fallback
        return false;
    }
}
