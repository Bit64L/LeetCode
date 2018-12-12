import common.Point;
import javafx.util.Pair;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;

public class MaxPointsonaLine149 {
    public int maxPoints(Point[] points) {//精度问题
        if (points == null || points.length == 0) return 0;
        if (points.length == 1) return 1;
        HashMap<Pair<Integer, Integer>, Integer> map = new HashMap<>();
        int res = Integer.MIN_VALUE;
        for (int i = 0; i < points.length; i++) {
            map.clear();
            int dup = 1;
            for (int j = i + 1; j < points.length; j++) {
                if (points[i].x == points[j].x && points[i].y == points[j].y) {
                    dup++;
                    continue;
                }
                Pair<Integer, Integer> k = getSlope(points[i].x, points[i].y, points[j].x, points[j].y);
                map.put(k, map.getOrDefault(k, 0) + 1);
            }
            if (map.size() != 0) {
                for (int count : map.values()) {
                    res = Math.max(res, count + dup);
                }
            }else{
                res = Math.max(res, dup);
            }

        }
        return res;
    }

    public Pair<Integer, Integer> getSlope(int x1, int y1, int x2, int y2) {
        int dx = x2 - x1, dy = y2 - y1;
        if (dx == 0) return new Pair<>(1, 0);
        if (dy == 0) return new Pair<>(0, 1);
        int gcd = gcd(dy, dx);
        return new Pair<>(dy / gcd, dx / gcd);
    }

    public int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }


    @Test
    public void test() {
        Point[] points = {
                new Point(0, 0),
                new Point(94911151, 94911150),
                new Point(94911152, 94911151)};
        System.out.println(maxPoints(points));

        ArrayList<Integer> arr = new ArrayList<>();
        arr.add(1);
        arr.add(2);
        ArrayList<Integer> arr1 = new ArrayList<>();
        arr1.add(2);
        arr1.add(1);
        System.out.println(arr1.equals(arr));
    }
}
