package leetcode.editor.cn;
//给定一个二叉树，判断它是否是高度平衡的二叉树。
//
// 本题中，一棵高度平衡二叉树定义为： 
//
// 
// 一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1 。 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：root = [3,9,20,null,null,15,7]
//输出：true
// 
//
// 示例 2： 
//
// 
//输入：root = [1,2,2,3,3,null,null,4,4]
//输出：false
// 
//
// 示例 3： 
//
// 
//输入：root = []
//输出：true
// 
//
// 
//
// 提示： 
//
// 
// 树中的节点数在范围 [0, 5000] 内 
// -10⁴ <= Node.val <= 10⁴ 
// 
// Related Topics 树 深度优先搜索 二叉树 👍 767 👎 0


//leetcode submit region begin(Prohibit modification and deletion)

/**
 * 平衡二叉树定义是：二叉树的每一个节点的左右子树的高度差的绝对值不超过1，则二叉树是平衡二叉树
 * 一颗二叉树是平衡的，当且仅当其所有子树也都是平衡二叉树
 */
class SolutionIsBalanced {
    public boolean isBalanced(TreeNode root) {
        if(root ==null){
            return true;
        }else{
            return Math.abs(height(root.left)-height(root.right)) <=1
                    && isBalanced(root.left) && isBalanced(root.right);
        }
    }

    /**
     * 自顶向下
     * @param root
     * @return
     */
    private int height(TreeNode root){
        if(root ==null){
            return 0;
        }
        return Math.max(height(root.left),height(root.right))+1;
    }


    public boolean isBalanced1(TreeNode root) {
        return height1(root)>=0;
    }

    /**
     * 自底向上
     * @param root
     * @return
     */
    private int height1(TreeNode root){
        if(root == null){
            return 0;
        }
        int leftHeight , rightHeight ;
        if((leftHeight = height1(root.left))==-1
        || (rightHeight = height1(root.right)) ==-1
                ||Math.abs(leftHeight-rightHeight) >1
        )
            return -1;
        return Math.max(leftHeight,rightHeight)+1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
