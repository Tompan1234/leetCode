package leetcode.editor.cn;
//给定一个二叉树，检查它是否是镜像对称的。
//
// 
//
// 例如，二叉树 [1,2,2,3,4,4,3] 是对称的。 
//
//     1
//   / \
//  2   2
// / \ / \
//3  4 4  3
// 
//
// 
//
// 但是下面这个 [1,2,2,null,3,null,3] 则不是镜像对称的: 
//
//     1
//   / \
//  2   2
//   \   \
//   3    3
// 
//
// 
//
// 进阶： 
//
// 你可以运用递归和迭代两种方法解决这个问题吗？ 
// Related Topics 树 深度优先搜索 广度优先搜索 二叉树 👍 1520 👎 0


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
class SolutionIsSymmetric {
    public boolean isSymmetric(TreeNode root) {
        return root == null ? true : recur(root.left,root.right);
    }

    private Boolean recur(TreeNode left,TreeNode right){
        if(left ==null && right ==null){
            return true;
        }
        if(left == null|| right ==null || left.val != right.val){
            return false;
        }
        return recur(left.left,right.right) && recur(left.right,right.left);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
