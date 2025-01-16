// leetcode 240
// matrix + iteration
// T: O(M+N) // M: matrix.length, N: matrix[0].length
// S: O(1)

class Solution {
    /** Return true if target in matrix[][], else false
      * row: ascending; col: ascending*/
    public boolean searchMatrix(int[][] matrix, int target) {
        // consts
        int M = matrix.length;
        int N = matrix[0].length;
        // vars
        int row = 0;
        int col = N-1;
        // pass row..M-1, 0..col
        while (row <= M-1 && col >= 0) {
            int curVal = matrix[row][col];
            if (curVal > target)
                --col;
            else if (curVal < target)
                ++row;
            else
                return true;
        }
        // return fallback
        return false;
    }
}
