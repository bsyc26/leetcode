// leetcode 27
// two-pointers:fast-slow;
// T: O(N) // N: nums.length
// S: O(1)

//- []: return 0
//- [val]
//- 1st elem is val: jump 1st elem
//- [.., val, ..]: return 2, [!=, !=, ..]

class Solution {
    /** Remove all nums[i] == val in-place, return non-equal-val num */
    public int removeElement(int[] nums, int val) {
       // const
        int N = nums.length;
        // edge case
        if (N == 0) return 0;
        // vars
        int fast = 0;
        int slow = 0; // point to next slot
        // pass nums[] with fast
        while (fast < N) {
            // step slow
            if (nums[fast] != val) {
                nums[slow] = nums[fast];
                slow++;
            }
            // step fast
            fast++;
        }
        // return num of non-val elem
        return slow;
    }
}
