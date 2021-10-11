package leetcode.editor.cn.work01;

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
    public ListNode() {}
    public ListNode(int val) { this.val = val; }
    public ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
