// leetcode 235
// dfs:division
// T: O(logN) // N: num of nodes in binary tree
// S: O(1)

class Solution {
    /** Return the lowest common ancestor of node p and node q
      * all node's vals are uniq; node p and node q exist in bst; p != q */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // vars
        int pval = p.val;
        int qval = q.val;
        int max = Math.max(p.val, q.val);
        int min = Math.min(p.val, q.val);
        // return dfs
        return dfs(root, max, min); 
    }

    /** Return the LCA node of node p and node q */
    private TreeNode dfs(TreeNode node, int max, int min) {
        // base case
        if (node == null)
            return null;
        // division
        if (node.val > max)
            return dfs(node.left, max, min);
        if (node.val < min)
            return dfs(node.right, max, min);
        // post order
        return node; // is lca: min<= node.val <= max
    }
}
