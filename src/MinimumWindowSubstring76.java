import org.junit.Test;

public class MinimumWindowSubstring76 {
    public String minWindow(String s, String t) {
        if(s == null || s.length() == 0)
            return "";
        if(s.length() < t.length())
            return "";
        int[] need = new int[256];
        int[] find = new int[256];
        for(int i=0;i<t.length();i++){
            need[t.charAt(i)]++;
        }
        int start, end, resStart=-1, resEnd=s.length(),count=0;
        for(start = 0, end = 0; end < s.length();end++){
            if(need[s.charAt(end)] == 0) continue;
            if(find[s.charAt(end)] < need[s.charAt(end)]){
                count++;
            }
            find[s.charAt(end)]++;
            if(count < t.length()) continue;

            for(;start < end; start++){
                if(need[s.charAt(start)] == 0) continue;
                if(find[s.charAt(start)] > need[s.charAt(start)]){
                    find[s.charAt(start)]--;
                }else{
                    break;
                }
            }
            if(end - start < resEnd - resStart){
                resStart = start;
                resEnd = end;
            }
        }

        return resStart==-1?"":s.substring(resStart,resEnd+1);
    }

    @Test
    public void test(){
        minWindow("ADOBECODEBANC", "ABC");
    }
}
