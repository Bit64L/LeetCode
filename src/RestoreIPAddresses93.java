import java.util.ArrayList;
import java.util.List;

public class RestoreIPAddresses93 {
    public List<String> restoreIpAddresses(String s) {
        List<String> res = new ArrayList<>();
        if(s == null || s.length() == 0) return res;
        backTrack(s, 0, 4, new ArrayList<>(), res);
        return res;
    }

    public void backTrack(String s, int start, int depth, List<String> path, List<String> res){
        if(depth == 1){
            String str = s.substring(start);
            if(isValid(str)){
                StringBuilder tmp = new StringBuilder();
                for(String part : path)  tmp.append(part).append(".");
                tmp.append(str);
                res.add(tmp.toString());
            }
            return;
        }

        StringBuilder sb= new StringBuilder();
        for(int i = start; i < start + 3 && i < s.length() - 1; i++){
            sb.append(s.charAt(i));
            if(isValid(sb.toString())){
                path.add(sb.toString());
                backTrack(s, i+1, depth - 1, path, res);
                path.remove(path.size() - 1);
            }

        }
    }
    public boolean isValid(String ipPart){
        if(ipPart.length() > 3 || Integer.parseInt(ipPart) > 255 ||
                (ipPart.length() > 1 && ipPart.charAt(0) == '0'))
            return false;
        return true;
    }
}

/*
BackTracking搜索ip的四部分即可
需要主要的是IP每部分有效的条件: 范围，无前导零
*/