package leetcode.editor.cn;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution1 {

    public static int trap(int[] height) {
        int res = 0;
        int left_max = 0;
        int[] right_max = new int[height.length];

        //找出当前列右边最大值
        for(int k = height.length-2; k>=0; k--){
            right_max[k] = Math.max(height[k+1], right_max[k+1]);
        }

        for (int i = 1; i < height.length-1; i++) {
            //找出当前列左边最大值
            left_max = Math.max(left_max,height[i-1]);
            int min = Math.min(left_max, right_max[i]);
            //当前列 < Math.min(左边最大值，右边最大值)做累加
            if(height[i] < min){
                res += (min - height[i]);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] height = {0,1,0,2,1,0,1,3,2,1,2,1};
        int trap = trap(height);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
