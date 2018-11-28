import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RepeatedDNASequences187 {
    public List<String> findRepeatedDnaSequences(String s) {// O(N2) O(N)
        if(s == null || s.length() == 0) return new ArrayList<>();
        HashMap<String, Integer> map = new HashMap<>();
        for(int i=0;i<=s.length()-10;i++){
            String tmp = s.substring(i,i+10);
            map.put(tmp, map.getOrDefault(tmp, 0)+1);
        }
        List<String> res = new ArrayList<>();
        for(Map.Entry<String,Integer> entry:map.entrySet()){
            if(entry.getValue() > 1)
                res.add(entry.getKey());
        }
        return res;
    }

    public List<String> findRepeatedDnaSequences1(String s) {
        if(s == null || s.length() == 0) return new ArrayList<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        int[] arr = new int[26];
        arr['A'-'A'] = 0;
        arr['C'-'A'] = 1;
        arr['G'-'A'] = 2;
        arr['T'-'A'] = 3;
        List<String> res = new ArrayList<>();
        for(int i=0;i<=s.length()-10;i++){
            int tmp = 0;
            for(int j=i;j<i+10;j++){
                tmp |= arr[s.charAt(j)-'A'] << ((j-i)*2);
            }
            if(map.containsKey(tmp)){
                if(map.get(tmp) == 1)
                    res.add(s.substring(i,i+10));
                map.put(tmp, map.get(tmp) + 1);
            }else{
                map.put(tmp,1);
            }
        }
        return res;
    }
}
