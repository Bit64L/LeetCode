import java.util.HashSet;

public class UniqueEmailAddresses929 {
    public int numUniqueEmails(String[] emails) {
        if(emails == null || emails.length == 0) return 0;
        HashSet<String> set = new HashSet<>();
        for(String email : emails){
            String[] strs = email.split("@");
            String local = strs[0];
            String domain = strs[1];
            StringBuilder sb = new StringBuilder();
            for(int i = 0; i < local.length(); i++){
                if(local.charAt(i) == '.'){
                    continue;
                }else if(local.charAt(i) == '+'){
                    break;
                }else{
                    sb.append(local.charAt(i));
                }
            }
            sb.append("@").append(domain);
            set.add(sb.toString());
        }
        return set.size();
    }
}
// 遍历字符串并，处理并合成新的local，用集合set去重