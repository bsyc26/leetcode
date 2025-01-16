// leetcode 26
// two-pointers:fast-slow
// T: O(N) // N: nums.length
// S: O(1)

//- []: return 0
//- one elem: return 1
//- all dup: slow init at index 0, return 0
//- avg case: return slow+1

class Solution {
    /** Remove dup elems of sorted nums[] in-place and return uniq num */
    public int removeDuplicates(int[] nums) {
        // const
        int N = nums.length;
        // edge cases
        if (N == 0 || N == 1) return N;
        // vars
        int fast = 0;
        int slow = 0; // nums[0] is always preserved
        // pass nums[] with fast
        while (fast < N) {
            // step slow
            if (nums[fast] != nums[slow]) {
                slow++;
                nums[slow] = nums[fast];
            }
            // step fast
            fast++;
        }
        // return
        return slow + 1;
    }
}
