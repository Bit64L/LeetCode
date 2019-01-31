import common.Interval;

import java.util.Arrays;
import java.util.Comparator;

public class MeetingRoomsII253 {
    public int minMeetingRooms(Interval[] intervals) {
        if(intervals == null || intervals.length == 0)
            return 0;
        Arrays.sort(intervals, new Comparator<Interval>(){
            public int compare(Interval i1, Interval i2){
                return i1.start - i2.start;
            }
        });
        int[] ends = new int[intervals.length];
        for(int i = 0; i < intervals.length; i++) ends[i] = -1;
        for(int i = 0; i < intervals.length; i++){
            int j = 0;
            while(j < intervals.length && ends[j] != -1){
                if(intervals[i].start >= ends[j]){
                    ends[j] = intervals[i].end;
                    break;
                }
                j++;
            }
            if(ends[j] == -1){
                ends[j] = intervals[i].end;
            }
        }
        int res = 0;
        while(res < intervals.length && ends[res] != -1) res++;
        return res;
    }
}

//
//本题是一道非常经典的贪心题目
//算法的基本思想在570的课上有讲: 按照start排序后，取一个interval放入一个room，如果没有可放入的则新开一个room。
//对于每一个room来说，只需记录其最后结束使用的时间即可，用ends数组表示