import java.util.HashMap;

public class IntegertoRoman12 {
    public String intToRoman(int num) {
        StringBuilder res = new StringBuilder();
        HashMap<Integer, String> map = new HashMap<>();
        map.put(1, "I");
        map.put(5, "V");
        map.put(10, "X");
        map.put(50, "L");
        map.put(100, "C");
        map.put(500, "D");
        map.put(1000, "M");
        int count = 0;

        while(num > 0){
            int digit = num % 10;
            StringBuilder tmp = new StringBuilder();
            if(digit >=1 && digit <= 3){
                for(int i = 0; i < digit; i++)
                    tmp.append(map.get((int)(1 * Math.pow(10, count))));
            }else if(digit == 5){
                tmp.append(map.get((int)(5 * Math.pow(10, count))));
            }else if(digit >=6 && digit<= 8){
                tmp.append(map.get((int)(5 * Math.pow(10, count))));
                for(int i = 0; i < digit - 5; i++)
                    tmp.append(map.get((int)(1 * Math.pow(10, count))));
            }else if(digit == 9){
                tmp.append(map.get((int)(1 * Math.pow(10, count))));
                tmp.append(map.get((int)(1 * Math.pow(10, count + 1))));
            }
            res.insert(0, tmp);
            num /= 10;
            count++;
        }
        return res.toString();
    }
}
