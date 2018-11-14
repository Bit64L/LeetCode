import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TextJustification68 {
    public List<String> fullJustify(String[] words, int maxWidth) {//需要挺多边界条件要考虑
        List<String> res = new ArrayList<>();
        if (words == null || words.length == 0)
            return res;
        int i = 0;
        while (i < words.length) {
            int j = i + 1;
            int length = words[i].length();
            while (j < words.length && length + words[j].length() + (j - i) <= maxWidth) {
                length += words[j++].length();
            }
            boolean lastLine = j == words.length;
            boolean oneWord = j == i + 1;
            int average = (lastLine || oneWord) ? 1 : (maxWidth - length) / (j - i - 1);
            int extra = (lastLine || oneWord) ? 0 : (maxWidth - length) % (j - i - 1);
            StringBuilder tmp = new StringBuilder(words[i]);
            for (int k = i+1; k < j; k++) {
                char[] interval = new char[extra > 0 ? average+1 : average];
                Arrays.fill(interval,' ');
                tmp.append(interval);
                tmp.append(words[k]);
                extra--;
            }
            while(tmp.length() < maxWidth) tmp.append(" ");
            res.add(tmp.toString());
            i = j;
        }
        return res;
    }

    @Test
    public void test() {
        String[] str = {"This", "is", "an", "example", "of", "text", "justification."};
        System.out.println(fullJustify(str, 16));
    }
}
