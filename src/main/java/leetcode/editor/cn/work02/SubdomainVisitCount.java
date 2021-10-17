package leetcode.editor.cn.work02;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SubdomainVisitCount{
    public static void main(String[] args) {
        Solution solution = new SubdomainVisitCount().new Solution();


        String[] str = {"901 discuss.leetcode.com"};
        List<String> list = solution.subdomainVisits(str);

    }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<String> subdomainVisits(String[] cpdomains) {
        HashMap<String, Integer> map = new HashMap<>();
        List<String> list = new ArrayList<>();
        for(String str:cpdomains){
            String[] s = str.split(" ");
            Integer count = Integer.valueOf(s[0]);
            String[] split = s[1].split("\\.");
            String append = "";
            for(int i =split.length-1;i>=0;i--){
                append = split[i]+(i<split.length-1?".":"")+append;
                map.put(append,map.getOrDefault(append,0)+count);
            }
        }
        for(Map.Entry<String,Integer> entry : map.entrySet()){
            list.add(""+entry.getValue()+" "+entry.getKey());
        }
        return list;
    }


    /**
     * discuss.leetcode.com
     * 域名可拆分两个子域名，加自己共三个
     * @param str
     * @return
     */
    private List<String> stringOfSplit(String str){
        ArrayList<String> strs = new ArrayList<>();
        String[] split = str.split("\\.");
        String append = "";
        for(int i =split.length-1;i>=0;i--){
            append = split[i]+(i<split.length-1?".":"")+append;
            strs.add(append);
        }
        return strs;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}