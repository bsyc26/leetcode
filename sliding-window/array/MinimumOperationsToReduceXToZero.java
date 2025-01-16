// leetcode 1658
// sliding-window
// T: O(N) // N: nums.length
// S: O(1)

import java.util.Arrays;

class Solution {
    /** Return the min num of op to reduce x to 0, else -1
      * op: either remove the leftmost or rightmost elem from nums[] and substract its val from x */
    public int minOperations(int[] nums, int x) {
        // consts
        int N = nums.length;
        int sum = Arrays.stream(nums).sum();
        int target = sum - x;
        // res
        int maxLen = Integer.MIN_VALUE; // max len of un-substract subarray
        // vars
        int left = 0;
        int right = 0;
        int winSum = 0;
        // pass nums[]
        while (right < N) {
            // step right
            winSum += nums[right];
            ++right;
            // step left
            while (left < right && winSum > target) {
                winSum -= nums[left];
                ++left;
            }
            // update res
            if (winSum == target)
                maxLen = Math.max(maxLen, right-left);
        }
        // return condition
        return (maxLen == Integer.MIN_VALUE) ? -1 : N-maxLen;
    }
}
