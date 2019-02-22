import org.junit.Test;

import java.util.Arrays;

public class NextClosestTime681 {
    public String nextClosestTime(String time) {
        char[] origin = {time.charAt(0), time.charAt(1), time.charAt(3), time.charAt(4)};
        char[] sortedChars = origin.clone();
        Arrays.sort(sortedChars);
        int i = 0;
        for(i = origin.length - 1; i >= 0; i--){
            int j = 0;
            while(j < sortedChars.length && sortedChars[j] <= origin[i]) j++;
            if(j < sortedChars.length){
                char tmp = origin[i];
                origin[i] = sortedChars[j];
                int hour = (origin[0] - '0') * 10 + (origin[1] - '0');
                int minute = (origin[2] - '0') * 10 + (origin[3] - '0');
                if(hour >= 0 && hour <=23 && minute >= 0&& minute <= 59) break;
                origin[i] = tmp;
            }
        }

        for(i++ ; i < origin.length; i++){
            origin[i] = sortedChars[0];
        }
        StringBuilder sb = new StringBuilder();
        sb.append(origin[0]).append(origin[1]).append(":").append(origin[2]).append(origin[3]);
        return  sb.toString();
    }

    @Test
    public void test(){
        char[] chars = {'1','2','3'};
        System.out.println(new String(chars));
    }
}

/*
模拟题目：找到第一个位置，这个位置能用刚刚比它的值大一点的值代替，余下的位数全部用最小的值代替
 */
