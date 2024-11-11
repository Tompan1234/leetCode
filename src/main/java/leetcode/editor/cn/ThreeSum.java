package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum{
    public static void main(String[] args) {
           Solution solution = new ThreeSum().new Solution();
           int[] nums = {-1, 0, 1, 2, -1, -4};
           solution.threeSum(nums);
      }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        if (nums == null || nums.length == 0 || nums.length == 1) {
            return null;
        }
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int left = i+1, right = nums.length - 1;
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            while (left < right) {
                int sum = nums[left] + nums[right] + nums[i];
                if (sum > 0) {
                    right--;
                } else if (sum < 0) {
                    left++;
                } else {
                    List<Integer> res = new ArrayList<>();
                    res.add(nums[i]);
                    res.add(nums[left]);
                    res.add(nums[right]);
                    ans.add(res);
                    while (left < right && nums[left] == nums[left + 1]) {
                        left++;
                    }
                    while (left < right && nums[right] == nums[right - 1]) {
                        right--;
                    }
                    left++;
                    right--;
                }
            }
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}