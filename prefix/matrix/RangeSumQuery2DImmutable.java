// leetcode 304
// preSum:pre-sum
// T: O(1)
// S: O(MN)

import java.util.Arrays;

class NumMatrix {
    // field
    private int[][] preSum; // preSum[i][j] = sum(mat[0][0]..mat[i-1][j-1])

    // constructor
    public NumMatrix(int[][] matrix) { // T: O(MN), S: O(MN)
        // consts
        int M = matrix.length;
        int N = matrix[0].length;
        // field
        preSum = new int[M+1][N+1];
        // init preSum[][]
        Arrays.fill(preSum[0], 0);
        for (int row = 0; row < M; row++) 
            preSum[row][0] = 0;
        // build preSum[][]
        for (int row = 1; row <= M; row++) {
            for (int col = 1; col <= N; col++) {
                preSum[row][col] = (
                    matrix[row-1][col-1] + preSum[row][col-1]
                    + preSum[row-1][col] - preSum[row-1][col-1]
                );
            }
        }
    }
    
    /** Return the sum of mat[row1][col1]..mat[row2][col2] */
    public int sumRegion(int row1, int col1, int row2, int col2) { // T: O(1)
        return preSum[row2+1][col2+1] - preSum[row2+1][col1]
            - preSum[row1][col2+1] + preSum[row1][col1];
    }
}
