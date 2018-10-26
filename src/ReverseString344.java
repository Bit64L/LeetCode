import org.junit.Test;

public class ReverseString344 {
    public String reverseString(String s) {
        StringBuilder str = new StringBuilder(s);
        int i = 0, j = s.length()-1;
        while(i<j){
            char tmp = s.charAt(i);
            str.setCharAt(i,str.charAt(j));
            str.setCharAt(j,tmp);
            i++;
            j--;
        }
        return str.toString();
    }

    @Test
    public void test(){
        System.out.println(reverseString("A man, a plan, a canal: Panama"));
    }
}
