// leetcode 1004
// sliding-window
// T: O(N) // N: nums.length
// S: O(1)

class Solution {
    /** Return the max num of consecutive 1's in nums[] with at most k flip of 0's */
    public int longestOnes(int[] nums, int k) {
        // const
        int N = nums.length;
        // edge case
        if (N == 0) return 0;
        // res
        int res = 0; // max len of qualified sub arr
        // vars
        int left = 0;
        int right = 0;
        int winFlip = 0;
        // pass nums[]
        while (right < N) {
            // step right
            if (nums[right] == 0)
                ++winFlip;
            ++right;
            // step left
            while (left < right && winFlip > k) {
                if (nums[left] == 0)
                    --winFlip;
                ++left;
            }
            // update res
            res = Math.max(res, right-left);
        }
        // return
        return res;
    }
}
