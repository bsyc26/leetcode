// leetcode 867
// matrix + iteration
// T: O(MN) // M: matrix.length, N: matrix[0].length
// S: O(1)

class Solution {
    /** Return the transpose of matrix[][] */
    public int[][] transpose(int[][] matrix) {
        // consts
        int M = matrix.length;
        int N = matrix[0].length;
        // res
        int[][] res = new int[N][M]; // transpose of matrix[][]
        // pass matrix[][]
        for (int row = 0; row < M; row++) {
            for (int col = 0; col < N; col++) {
                res[col][row] = matrix[row][col];
            }
        }
        // return
        return res;
    }
}
