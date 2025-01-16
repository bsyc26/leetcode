// leetcode 34
// binary-search:lower-bound:upper-bound
// T: O(logN) // N: nums.length()
// S: O(1)

class Solution {
    /** Return an arr of first, last index of target in non-decr nums[], eles -1 */
    public int[] searchRange(int[] nums, int target) {
        // edge case
        if (nums.length == 0) return new int[]{ -1, -1 };
        // vars
        int first = lowerBound(nums, target);
        int last = upperBound(nums, target);
        // return
        return new int[]{ first, last };
    }

    // return the first index of target in nums[], else -1
    private int lowerBound(int[] nums, int target) {
        // vars
        int lo = 0;
        int hi = nums.length-1;
        // pass nums[]
        while (lo <= hi) {
            int mid = lo + (hi-lo)/2;
            int cur = nums[mid];
            if (cur > target)
                hi = mid-1;
            else if (cur < target)
                lo = mid+1;
            else
                hi = mid-1;
        }
        // return condition
        return (lo >= 0 && lo < nums.length && nums[lo] == target) ? lo : -1;
    }

    // return the last index of target in nums[], else -1
    private int upperBound(int[] nums, int target) {
        // vars
        int lo = 0;
        int hi = nums.length-1;
        // pass nums[]
        while (lo <= hi) {
            int mid = lo + (hi-lo)/2;
            int cur = nums[mid];
            if (cur > target)
                hi = mid-1;
            else if (cur < target)
                lo = mid+1;
            else
                lo = mid+1;
        }
        // return condition
        return (hi >= 0 && hi < nums.length && nums[hi] == target) ? hi : -1;
    }
}
