// leetcdoe 238
// prefix:pre-prod + mono-state
// T: O(N)
// S: O(1)

// N == 0 
// N == 1
// [1, 0, 2]: [x] totProd / nums[i] -> need calc leftProd, rightProd

import java.util.Arrays;

class Solution {
    /** Return an res[], res[i] is prod of all elems except nums[i] */
    public int[] productExceptSelf(int[] nums) {
        // const
        int N = nums.length;
        // edge case
        if (N == 0) return new int[0];
        if (N == 1) return new int[]{ 0 };
        // res
        int[] res = new int[N];
        // vars
        int leftProd = 1;
        int rightProd = 1;
        // build res[] && update leftProd
        for (int i = 0; i < N; i++) {
            res[i] = leftProd;
            leftProd *= nums[i];
        }
        // build res[] && update rightProd
        for (int i = N-1; i >=0; i--) {
            res[i] *= rightProd;
            rightProd *= nums[i];
        }
        // return
        return res;
    }
}
