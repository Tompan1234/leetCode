package leetcode.editor.cn;

public class SLwz0R{
    public static void main(String[] args) {
           Solution solution = new SLwz0R().new Solution();
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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode fast = head;
        ListNode temp = new ListNode(0, head);
        ListNode slow = temp;
        for (int i = 0; i < n; i++) {
            fast = fast.next;
        }
        while (fast != null){
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        head = temp.next;
        return head;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}