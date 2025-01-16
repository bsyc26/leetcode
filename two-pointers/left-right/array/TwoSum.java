// leetcode 1
// two-pointers:left-right + sort
// T: O(NlogN)
// S: O(N)

//- [], one elem: return [-1, -1]
//- none match: return [-1, -1]
//- same elems: same indices -> store dup vals with diff idx
//- dup elem: 1st index of matching elem

import java.util.Arrays;

class Solution {
    // nested record
    private record ValIdx(int val, int idx) {}

    /** Return indices that elem added up to target */
    public int[] twoSum(int[] nums, int target) {
        // const
        int N = nums.length;
        // edge cases
        if (N == 0 || N == 1) return new int[]{ -1, -1 };
        // vars
        ValIdx[] arr = new ValIdx[N];
        for (int i = 0; i < N; i++)
            arr[i] = new ValIdx(nums[i], i);
        // sort
        Arrays.sort(arr, (a, b) -> Integer.compare(a.val(), b.val()));
        // vars
        int left = 0;
        int right = N-1;
        while (left <= right) {
            int sum = arr[left].val() + arr[right].val();
            if (sum < target)
                ++left;
            else if (sum > target)
                --right;
            else
                return new int[]{ arr[left].idx(), arr[right].idx() };
        }
        // return fallback
        return new int[]{ -1, -1 };
    }
}
