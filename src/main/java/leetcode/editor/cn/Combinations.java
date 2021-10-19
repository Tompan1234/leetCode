package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

public class Combinations{
    public static void main(String[] args) {
           Solution solution = new Combinations().new Solution();
      }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    ArrayList<List<Integer>> ans = new ArrayList<>();
    public List<List<Integer>> combine(int n, int k) {
        recur(n,k,1,new ArrayList<>());
        return ans;
    }

    private void recur(int n,int k, int start, List<Integer> temp){
        if(k==0){
            ans.add(new ArrayList<>(temp));
            return;
        }
        for(int j = start; j<=n-k+1;j++){
            temp.add(j);
            recur(n,k-1,j+1,temp);
            temp.remove(temp.size()-1);
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}