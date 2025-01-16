// leetcode 59
// matrix + iteraion
// T: O(N^2) // N: n
// S: O(1)

class Solution {
    /** Return a nxn matrix fill-in 1..n^2 spiral order */
    public int[][] generateMatrix(int n) {
        // res
        int[][] res = new int[n][n];
        // vars
        int upper = 0;
        int lower = n-1;
        int left = 0;
        int right = n-1;
        int num = 1; // the next num to fill in matrix
        // pass res[][]
        while (num <= n * n) {
            // left to right at upper
            if (upper <= lower) {
                for (int col = left; col <= right; col++)
                    res[upper][col] = num++;
                upper++; 
            }
            // upper to lower at right
            if (left <= right) {
                for (int row = upper; row <= lower; row++)
                    res[row][right] = num++;
                right--;
            }
            // right ot left at lower
            if (upper <= lower) {
                for (int col = right; col >= left; col--)
                    res[lower][col] = num++;
                lower--;
            }
            // lower to upper at left
            if (left <= right) {
                for (int row = lower; row >= upper; row--)
                    res[row][left] = num++;
                left++;
            }
        }
        // return
        return res;
    }
}
