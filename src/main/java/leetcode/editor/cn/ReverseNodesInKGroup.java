package leetcode.editor.cn;

public class ReverseNodesInKGroup{
    public static void main(String[] args) {
           Solution solution = new ReverseNodesInKGroup().new Solution();
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
    public ListNode reverseKGroup(ListNode head, int k) {

        ListNode protect = new ListNode(0, head);
        ListNode last = protect;

        while (head != null){
            //1.分组，一组的结尾就是下一组的开头pre
            ListNode end = getEnd(head, k);
            if(end == null){
                //end为null，不够一组，跳出不反转
                break;
            }
            //下一组的头节点
            ListNode nextGroupHead = end.next;
            //2.各个组反转
            reverseList(head,nextGroupHead);

            //3.更新前一组后一组的next，pre
            last.next = end;
            head.next = nextGroupHead;
            last = head;
            head = nextGroupHead;

        }
        return protect.next;
    }


    private ListNode getEnd(ListNode root, int k){
        while (root != null){
            k--;
            if(k==0){
                return root;
            }
            root = root.next;
        }
        return null;
    }

    //反转的是一组，所以要有head，和end
    private void reverseList(ListNode head,ListNode end){
        ListNode last = head;
        head = head.next;
        while (head != end){
            ListNode nextHead = head.next;
            head.next = last;
            last = head;
            head = nextHead;
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}