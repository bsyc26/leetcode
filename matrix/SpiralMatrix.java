// leetcode 54                                                                  
// matrix + iteration
// T: O(MN) // M: matrix.length, N: matrix[0].length
// S: O(1)
 
import java.util.List;
import java.util.ArrayList;
 
class Solution { // iteration
    /** Return elems in spiral order of matrix[][] */
    public List<Integer> res(int[][] matrix) {
        // const
        int M = matrix.length;
        int N = matrix[0].length;
        // res
        List<Integer> res = new ArrayList<>();
        // vars
        int upper = 0;
        int lower = M-1;
        int left = 0;
        int right = N-1;
        // pass matrix[][]
        while (res.size() < M * N) {
            // left to right at upper
            if (upper <= lower) {
                for (int col = left; col <= right; col++)
                    res.add(matrix[upper][col]);
                upper++;
            }
            // upper to lower at right
            if (left <= right) {
                for (int row = upper; row <= lower; row++)
                    res.add(matrix[row][right]);
                right--;
            }
            // right to left at lower
            if (upper <= lower) {
                for (int col = right; col >= left; col--)
                    res.add(matrix[lower][col]);
                lower--;
            }
            // lower to upper at left
            if (left <= right) {
                for (int row = lower; row >= upper; row--)
                    res.add(matrix[row][left]);
                left++;
            }
        }
        // return
        return res;
    }
}
