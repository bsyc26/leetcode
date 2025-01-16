// leetcode 74
// binary-search + matrix:flatten
// T: O(logMN) // M: matrix.length, N: matrix[0].length
// S: O(1)

class Solution {
    /** Return true if target in matrix[][], else false
      * each row is non-decr sorted; first elem of row is gt last elem of prev row */
    public boolean searchMatrix(int[][] matrix, int target) {
        // const
        int M = matrix.length;
        int N = matrix[0].length;
        // vars
        int lo = 0;
        int hi = M*N-1;
        // pass matrix[][]
        while (lo <= hi) {
            int mid = lo + (hi-lo)/2;
            int midRow = mid / N;
            int midCol = mid % N;
            int midVal = matrix[midRow][midCol];
            if (midVal < target)
                lo = mid+1;
            else if (midVal > target)
                hi = mid-1;
            else
                return true;
        }
        // return fallback
        return false;
    }
}
