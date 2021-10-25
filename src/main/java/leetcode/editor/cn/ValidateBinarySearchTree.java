package leetcode.editor.cn;

public class ValidateBinarySearchTree{
    public static void main(String[] args) {
           Solution solution = new ValidateBinarySearchTree().new Solution();
        TreeNode treeNode = new TreeNode(2);
        treeNode.left = new TreeNode(1);
        treeNode.right = new TreeNode(3);
        solution.isValidBST(treeNode);
    }
//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    Integer prev = Integer.MAX_VALUE;
    public boolean isValidBST(TreeNode root) {
        if(root == null){
            return true;
        }

        if(!isValidBST(root.left)){
            return false;
        }

        if(root.val<=prev){
            return false;
        }
        prev = root.val;
        return isValidBST(root.right);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}