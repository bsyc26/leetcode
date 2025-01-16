// leetcode 724
// prefix:pre-sum + mono-state
// T: O(N) // N: nums.length
// S: O(1)

import java.util.Arrays;

class Solution {
    /** Return the leftmost pivot index else -1
      * pivot index: sum of nums[i]'s left == its sum right */
    public int pivotIndex(int[] nums) {
        // const
        int N = nums.length;
        int sum = Arrays.stream(nums).sum();
        // var
        int leftSum = 0; // left pre-sum for curr nums[i]
        // pass nums[]
        for (int i = 0; i < N; i++) {
            int rightSum = sum - nums[i] - leftSum;
            if (leftSum == rightSum)
                return i;
            leftSum += nums[i];
        }
        // return fallback
        return -1;
    }
}
