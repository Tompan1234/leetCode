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

    //在双向链表的实现中，使用一个伪头部（dummy head）和伪尾部（dummy tail）标记界限，这样在添加节点和删除节点的时候就不需要检查相邻的节点是否存在。
    public LRUCache(int capacity) {
        this.capacity = capacity;
        start = new LinkedNode();
        end = new LinkedNode();
        start.next = end;
        end.pre = start;
    }

    /**
     * 如果 key 不存在，则返回 -1−1；
     * 如果 key 存在，则 key 对应的节点是最近被使用的节点。通过哈希表定位到该节点在双向链表中的位置，并将其移动到双向链表的头部，最后返回该节点的值。
     * @param key
     * @return
     */
    public int get(int key) {
        if(map.containsKey(key)){
            LinkedNode linkedNode = map.get(key);
            moveToStart(linkedNode);
            return linkedNode.val;
        }
        return -1;
    }


    /**
     * 如果 key 不存在，使用 key 和 value 创建一个新的节点，在双向链表的头部添加该节点，并将 key 和该节点添加进哈希表中。然后判断双向链表的节点数是否超出容量，如果超出容量，则删除双向链表的尾部节点，并删除哈希表中对应的项。
     * 如果 key 存在，则与 get 操作类似，先通过哈希表定位，再将对应的节点的值更新为 value，并将该节点移到双向链表的头部。
     * @param key
     * @param value
     */
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

    /**
     * 注意前后指针指向
     *          <--             <--
     *  start            node            end
     *          -->             -->
     * @param node
     */
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