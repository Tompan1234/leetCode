package leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

public class LruCache{
//    public static void main(String[] args) {
//           Solution solution = new LruCache().new Solution();
//      }
//leetcode submit region begin(Prohibit modification and deletion)
class LRUCache {
    private int capacity;
    private LinkedNode start,end;
    private Map<Integer,LinkedNode> map = new HashMap<>();

    public LRUCache(int capacity) {
        this.capacity = capacity;
        start = new LinkedNode();
        end = new LinkedNode();
        start.next = end;
        end.pre = start;
    }
    
    public int get(int key) {
        if(map.containsKey(key)){
            LinkedNode linkedNode = map.get(key);
            moveToStart(linkedNode);
            return linkedNode.val;
        }
        return -1;
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key)){
            LinkedNode linkedNode = map.get(key);
            linkedNode.val = value;
            moveToStart(linkedNode);
        }else{
            LinkedNode linkedNode = new LinkedNode(key, value);
            addToStart(linkedNode);
            map.put(key,linkedNode);
            if(map.size()>capacity){
                LinkedNode tail = removeEnd();
                map.remove(tail.key);
            }
        }
    }

    class LinkedNode{
        int key;
        int val;
        LinkedNode pre;
        LinkedNode next;
        public LinkedNode(){}
        public LinkedNode(int key,int val){
            this.key = key;
            this.val = val;
        }
    }

    private void addToStart(LinkedNode node){
        node.pre = start;
        node.next = start.next;
        start.next.pre = node;
        start.next = node;
    }

    private void removeNode(LinkedNode node){
        node.pre.next = node.next;
        node.next.pre = node.pre;
    }

    private void moveToStart(LinkedNode node){
        removeNode(node);
        addToStart(node);
    }

    private LinkedNode removeEnd(){
        LinkedNode tail = end.pre;
        removeNode(tail);
        return tail;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
//leetcode submit region end(Prohibit modification and deletion)

}