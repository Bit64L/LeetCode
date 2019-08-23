package test;

import java.util.HashMap;
import java.util.Map;

public class Test {
    @org.junit.Test
    public void test() {
        Map<String, String> map = new HashMap<>();
        map.put("123", "123");
        System.out.println(map.get("32"));

        String str = "dir\n\tsubdir1\n\tsubdir2\n\t\tfile.ext";
        String[] strs1 = str.split("\n");
        String[] strs2 = str.split("\\n");
        System.out.println("");

    }

}
