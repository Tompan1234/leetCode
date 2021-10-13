package leetcode.editor.cn;

import java.util.*;
import java.util.stream.Collectors;

public class GroupAnagrams{
    public static void main(String[] args) {
            String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
           Solution solution = new GroupAnagrams().new Solution();
        List<List<String>> lists = solution.groupAnagrams(strs);

    }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
/**
 * 输入: strs = ["eat", "tea", "tan", "ate", "nat", "bat"]
 * 输出: [["bat"],["nat","tan"],["ate","eat","tea"]]
 *
 * 输入: strs = [""]
 * 输出: [[""]]
 *
 * 输入: strs = ["a"]
 * 输出: [["a"]]
 */
        HashMap<String, List<String>> map = new HashMap<>();
        for(String str:strs){
            String copy = str;
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String s = new String(chars);
//            if(map.containsKey(s)){
//                List<String> list1 = map.get(s);
//                list1.add(copy);
//            }else{
//                List<String> list = new ArrayList<>();
//                list.add(copy);
//                map.put(s,list);
//            }
            List<String> orDefault = map.getOrDefault(s, new ArrayList<>());
            orDefault.add(copy);
            map.put(s,orDefault);
        }
        return map.values().stream().collect(Collectors.toList());
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}