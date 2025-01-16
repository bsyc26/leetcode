// leetcode 704
// binary-search
// T: O(logN) // N: nums.length
// S: O(1)

class Solution {
    /** Return index of target in ascending nums[], else -1 */
    public int search(int[] nums, int target) {
        // const
        int N = nums.length;
        // edge case
        if (N == 0) return -1;
        // vars
        int lo = 0;
        int hi = N-1;
        // pass nums[]
        while (lo <= hi) {
            int mid = lo + (hi-lo)/2;
            int cur = nums[mid];
            if (cur > target)
                hi = mid-1;
            else if (cur < target)
                lo = mid+1;
            else
                return mid;
        }
        // return fallback
        return -1;
    }
}
