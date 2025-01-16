// leetcode 236
// dfs:division
// T: O(N) // N: num of nodes in binary tree
// S: O(1)

class Solution {
    /** Return the LCA of p and q existing in binary tree where node's vals are uniq */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        return dfs(root, p, q);
    }

    /** Return the LCA of p and q */
    private TreeNode dfs(TreeNode node, TreeNode p, TreeNode q) {
        // base case
        if (node == null)
            return null;
        // division
        TreeNode left = dfs(node.left, p, q);
        TreeNode right = dfs(node.right, p, q);
        // post order
        if (left != null && right != null) // is LCA
            return node;
        if (node == p || node == q) // is either p or q
            return node;
        return (left != null) ? left : right;
    }
}
