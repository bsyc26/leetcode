// leetcode 938
// dfs:division + bst
// T: O(N) // N: num of nodes in bst
// S: O(H) // H: height of bst

class Solution {
    /** Return the sum of node vals within [low, high] */
    public int rangeSumBST(TreeNode root, int low, int high) {
        // base case
        if (root == null)
            return 0;
        // dfs
        if (root.val < low)
            return rangeSumBST(root.right, low, high);
        else if (root.val > high)
            return rangeSumBST(root.left, low, high);
        else
            return root.val
                + rangeSumBST(root.left, low, high)
                + rangeSumBST(root.right, low, high);
    }
}
