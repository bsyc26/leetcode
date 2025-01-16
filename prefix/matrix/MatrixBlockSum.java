// leetcode 1314
// prefix:pre-sum + matrix
// T: O(MN) // M: mat.length, N: mat[0].length
// S: O(MN)

class Solution {
    /** Return a res[][], res[i][j] is sum of mat[row][col]:
      * row: i-k..i+k, col: j-k..j+k within matrix */
    public int[][] matrixBlockSum(int[][] mat, int k) {
        // const
        int M = mat.length;
        int N = mat[0].length;
        // res
        int[][] res = new int[M][N];
        // var
        int[][] preSum = new int[M+1][N+1]; // row=0, col=0, preSum[]=0
        // pass mat[][] && build preSum[][]
        for (int row = 1; row <= M; row++) {
            for (int col = 1; col <= N; col++) {
                preSum[row][col] = mat[row-1][col-1]
                    + preSum[row-1][col] + preSum[row][col-1]
                    - preSum[row-1][col-1];
            }
        }
        // pass mat[][] && build res[][]
        for (int row = 0; row < M; row++) {
            for (int col = 0; col < N; col++) {
                int row1 = Math.max(row-k, 0);
                int col1 = Math.max(col-k, 0);
                int row2 = Math.min(row+k, M-1);
                int col2 = Math.min(col+k, N-1);
                res[row][col] = preSum[row2+1][col2+1]
                    - preSum[row2+1][col1] - preSum[row1][col2+1]
                    + preSum[row1][col1];
            }
        }
        // return
        return res;
    }
}
