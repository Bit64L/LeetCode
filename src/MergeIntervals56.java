import common.Interval;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class MergeIntervals56 {
    public List<Interval> merge(List<Interval> intervals) {
        if(intervals == null  || intervals.size() == 0) return new ArrayList<>();
        Collections.sort(intervals, new Comparator<Interval>(){
            public int compare(Interval i1, Interval i2){
                return i1.start - i2.start;
            }
        });
        List<Interval> res = new ArrayList<>();

        for(Interval i : intervals){
            if(res.size() == 0){
                res.add(i);
                continue;
            }
            Interval last = res.get(res.size() - 1);
            if(i.start > last.end){
                res.add(i);
            }else if(i.start <= last.end && i.end >= last.end){
                last.end = i.end;
            }
        }
        return res;
    }
}

/*
虽然简单，但做到bug free不容易
易错：
1. Collections.sort()
2. 理清238楚两个interval之间的三种关系
 */