import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class SubstringwithConcatenationofAllWords30 {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> res = new LinkedList<>();
        if(s == null || s.length()==0 || words == null || words.length==0) return res;
        HashMap<String, Integer> map = new HashMap<>();//usually used hashmap to count words for substring
        for(String str : words){
            map.put(str, map.getOrDefault(str,0)+1);
        }
        int m=words.length, n = words[0].length();
        for(int i=0;i<=s.length()-m*n;i++){
            HashMap<String, Integer> copy = new HashMap<>(map);
            int j;
            for(j = i;j<i+m*n;j+=n){// fixed step, prefer for-loop
                String str = s.substring(j,j+n);
                if(!copy.containsKey(str) || copy.get(str) < 1) break;
                copy.put(str, copy.get(str)-1);
            }
            if(j>=i+m*n) res.add(i);
        }
        return res;

    }
}
