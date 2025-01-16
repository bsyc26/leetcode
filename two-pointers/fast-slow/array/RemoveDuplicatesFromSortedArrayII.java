// leetcode 80
// two-pointers:fast-slow
// T: O(N) // N: nums.length
// S: O(1)

//- N = 0, N = 1, N = 2: return N
//- all dup: return 0

class Solution {
    /** Remove dup of non-decr nums[] to make dup elems appears at most twice, return num of uniq */
    public int removeDuplicates(int[] nums) {
        // const
        int N = nums.length;
        // edge cases
        if (N <= 2) return N;
        // vars
        int fast = 0;
        int slow = 0;
        // pass nums[]
        while (fast < N) {
            // step slow
            if (slow < 2 || nums[fast] != nums[slow-2]) {
                nums[slow] = nums[fast];
                ++slow;
            }
            // step fast
            ++fast;
        }
        return slow;
    }
}
