// leetcode 33
// binary-search
// T: O(logN) // N: nums.length
// S: O(1)

class Solution {
    /** Return the index of target else -1
      * incre nums[] is possibly rotated at k */
    public int search(int[] nums, int target) {
        // const
        int N = nums.length;
        // edge cases
        if (N == 0) return -1;
        // vars
        int lo = 0;
        int hi = N-1;
        // binary pass [lo..hi]
        while (lo <= hi) {
            int mid = lo + (hi-lo)/2;
            if (nums[mid] == target)
                return mid;
            if (nums[lo] <= nums[mid]) { // in 1st half
                if (nums[lo] <= target && target < nums[mid])
                    hi = mid-1;
                else
                    lo = mid+1;
            } else { // in 2nd half
                if (nums[mid] < target && target <= nums[hi])
                    lo = mid+1;
                else
                    hi = mid-1;
            }
        }
        // return fallback
        return -1;
    }
}
