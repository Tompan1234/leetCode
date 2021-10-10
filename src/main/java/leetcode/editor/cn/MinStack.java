package leetcode.editor.cn;

import javax.lang.model.element.VariableElement;
import java.util.Stack;

//leetcode submit region begin(Prohibit modification and deletion)
class MinStack {

    Stack<Integer> s = new Stack<>();
    Stack<Integer> min = new Stack<>();
    public MinStack() {

    }
    
    public void push(int val) {
        s.push(val);
        if(min.isEmpty()){
            min.push(val);
        }else{
            min.push(Math.min(min.peek(),val));
        }
    }
    
    public void pop() {
        s.pop();
        min.pop();
    }
    
    public int top() {
        return s.peek();
    }
    
    public int getMin() {
        return min.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
//leetcode submit region end(Prohibit modification and deletion)

