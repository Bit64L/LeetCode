import org.junit.Test;

public class DecodeString394 {
    public String decodeString(String s) {
        if(s == null || s.length() == 0) return "";
        return dfs(0, s);
    }

    public String dfs(int k, String str){

        StringBuilder sb = new StringBuilder();
        int count = 0;
        for(int i = k; i < str.length(); i++){
            if(str.charAt(i) >= '0' && str.charAt(i) <='9'){
                count = count * 10 + str.charAt(i) - '0';
            }else if(str.charAt(i) == '['){
                String tmp = dfs(i + 1, str);
                for(int j = 0; j < count; j++) sb.append(tmp);
                i += tmp.length() + 1;
                count = 0;
            }else if(str.charAt(i) == ']'){
                return sb.toString();
            }else{
                sb.append(str.charAt(i));
            }
        }
        return sb.toString();

    }

    @Test
    public void test(){
        decodeString("3[a]2[bc]");
    }
}

