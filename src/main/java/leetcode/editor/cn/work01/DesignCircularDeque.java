package leetcode.editor.cn.work01;

public class DesignCircularDeque{
    public static void main(String[] args) {
//           Solution solution = new DesignCircularDeque().new Solution();
        MyCircularDeque circularDeque = new MyCircularDeque(3); // 设置容量大小为3
        circularDeque.insertLast(1);			        // 返回 true
        circularDeque.insertLast(2);			        // 返回 true
        circularDeque.insertFront(3);			        // 返回 true
        circularDeque.insertFront(4);			        // 已经满了，返回 false
        circularDeque.getRear();  				// 返回 2
        circularDeque.isFull();				        // 返回 true
        circularDeque.deleteLast();			        // 返回 true
        circularDeque.insertFront(4);			        // 返回 true
        circularDeque.getFront();				// 返回 4
    }
//leetcode submit region begin(Prohibit modification and deletion)
static class MyCircularDeque {

        private int capacity;
        private int head;
        private int tail;
        private int[] arr;

    public MyCircularDeque(int k) {
        capacity = k+1;
        arr = new int[capacity];
        head = 0;
        tail = 0;
    }
    
    public boolean insertFront(int value) {
        if(isFull()){
            return false;
        }
        //head始终指向队首位置
        head = (head-1+capacity)%capacity;
        arr[head] = value;
        return true;
    }
    
    public boolean insertLast(int value) {
        if(isFull()){
            return false;
        }
        arr[tail] = value;
        //tail始终指向当前队尾的下一个位置，就是下一个元素入队的位置
        tail = (tail+1+capacity)%capacity;
        return true;
    }
    
    public boolean deleteFront() {
        if(isEmpty()){
          return false;
        }
        //删除的时候就把指针向后移动以为即可，旧元素会被新入队的覆盖
        head = (head+1)%capacity;
        return true;
    }
    
    public boolean deleteLast() {
        if(isEmpty()){
            return false;
        }
        //队尾删除就往前移动
        tail = (tail-1+capacity)%capacity;
        return true;
    }
    
    public int getFront() {
        if(isEmpty()){
            return -1;
        }
        return arr[head];
    }
    
    public int getRear() {
        if(isEmpty()){
            return -1;
        }
        //队尾取数时，注意tail为0时数组越界
        return arr[(tail-1+capacity)%capacity];
    }
    
    public boolean isEmpty() {
        //维护两个元素，靠这两个元素作为数组下标，下标一致时，判定为空
        return head == tail;
    }
    
    public boolean isFull() {
        //首尾下标相差一个时判定full，数组的长度比k大1
        //维护首尾坐标，来判定是不是空，或者full
        return (tail +1)%capacity == head;
    }
}

/**
 * Your MyCircularDeque object will be instantiated and called as such:
 * MyCircularDeque obj = new MyCircularDeque(k);
 * boolean param_1 = obj.insertFront(value);
 * boolean param_2 = obj.insertLast(value);
 * boolean param_3 = obj.deleteFront();
 * boolean param_4 = obj.deleteLast();
 * int param_5 = obj.getFront();
 * int param_6 = obj.getRear();
 * boolean param_7 = obj.isEmpty();
 * boolean param_8 = obj.isFull();
 */
//leetcode submit region end(Prohibit modification and deletion)

}