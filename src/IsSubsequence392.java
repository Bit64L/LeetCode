public class IsSubsequence392 {
    public boolean isSubsequence(String s, String t) {
        if(s == null || s.length() == 0) return true;
        if(t == null || t.length() == 0) return false;
        int curr = 0;
        for(Character c : t.toCharArray()){
            if(c == s.charAt(curr)){
                curr++;
                if(curr == s.length()) break;
            }
        }
        if(curr == s.length()) return true;
        return false;
    }
}

/*
Caution that subSequence require the same order
 */