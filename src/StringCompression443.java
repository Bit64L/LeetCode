import org.junit.Test;

public class StringCompression443 {
    public int compress(char[] chars) {
        if (chars == null || chars.length == 0) return 0;
        int i, index = 0, count = 0;
        for (i = 0; i < chars.length; i++) {
            count++;
            if (i==chars.length-1 || chars[i] != chars[i + 1]){
                chars[index++] = chars[i];
                if (count > 1) {
                    char[] str = String.valueOf(count).toCharArray();
                    for (int j = 0; j < str.length; j++)
                        chars[index++] = str[j];
                }
                count = 0;
            }
        }
        return index;
    }

    @Test
    public void test() {
        char[] chars = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'g', 'g', 'g', 'g', 'g', 'g', 'g', 'g', 'g', 'g', 'g', 'a', 'b', 'c'};
        compress(chars);
    }
}
