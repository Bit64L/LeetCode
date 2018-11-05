import org.junit.Test;

public class ZigZagConversion6 {
    public String convert(String s, int numRows) {
        if (s == null || s.length() == 0)
            return "";
        int diff = (numRows - 1) << 1;
        if (diff == 0)
            return s;
        int row = 0;
        StringBuilder res = new StringBuilder();
        while (row < numRows) {
            for (int i = row; i < s.length(); i += diff) {
                res.append(s.charAt(i));
                if (row > 0 && row < numRows - 1) {
                    if (i + diff - row*2 < s.length())
                        res.append(s.charAt(i + diff - row * 2));
                }
            }
            row++;
        }
        return res.toString();
    }

    @Test
    public void test() {
        System.out.println(convert("ABCD", 3));
    }
}
