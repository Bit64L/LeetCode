import org.junit.Test;

public class ReverseWordsinaString151 {
    public String reverseWords(String s) {
        if(s == null || s.length() == 0) return "";
        StringBuilder res = new StringBuilder();
        StringBuilder word = new StringBuilder();
        s = s.trim();
        for(int i = s.length() - 1; i >= 0; i--){
            if(s.charAt(i) != ' '){
                word.append(s.charAt(i));
            }else{
                if(s.charAt(i + 1) != ' '){
                    word.reverse();
                    res.append(word).append(" ");
                    word = new StringBuilder();
                }

            }
        }
        res.append(word.reverse());
        return res.toString();
    }


    @Test
    public void test(){
        //System.out.println(reverseWords(" "));
        String str =  "123   123";
        String[] strs = str.split("\\s");
        for(String str1 : strs){
            System.out.println(str1);
        }
    }
}
/*
解法一：模拟
解法二：使用split()。但是要正确理解正则表达式如何运行。
//s+ 匹配多个空格
//s 只匹配一个空格，其余的连续空格都将转换为空字符串
 */