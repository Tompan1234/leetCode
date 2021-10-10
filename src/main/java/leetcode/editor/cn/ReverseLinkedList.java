package leetcode.editor.cn;

public class ReverseLinkedList{
    public static void main(String[] args) {
           Solution solution = new ReverseLinkedList().new Solution();
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

        ListNode last = null;

        while (head != null){
            ListNode next = head.next;
            head.next = last;
            last = head;
            head = next;
        }
        return last;

    }
}
//leetcode submit region end(Prohibit modification and deletion)

}