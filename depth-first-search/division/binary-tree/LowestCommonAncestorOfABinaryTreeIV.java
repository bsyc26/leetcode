// leetcode 1676
// dfs:division
// T: O(N*M) // N: num of nodes in binary tree, M: nodes.length
// S: O(H) // H: height of binary tree // call-stack

class Solution {
    /** Return the LCA of nodes[], all exist and distinct with uniq vals */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode[] nodes) {
        return dfs(root, nodes); 
    }

    /** Return the LCA of nodes[] */
    private TreeNode dfs(TreeNode node, TreeNode[] nodes) {
        // base case
        if (node == null)
            return null;
        // pre order
        for (TreeNode target : nodes) { // is nodes[i]
            if (node == target)
                return node;
        }
        // division
        TreeNode left = dfs(node.left, nodes);
        TreeNode right = dfs(node.right, nodes);
        // post order
        if (left != null && right != null) // is LCA
            return node;
        return (left != null) ? left : right;
    }
}
