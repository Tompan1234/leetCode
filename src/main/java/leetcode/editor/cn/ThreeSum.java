package leetcode.editor.cn;

import javax.xml.transform.Source;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum{
    public static void main(String[] args) {
           Solution solution = new ThreeSum().new Solution();
           int[] nums ={-1,0,1,2,-1,-4};
        List<List<Integer>> lists = solution.threeSum(nums);
        System.out.println("asdasdasda");
    }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        for(int i =0;i<nums.length;i++){
            if(i>0&&nums[i]==nums[i-1]) continue;
            List<List<Integer>> two = twoSum(nums,i+1,-nums[i]);
            for(List<Integer> list : two){
                List<Integer> list1 = new ArrayList<>();
                list1.add(list.get(0));
                list1.add(list.get(1));
                list1.add(nums[i]);
                ans.add(list1);
            }
        }
        return ans;
    }
    private List<List<Integer>> twoSum(int[] nums,int start,int target){
        List<List<Integer>> ans = new ArrayList<>();
        int j = nums.length-1;
        for(int i = start; i<nums.length;i++){
            if(i>start&&nums[i]==nums[i-1]) continue;
            while(i<j && nums[i]+nums[j]>target) j--;
            if(i<j && nums[i]+nums[j]==target){
                List<Integer> list = new ArrayList<>();
                list.add(nums[i]);
                list.add(nums[j]);
                ans.add(list);
            }
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}