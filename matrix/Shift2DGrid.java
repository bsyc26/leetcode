// leetcode 1260
// matrix:flatten
// T: O(MN) // M: grid.length, N: grid[0].length
// S: O(MN)

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

class Solution {
    /** Shift the grid[][] k times:
      * - grid[i][j] to grid[i][j+1]
      * - grid[i][N-1] to grid[i+1][0]
      * - grid[M-1][N-1] to grid[0][0] */
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        // const
        int M = grid.length;
        int N = grid[0].length;
        // res arr
        int[][] res = new int[M][N]; // k-shifted grid[][]
        // vars
        k = k % (M*N);
        // pass 
        for (int row = 0; row < M; row++) {
            for (int col = 0; col < N; col++) {
                int idx = (row*N + col + k) % (M*N); // flatten shifted idx 
                int newRow = idx / N;
                int newCol = idx % N;
                res[newRow][newCol] = grid[row][col];
            }
        }
        // return res list
        List<List<Integer>> resList = new ArrayList<>();
        for (int[] row : res)
            resList.add(Arrays.stream(row).boxed().toList());
        return resList;
    }
}
