import org.junit.Test;

import java.util.*;

public class WordLadder127 {
    public int ladderLength(String beginWord, String endWord, List<String> wordList){
        if(beginWord == null) return 0;
        Deque<String> q = new ArrayDeque<>();
        q.offer(beginWord);
        int step = 0; // 记录扩展到到第step层，以0为初值
        HashSet<String> set = new HashSet<>(wordList);// 直接用构造函数生成set，保证不重复访问同一个
        while(!q.isEmpty()){
            step++;
            for(int i = q.size();i>0;i--){//倒序是防止q.size()动态改变引起的bug
                String str = q.poll();
                for(int j=0;j<str.length();j++){
                    char c = str.charAt(j);
                    for(char k='a';k<='z';k++){
                        if(k==c) continue;//优化，扩展至于自己相同的word是无用的
                        String newStr = str.substring(0, j) + k + str.substring(j + 1);
                        if(!set.contains(newStr)) continue;
                        if(newStr.equals(endWord)) return step+1;
                        set.remove(newStr);
                        q.offer(newStr);
                    }
                }
            }
        }
        return 0;
    }

    @Test
    public void test(){
        List<String> list = new LinkedList<String>(){
            {
                add("hot");
                add("dog");
                add("lot");
                add("log");
                add("cog");
                add("dot");

            }

        };

        ladderLength("hit", "cog",  list);

    }
}
