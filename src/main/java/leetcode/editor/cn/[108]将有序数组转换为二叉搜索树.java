package leetcode.editor.cn;
//给你一个整数数组 nums ，其中元素已经按 升序 排列，请你将其转换为一棵 高度平衡 二叉搜索树。
//
// 高度平衡 二叉树是一棵满足「每个节点的左右两个子树的高度差的绝对值不超过 1 」的二叉树。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [-10,-3,0,5,9]
//输出：[0,-3,9,-10,null,5]
//解释：[0,-10,5,null,-3,null,9] 也将被视为正确答案：
//
// 
//
// 示例 2： 
//
// 
//输入：nums = [1,3]
//输出：[3,1]
//解释：[1,3] 和 [3,1] 都是高度平衡二叉搜索树。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 10⁴ 
// -10⁴ <= nums[i] <= 10⁴ 
// nums 按 严格递增 顺序排列 
// 
// Related Topics 树 二叉搜索树 数组 分治 二叉树 👍 833 👎 0


//leetcode submit region begin(Prohibit modification and deletion)

import java.util.Random;

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
class SolutionSortedArrayToBST {
    public TreeNode sortedArrayToBST(int[] nums) {
        return helper2(nums,0,nums.length-1);
    }

    /**
     * 有序列表其实就是BST中序遍历 根节点就是数据中间的元素，左子树和右子树分别是对应的left -> mid-1， mid+1 > right
     * 递归遍历数组，封装树返出去
     * 根节点选择中间左边元素解题方法
     * @param nums 数组
     * @param left
     * @param right
     * @return 当left > right return
     */
    private TreeNode helper(int[] nums,int left, int right){
            if(left > right){
                return null;
            }
            int mid = (left+right)/ 2;
            TreeNode treeNode = new TreeNode(nums[mid]);
            treeNode.left = helper(nums,left,mid-1);
            treeNode.right = helper(nums,mid+1,right);
            return treeNode;
    }

    /**
     * 根节点为中间右边的元素解题方法
     * @param nums
     * @param left
     * @param right
     * @return
     */
    private TreeNode helper1(int[] nums,int left, int right){
        if(left>right){
            return null;
        }
        int mid = (left+right+1)/2;
        TreeNode treeNode = new TreeNode(nums[mid]);
        treeNode.left = helper1(nums,left,mid-1);
        treeNode.right = helper1(nums,mid+1,right);
        return treeNode;
    }

    /**
     * g根节点为中间随意元素
     * @param nums
     * @param left
     * @param right
     * @return
     */
    private TreeNode helper2(int[] nums,int left, int right){
        if(left>right){
            return null;
        }
        int mid = (left+right+new Random().nextInt(2))/2;
        TreeNode treeNode = new TreeNode(nums[mid]);
        treeNode.left = helper2(nums,left,mid-1);
        treeNode.right = helper2(nums,mid+1,right);
        return treeNode;
    }

}
//leetcode submit region end(Prohibit modification and deletion)
