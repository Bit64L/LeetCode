import org.junit.Test;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class DifferentWaystoAddParentheses241 {
    private Map<String, List<Integer>> map = new HashMap<>();

    public List<Integer> diffWaysToCompute(String input) {
        if (map.getOrDefault(input, null) != (null))
            return map.get(input);
        List<Integer> list = new LinkedList<>();
        for (int i = 0; i < input.length(); i++) {
            if ((input.charAt(i) == '+') || input.charAt(i) == '-' || input.charAt(i) == '*') {
                List<Integer> left = diffWaysToCompute(input.substring(0, i));
                List<Integer> right = diffWaysToCompute(input.substring(i + 1));
                for (int x : left) {
                    for (int y : right) {
                        if (input.charAt(i) == '+') {
                            list.add(x + y);
                        } else if (input.charAt(i) == '-') {
                            list.add(x - y);
                        } else if (input.charAt(i) == '*') {
                            list.add(x * y);
                        }
                    }
                }
            }
        }
        if (list.size() == 0) {
            list.add(Integer.parseInt(input));
        }
        map.put(input, list);
        return list;
    }

    @Test
    public void test() {
        String str = "2-1-1";
        List<Integer> list = diffWaysToCompute(str);
        System.out.println("");
    }
}
