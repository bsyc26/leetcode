// leetcode 1
// hash:hash-map
// T: O(N) // N: nums.length
// S: O(N)

//- [], one elem: return [-1, -1]
//- same elems: same indices
//- dup for valid pair: return last index

import java.util.HashMap;

class Solution {
    /** Return indices of elems that add up to target */
    public int[] twoSum(int[] nums, int target) {
        // const
        int N = nums.length;
        // edge cases
        if (N == 0 || N == 1) return new int[]{ -1, -1 };
        // vars
        HashMap<Integer, Integer> valToIdx = new HashMap<>(); // last idx for dup vals
        // pass nums[] && build valToIdx
        for (int i = 0; i < N; i++) {
            int curVal = nums[i];
            int needVal = target - curVal;
            if (valToIdx.containsKey(needVal)) {
                int needIdx = valToIdx.get(needVal);
                return new int[]{ needIdx, i };
            }
            valToIdx.put(curVal, i);
        }
        // return fallback
        return new int[]{ -1, -1 };
    }
}
