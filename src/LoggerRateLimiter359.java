import org.junit.Test;

import java.util.HashMap;

public class LoggerRateLimiter359 {
    private HashMap<String, Integer> map;

    /** Initialize your data structure here. */
    public LoggerRateLimiter359() {
        map = new HashMap<>();
    }

    /** Returns true if the message should be printed in the given timestamp, otherwise returns false.
     If this method returns false, the message will not be printed.
     The timestamp is in seconds granularity. */
    public boolean shouldPrintMessage(int timestamp, String message) {
        if(!map.containsKey(message) || timestamp - map.get(message) >= 10){
            map.put(message, timestamp);
            return true;
        }
        return false;
    }

    @Test
    public void test(){
        shouldPrintMessage(1, "a");
        shouldPrintMessage(2, "a");
        shouldPrintMessage(3, "a");
        shouldPrintMessage(15, "a");

    }
}
