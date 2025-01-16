// leetcode 15
// two-pointers:left-right + sort
// T: O(N^2) // N: nums.length
// S: O(1) // sort-in-place

//- N < 3: return empty list
//- dup vals of triplet: record 1st uniq, jump dup
//- dup nums[i] or dup nums[left], nums[right]

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

class Solution {
    /** Return all diff triplets nums[i] that added up to 0 */
    public List<List<Integer>> threeSum(int[] nums) {
        // const
        int N = nums.length;
        // edge cases 
        if (N < 3) return new ArrayList<>();
        // res
        List<List<Integer>> res = new ArrayList<>(); // list of triplets
        // sort
        Arrays.sort(nums);
        // pass nums[]
        for (int i = 0; i < N-2; i++) {
            // jump dup
            if (i > 0 && nums[i] == nums[i-1]) continue;
            // vars
            int target = 0 - nums[i];
            int left = i + 1;
            int right = N - 1;
            // pass nums[]
            while (left < right) {
                long sum = (long)nums[left] + nums[right];
                if (sum > target)
                    --right;
                else if (sum < target)
                    ++left;
                else {
                    res.add(new ArrayList<>List.of(nums[i], nums[left], nums[right]));
                    ++left;
                    --right;
                    // jump dup
                    while (left < right && nums[left] == nums[left-1]) ++left;
                    while (left < right && nums[right] == nums[right+1]) --right;
                }
            }
        }
        return res;
    }
}

