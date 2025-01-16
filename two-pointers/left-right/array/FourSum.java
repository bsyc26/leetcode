// leetcode 18
// two-pointers:left-right + sort
// T: O(N^3) // N: nums.length
// S: O(1) // sort-in-place

//- N < 4: return empty list
//- dup nums[i]: test if valid, jump valid dup vals
//- sum overflow: convert to long during comp

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

class Solution {
    /** Return uniq quadruplets nums[i] that sum up to target */
    public List<List<Integer>> fourSum(int[] nums, int target) {
        // const
        int N = nums.length;
        // edge cases
        if (N < 4) return new ArrayList<>();
        // sort
        Arrays.sort(nums); // non-decreasing order
        // res
        List<List<Integer>> res = new ArrayList<>(); // list of valid quadruplets list
        // pass nums[]
        for (int i = 0; i < N-3; i++) {
            if (i > 0 && nums[i] == nums[i-1]) continue;
            // pass nums[]
            for (int j = i+1; j < N-2; j++) {
                if (j > i+1 && nums[j] == nums[j-1]) continue;
                // vars
                int left = j+1;
                int right = N-1;
                // pass nums[]
                while (left < right) {
                    long sum = (long)nums[i] + nums[j] + nums[left] + nums[right]; // auto long
                    if (sum < target)
                        ++left;
                    else if (sum > target)
                        --right;
                    else {
                        res.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));
                        ++left;
                        --right;
                        // jump dup
                        while (left < right && nums[left] == nums[left-1]) ++left;
                        while (left < right && nums[right] == nums[right+1]) --right;
                    }
                }
            }
        }
        // return
        return res;
    }
}
