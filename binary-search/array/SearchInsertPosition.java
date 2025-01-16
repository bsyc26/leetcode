// leetcode 35
// binary-search:lower-bound
// T: O(logN) // N: nums.length
// S: O(1)

class Solution {
    /** Return the index of target else index to insert into of sorted incr nums[] */
    public int searchInsert(int[] nums, int target) {
        // const
        int N = nums.length;
        // edge case
        if (N == 0) return 0;
        // vars
        int lo = 0;
        int hi = N-1;
        // pass nums[]
        while (lo <= hi) {
            int mid = lo + (hi-lo)/2;
            int midVal = nums[mid];
            if (midVal > target)
                hi = mid-1;
            else if (midVal < target)
                lo = mid+1;
            else
                hi = mid-1;
        }
        // return
        return lo;
    }
}
