package leetcode.editor.cn.work02;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class DegreeOfAnArray{
    public static void main(String[] args) {
        int[] arr = {1,2,2,3,1,4,2};
        Solution solution = new DegreeOfAnArray().new Solution();
        int shortestSubArray = solution.findShortestSubArray(arr);
        System.out.println(shortestSubArray);
    }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int findShortestSubArray(int[] nums) {
        //元素开始下标
        Map<Integer,Integer> left = new HashMap<>();
        //元素结束下标
        Map<Integer,Integer> right = new HashMap<>();
        //元素出现次数
        Map<Integer,Integer> counts = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            if(counts.containsKey(nums[i])){
                Integer integer = counts.get(nums[i]);
                integer++;
                counts.put(nums[i],integer);
                right.put(nums[i],i);
            }else{
                counts.put(nums[i],1);
                left.put(nums[i],i);
                right.put(nums[i],i);
            }
        }

        //找出数组的度的元素
        ArrayList<Integer> list = new ArrayList<>();
        Integer maxValue = counts.values().stream().max((o1, o2) -> o1 > o2 ? 1 : -1).get();
        for(Map.Entry<Integer,Integer> entry:counts.entrySet()){
            if(maxValue.equals(entry.getValue())){
                list.add(entry.getKey());
            }
        }

        //算出最短连续子数组，子数组必须包含相同度的元素,即只需要计算结束-开始+1中找最小
        int ans = Integer.MAX_VALUE;
        for(Integer i:list){
            ans = Math.min(ans,right.get(i)-left.get(i)+1);
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}