package leetcode.editor.cn.work01;

public class MergeTwoSortedLists{
    public static void main(String[] args) {
           Solution solution = new MergeTwoSortedLists().new Solution();

        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(3);
        l1.next.next = new ListNode(5);

        ListNode l2 = new ListNode(2);
        l2.next = new ListNode(4);
        l2.next.next = new ListNode(6);

        solution.mergeTwoLists(l1,l2);
    }
//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {

    /**
     * 递归
     * time：O(m+n)
     * space: O(m+n)
     * @return
     */
//    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
//        if(l1 == null){
//            return l2;
//        }else if(l2 == null){
//            return l1;
//        }else if(l1.val < l2.val){
//            l1.next = mergeTwoLists(l1.next,l2);
//            return l1;
//        }else {
//            l2.next = mergeTwoLists(l2.next,l1);
//            return l2;
//        }
//    }


    /**
     * 迭代
     * time：O(m+n)
     * space：O(1)
     * @return
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2){

        //开保护节点
        ListNode protect = new ListNode(0);
        ListNode prev = protect;
        while (l1 != null && l2 != null){
            if(l1.val >= l2.val){
                prev.next = l2;
                l2 = l2.next;
            }else{
                prev.next = l1;
                l1 = l1.next;
            }
            prev = prev.next;
        }
        //main方法测试，某个链表最后一个节点挂不上
        prev.next = l1 == null?l2:l1;
        return protect.next;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}