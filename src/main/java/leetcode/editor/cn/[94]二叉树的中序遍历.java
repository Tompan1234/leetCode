package leetcode.editor.cn;
//给定一个二叉树的根节点 root ，返回它的 中序 遍历。
//
// 
//
// 示例 1： 
//
// 
//输入：root = [1,null,2,3]
//输出：[1,3,2]
// 
//
// 示例 2： 
//
// 
//输入：root = []
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：root = [1]
//输出：[1]
// 
//
// 示例 4： 
//
// 
//输入：root = [1,2]
//输出：[2,1]
// 
//
// 示例 5： 
//
// 
//输入：root = [1,null,2]
//输出：[1,2]
// 
//
// 
//
// 提示： 
//
// 
// 树中节点数目在范围 [0, 100] 内 
// -100 <= Node.val <= 100 
// 
//
// 
//
// 进阶: 递归算法很简单，你可以通过迭代算法完成吗？ 
// Related Topics 栈 树 深度优先搜索 二叉树 👍 1082 👎 0


//leetcode submit region begin(Prohibit modification and deletion)


import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Stack;
import java.util.regex.Pattern;

/**
 * 递归遍历，前序遍历：打印，左，右  中序遍历：左，打印，右  后序遍历：
 */
class Solution1 {
    public List<Integer> inorderTraversal(TreeNode root) {
        ArrayList<Integer> res = new ArrayList<>();
        inorder(root, res);
        return res;
    }

    public void inorder(TreeNode root, List<Integer> res) {
        if (Objects.isNull(root)) {
            return;
        }
        inorder(root.left, res);
        res.add(root.val);
        inorder(root.right, res);
    }

}

/**
 * 迭代实现递归模式
 */
class Solution2 {
    public List<Integer> inorderTraversal(TreeNode root) {
        ArrayList<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        while (!Objects.isNull(root) || stack.size()>0){
            //不断往左子节点走，每走一个就保存当节点到栈中
            if(!Objects.isNull(root)){
                stack.add(root);
                root = root.left;
            }else{
                //当前节点为null时，说明左子节点没有值，从栈中弹出上个节点并保存
                TreeNode pop = stack.pop();
                res.add(pop.val);
                //左子节点没有值，便从右边遍历
                root = pop.right;
            }
        }
        return res;
    }
}

/**
 * 莫里斯遍历：用递归和迭代方式都是用了辅助空间，而莫里斯遍历的优点是没有使用任何的辅助空间
 * 缺点是：改变了整个树的结构，强行把一颗二叉树改成链表结构
 */
class Solution3 {
    public List<Integer> inorderTraversal(TreeNode root) {
        ArrayList<Integer> res = new ArrayList<>();
        TreeNode pre = null;
        while (!Objects.isNull(root)){
            //如果做节点不为空，就把当前节点连带右子树全部挂到左节点的最右子树下面
            if(root.left!=null){
                pre = root.left;
                //找到当前节点的左节点的最右节点
                while (pre.right != null){
                    pre = pre.right;
                }
                pre.right = root;
                //将root指向root的left
                TreeNode tmp = root;
                root = root.left;
                tmp.left = null;
            }else{
                //左子树为空，则打印该节点，并向右遍历
                res.add(root.val);
                root = root.right;
            }
        }
        return res;
    }
}

//leetcode submit region end(Prohibit modification and deletion)

class RunMethod {
    public static void main(String[] args) {
//        TreeNode treeNode = new TreeNode(6);
//        treeNode.left = new TreeNode(2);
//        treeNode.left.left = new TreeNode(1);
//        treeNode.left.right = new TreeNode(4);
//        treeNode.left.right.left = new TreeNode(3);
//        treeNode.left.right.right = new TreeNode(5);
//        treeNode.right = new TreeNode(7);
//        List<Integer> integers = new Solution3().inorderTraversal(treeNode);
//        integers.stream().forEach(o -> System.out.println(o));


        Boolean aNull = getNull("0.0","0.0");
        System.out.println(aNull);


    }


    private static Boolean getNull(String lon, String lat){
        if (lon.startsWith("0") || lat.startsWith("0")) {
            return false;
        }
        return true;
    }

    public static boolean testGPS(String longitude ,String latitude){
        //经度： -180.0～+180.0（整数部分为0～180，必须输入1到8位小数）
        String longitudePattern="^[\\-\\+]?(0?\\d{1,2}\\.\\d{1,8}|1[0-7]?\\d{1}\\.\\d{1,8}|180\\.0{1,8})$";
        //纬度： -90.0～+90.0（整数部分为0～90，必须输入1到8位小数）
        String latitudePattern="^[\\-\\+]?([0-8]?\\d{1}\\.\\d{1,8}|90\\.0{1,8})$";
        boolean longitudeMatch = Pattern.matches(longitudePattern, longitude);
        boolean latitudeMatch = Pattern.matches(latitudePattern, latitude);
        if(longitudeMatch && latitudeMatch){
            return true;
        }
        return false;
    }

}
