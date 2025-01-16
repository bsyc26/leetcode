// leetcode 410
// binary-search:lower-bound:mapping-function
// T: O(Nlog(sum(nums)-max(nums))) // N: nums.length
// S: O(1)

import java.util.Arrays;

class Solution {
    /** Return the min of split to make k subarr sum lteq split */
    public int splitArray(int[] nums, int k) {
        // vars
        long lo = Arrays.stream(nums).max().getAsInt(); // lo: N group
        long hi= Arrays.stream(nums).sum(); // hi: 1 group
        // pass the range of res split
        while (lo <= hi) {
            long mid = lo + (hi-lo)/2;
            int midGroup = getGroup(nums, mid);
            if (midGroup > k)
                lo = mid+1;
            else if (midGroup < k)
                hi = mid-1;
            else
                hi = mid-1;
        }
        // return
        return (int)lo;
    }

    // return the group under given split
    private int getGroup(int[] nums, long split) {
        // res
        int groups = 1;
        // var
        long sum = 0;
        // pass nums[]
        for (int num : nums) {
            sum += num;
            if (sum > split) {
                ++groups;
                sum = num;
            }
        }
        // return
        return groups;
    }
}
