package leetcode.editor.cn.work02;

import java.util.HashMap;
import java.util.Map;

public class SubarraySumEqualsK{
    public static void main(String[] args) {
        int[] arr={3,4,7,2,-3,1,4,2};
        Solution solution = new SubarraySumEqualsK().new Solution();
        int i = solution.subarraySum(arr, 7);
        System.out.println(i);
    }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int subarraySum(int[] nums, int k) {
        //前缀和+map
        Integer pre = 0,count=0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0,1);//pre-k=0，pre为前缀和
        for(int i : nums){
            pre+=i;
            if(map.containsKey(pre-k)){
                count+=map.get(pre-k);
            }
            map.put(pre,map.getOrDefault(pre,0)+1);
        }
        return count;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}