package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Sfvd7V{
    public static void main(String[] args) {
        String[] strs = {"eat","tea","tan","ate","nat","bat"};
           Solution solution = new Sfvd7V().new Solution();
        solution.groupAnagrams(strs);
      }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> resMap = new HashMap<>();
        for(String str : strs){
            int[] count = new int[26];
            for(int i = 0; i<str.length();i++){
                count[str.charAt(i) - 'a']++;
            }
            StringBuilder sb = new StringBuilder();
            for(int i = 0; i<26;i++){
                sb.append('#');
                sb.append(count[i]);
            }
            resMap.putIfAbsent(sb.toString(),new ArrayList<>());
            resMap.get(sb.toString()).add(str);
        }
        return new ArrayList<>(resMap.values());
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}