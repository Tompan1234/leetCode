package leetcode.editor.cn;

public class ContainerWithMostWater{
    public static void main(String[] args) {
           Solution solution = new ContainerWithMostWater().new Solution();
      }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maxArea(int[] height) {

        int i=0,j=height.length-1;
        int ans = 0;
        while (i<j){
            //height[i],height[j]最小数决定容器上限  j-i是高度
            ans = Math.max(ans,Math.min(height[i],height[j])*(j-i));

            //谁小，谁缩
            if(height[i] < height[j]) i++; else  j--;
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}