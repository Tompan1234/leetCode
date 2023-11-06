package leetcode.editor.cn;

public class ReverseLinkedList{
    public static void main(String[] args) {;
        Solution solution = new ReverseLinkedList().new Solution();
        solution.reverseList(ListNode.builder()
                        .val(1)
                        .next(ListNode.builder()
                                .val(2)
                                .next(ListNode.builder()
                                        .val(3)
                                        .next(ListNode.builder()
                                                .val(4)
                                                .next(ListNode.builder()
                                                        .val(5)
                                                        .build())
                                                .build())
                                        .build())
                                .build())
                .build());
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
    public ListNode reverseList(ListNode head) {

        if(head == null || head.next==null){
            return head;
        }

        ListNode listNode = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return listNode;

    }
}
//leetcode submit region end(Prohibit modification and deletion)

}