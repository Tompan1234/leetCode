package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

public class Subsets{
    public static void main(String[] args) {
           Solution solution = new Subsets().new Solution();
      }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        ArrayList<List<Integer>> ans = new ArrayList<>();
        recur(0,nums,ans,new ArrayList<>());
        return ans;
    }


    private void recur(int i,int[] nums, List<List<Integer>> ans, List<Integer> temp){
        ans.add(new ArrayList<>(temp));
        for(int j = i; j<nums.length;j++){
            temp.add(nums[j]);
            recur(j+1,nums,ans,temp);
            temp.remove(temp.size()-1);
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}