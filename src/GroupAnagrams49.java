import java.util.*;

public class GroupAnagrams49 {
    public List<List<String>> groupAnagrams(String[] strs) {
        if(strs == null || strs.length == 0) return new ArrayList<>();
        List<List<String>> res = new ArrayList<>();
        Map<String, List<String>> map = new HashMap<>();
        for(int i = 0; i < strs.length; i++){
            char[] chars = strs[i].toCharArray();
            Arrays.sort(chars);
            String tmp = new String(chars);
            if(map.containsKey(tmp)){
                map.get(tmp).add(strs[i]);
            }else{
                map.put(tmp, new ArrayList<>());
                map.get(tmp).add(strs[i]);
            }
        }
        return new ArrayList<>(map.values());
    }
}

/*
相同字母序列的全排列，可以将排好序的那个排列作为键值，将所有可能产生的排列都放入list中
 */