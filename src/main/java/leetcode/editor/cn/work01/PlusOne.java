package leetcode.editor.cn.work01;

import javax.jws.Oneway;
import javax.lang.model.element.VariableElement;
import java.util.Stack;
import java.util.Vector;

public class PlusOne{
    public static void main(String[] args) {
           Solution solution = new PlusOne().new Solution();
           int[] a = {9,9};
           int[] objects = solution.plusOne(a);
           for(int i = 0; i< objects.length;i++){
               System.out.println(objects[i]);
           }
    }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] plusOne(int[] digits) {
        //倒序+1，考虑到进位
        for(int i =digits.length-1; i>=0;i--){
            digits[i]++;
            digits[i] %= 10;
            if (digits[i]!=0) {
                //位数不变
                return digits;
            }
        }
        //进位增加位数
        digits = new int[digits.length + 1];
        digits[0] = 1;
        return digits;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}