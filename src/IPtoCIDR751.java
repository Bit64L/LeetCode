import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

public class IPtoCIDR751 {
    public List<String> ipToCIDR(String ip, int n) {
        int newIp = toInt(ip);
        List<String> res = new LinkedList<>();
        while(n > 0){
            int maxZeros = Integer.numberOfTrailingZeros(newIp);
            int maxCount = 1 << maxZeros;
            int count = 1, zeros = 0;
            while(count < n && zeros < maxZeros){
                count <<= 1;
                zeros++;
            }
            if(count > n){
                count >>=1;
                zeros--;
            }
            n -= count;
            res.add(toString(newIp) + "/" + (32 - zeros));
            newIp += count;
        }
        return res;
    }
    public String toString(int newIp){
        StringBuilder ip = new StringBuilder();
        int count = 4;
        while(count > 0){
            int curr = newIp & 0xff;
            newIp >>>= 8;
            ip.insert(0, curr + ".");
            count--;
        }
        ip.deleteCharAt(ip.length() - 1);
        return ip.toString();
    }
    private int toInt(String ip){
        String [] sep = ip.split("\\.");
        int sum = 0;
        for(int i=0; i<sep.length;++i){
            sum*=256;
            sum+=Integer.parseInt(sep[i]);
        }
        return sum;
    }

    @Test
    public void test(){
        toString(toInt("255.0.0.7"));
    }
}
