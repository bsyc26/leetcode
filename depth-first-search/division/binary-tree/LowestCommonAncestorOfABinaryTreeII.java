// leetcode 1644
// dfs:division
// T: O(N) // N: num of nodes of binary tree
// S: O(H) // H: height of binary tree // call-stack

class Solution { // extra boolean flags
    // fields
    private boolean foundP = false;
    private boolean foundQ = false;

    /** Return the LCA of p and q only when both exist in binary tree */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode lca = dfs(root, p, q); 
        return (foundP && foundQ) ? lca : null;
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
        if (left != null && right != null) // case: is LCA
            return node;
        // ! cannot be placed in pre order case p or q is in the other's sub-tree
        if (node == p) { // case: is p
            foundP = true;
            return node;
        }
        if (node == q) { // case: is q
            foundQ = true;
            return node;
        }
        return (left != null) ? left : right;
    }
}

// follow-up: no-flag
// dfs:division
// T: O(N) // N: num of nodes of binary tree
// S: O(H) // H: height of binary tree // call-stack

class Solution { // no-flag
    /** Return the LCA of p and q only when both exist in binary tree */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // edge case
        if (root == null || p == null || q == null)
            return null;
        // dfs:division
        TreeNode lca = dfs(root, p, q);
        // case: lca is p || lca is q -> search the other in subtree
        if (lca == p)
            return (dfs(p, q, q) != null) ? p : null;
        else if (lca == q)
            return (dfs(q, p, p) != null) ? q : null;
        // case: lca is not p or q
        return lca;
    }

    /** Return the LCA */
    private TreeNode dfs(TreeNode node, TreeNode p, TreeNode q) {
        // base case
        if (node == null)
            return null;
        // pre order
        if (node == p || node == q) // is node p or q
            return node;
        // division
        TreeNode left = dfs(node.left, p, q);
        TreeNode right = dfs(node.right, p, q);
        // post order
        if (left != null && right != null) // is LCA
            return node;
        return (left != null) ? left : right;
    }
}
