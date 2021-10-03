package leetcode.editor.cn;

import lombok.Builder;
import lombok.Data;

/**
 * @author panjihang
 * @Description TODO
 * @Date 2021/9/29 2:22 下午
 */
@Data
@Builder
public class ListNode {

    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
