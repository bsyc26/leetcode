// leetcode 303
// prefix:pre-sum
// T: O(1)
// S: O(1)

class NumArray {
    // field
    private int[] preSum; // preSum[i] = sum(nums[0]..sum[i-1])

    // constructor
    public NumArray(int[] nums) { // T: O(N), S: O(N)
        int N = nums.length;
        preSum = new int[N+1]; 
        preSum[0] = 0;
        for (int i = 1; i <= N; i++)
            preSum[i] = preSum[i-1] + nums[i-1];
    }
    
    /** Return the sum of nums[left]..nums[right] */
    public int sumRange(int left, int right) { // T: O(1)
        assert left <= right;
        return preSum[right+1] - preSum[left]; 
    }
}
