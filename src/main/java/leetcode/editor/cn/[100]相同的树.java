package leetcode.editor.cn;
//给你两棵二叉树的根节点 p 和 q ，编写一个函数来检验这两棵树是否相同。
//
// 如果两个树在结构上相同，并且节点具有相同的值，则认为它们是相同的。 
//
// 
//
// 示例 1： 
//
// 
//输入：p = [1,2,3], q = [1,2,3]
//输出：true
// 
//
// 示例 2： 
//
// 
//输入：p = [1,2], q = [1,null,2]
//输出：false
// 
//
// 示例 3： 
//
// 
//输入：p = [1,2,1], q = [1,1,2]
//输出：false
// 
//
// 
//
// 提示： 
//
// 
// 两棵树上的节点数目都在范围 [0, 100] 内 
// -10⁴ <= Node.val <= 10⁴ 
// 
// Related Topics 树 深度优先搜索 广度优先搜索 二叉树 👍 676 👎 0


//leetcode submit region begin(Prohibit modification and deletion)


import java.util.LinkedList;
import java.util.Queue;

/**
 * DFS：深度优先遍历
 */
class Solution4 {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p == null && q == null){
            return true;
        }else if(p ==null || q ==null){
            return false;
        }else if(p.val != q.val){
            return false;
        }else {
            return isSameTree(p.left,q.left) && isSameTree(p.right,q.right);
        }
    }
}

/**
 * DFS优化
 */
class Solution5{
    public boolean isSameTree(TreeNode p,TreeNode q){
        if(p ==null)
        return q ==null;
        return q != null
                && p.val == q.val
                && isSameTree(p.left,q.left)
                && isSameTree(p.right,q.right);
    }
}

/**
 * BFS：广度优先遍历
 */
class Solution6{
    public boolean isSameTree(TreeNode p,TreeNode q){
        if(p ==null && q ==null){
            return true;
        }else if(p ==null || q==null){
            return false;
        }
        Queue<TreeNode> queue1 = new LinkedList<>();
        Queue<TreeNode> queue2 = new LinkedList<>();
        queue1.offer(p);
        queue2.offer(q);
        while(!queue1.isEmpty() && !queue2.isEmpty()){
            TreeNode node1 = queue1.poll();
            TreeNode node2 = queue2.poll();
            if(node1.val != node2.val){
                return false;
            }
            TreeNode left1 = node1.left,right1 = node1.right, left2 = node2.left, right2 = node2.right;
            if(left1 == null ^ left2 ==null){
                return false;
            }
            if(right1 ==null ^ right2 ==null){
                return false;
            }
            if(left1!=null){
                queue1.offer(left1);
            }
            if(right1 !=null){
                queue1.offer(right1);
            }
            if(left2 !=null){
                queue2.offer(left2);
            }
            if(right2 !=null){
                queue2.offer(right2);
            }
        }
        return queue1.isEmpty() && queue2.isEmpty();
    }
}
//leetcode submit region end(Prohibit modification and deletion)
