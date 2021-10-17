package leetcode.editor.cn.work02;

import java.util.HashMap;
import java.util.Map;

public class NumberOfSubmatricesThatSumToTarget{
    public static void main(String[] args) {
        Solution solution = new NumberOfSubmatricesThatSumToTarget().new Solution();
      }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    /**
     * 二维数组中元素和为目标值的子矩阵数量
     * 和上题 和为k的子数组相似，只不过这题时一维数组
     * 这时，解题思路就有了
     * 就是遍历二维数组，计算每列边界内的元素和，这样就可以调用 上题的代码了
     * @param matrix
     * @param target
     * @return
     */
    public int numSubmatrixSumTarget(int[][] matrix, int target) {
        int ans = 0;
        int m = matrix.length, n = matrix[0].length;
        for(int i=0; i<m;i++){//遍历上
            int[] sum = new int[n];
            for(int j=i;j<m;j++){//遍历下
                for(int c=0;c<n;c++){//把一列的元素累加到一维数组中
                    sum[c] +=matrix[j][c];
                }
                ans += subarraySum(sum,target);
            }
        }
        return ans;
    }


    private int subarraySum(int[] nums, int k) {
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