package leetcode.editor.cn;

import com.sun.tools.javac.util.ArrayUtils;

import java.util.Arrays;

public class MaximumSubarray{
    public static void main(String[] args) {
            int[] nums = {-1};

           Solution solution = new MaximumSubarray().new Solution();
        System.out.println(solution.maxSubArray(nums));
      }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    /**
     * 贪心
     * @param nums
     * @return
     */
    public int maxSubArray1(int[] nums) {
        int sum = 0,max = nums[0];
        for(int i : nums){
           if(sum<0){
               sum = i;
           }else {
               sum+=i;
           }
           max = Math.max(sum,max);
        }
        return max;
    }

    /**
     * 动态规划
     * @param nums
     * @return
     */
    public int maxSubArray(int[] nums){
        int max = nums[0];
        int prev = 0;
        for(int i:nums){
            prev = Math.max(prev+i,i);
            max = Math.max(max,prev);
        }
        return max;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}