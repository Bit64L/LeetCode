import org.junit.Test;

import java.util.HashSet;

public class ReverseVowelsofaString345 {
    public String reverseVowels(String s) {
        char[] chars = s.toCharArray();
        String str = "aeiouAEIOU";
        HashSet<String> set = new HashSet<>();
        for (int i = 0; i < str.length(); i++) {
            set.add(str.charAt(i) + "");
        }
        int i = 0, j = s.length() - 1;
        while (i < j) {
            while (i < s.length() && !set.contains(chars[i] + ""))
                i++;
            while (j>=0 && !set.contains(chars[j] + ""))
                j--;
            if (i < j) {
                char tmp = chars[i];
                chars[i] = chars[j];
                chars[j] = tmp;
                i++;
                j--;
            }
        }
        return new String(chars);
    }

    @Test
    public void test() {
        System.out.println(reverseVowels("OE"));
    }
}
