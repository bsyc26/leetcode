// leetcode 48                                                                  
// matrix + iteration
// T: O(N^2) // N: matrix.length
// S: O(1)
 
class Solution {
    /** Rotate the matrix[][] 90 deg clockwise in-place */
    public void rotate(int[][] matrix) {
        transpose(matrix);
        reflect(matrix);
    }

    // transpose matrix
    private void transpose(int[][] mat) {
        for (int row = 0; row < mat.length; row++) {
            for (int col = row+1; col < mat[0].length; col++) {
                int tmp = mat[row][col];
                mat[row][col] = mat[col][row];
                mat[col][row] = tmp;
            }
        }
    }

    // reflect matrix
    private void reflect(int[][] mat) {
        for (int row = 0; row < mat.length; row++) {
            int left = 0;
            int right = mat[0].length-1;
            while (left < right) {
                int tmp = mat[row][left];
                mat[row][left] = mat[row][right];
                mat[row][right] = tmp;
                left++;
                right--;
            }
        }
    }

}
