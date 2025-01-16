// leetcode 167
// two-pointers:left-right
// T: O(N) // N: numbers.length
// S: O(1)

//- []: return [-1, -1]
//- one elem: return [-1, -1] 
//- two elems: return [1, 2] (1-indexed)

class Solution {
    public int[] twoSum(int[] numbers, int target) {
        // const
        int N = numbers.length;
        // edge cases
        if (N == 0 || N == 1) return new int[]{ -1, -1 };
        if (N == 2) return new int[]{ 1, 2 }; // 1-indexed
        // vars
        int left = 0;
        int right = N-1;
        // pass numbers[]
        while (left < right) { // one elem use once
            int sum = numbers[left] + numbers[right];
            // step left or right
            if (sum > target)
                right--;
            else if (sum < target)
                left++;
            else
                return new int[]{ left+1, right+1 };
        }
        // return fallback
        return new int[]{ -1, -1 };
    }
}
