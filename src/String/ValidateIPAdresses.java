package src.String;

import java.util.regex.Pattern;

public class ValidateIPAdresses {
    public static String validIPAddress(String IP) {
    String ipv4_regex = "(([0-9]|[1-9][0-9]|1[0-9][0-9]|2[0-4][0-9]|25[0-5])\\.){3}";
    String ipv6_regex = "([0-9 a-f A-F]{1,4}\\.){7}";


    if(Pattern.matches("(([0-9]|[1-9][0-9]|1[0-9][0-9]|2[0-4][0-9]|25[0-5])\\.){3}([0-9]|[1-9][0-9]|1[0-9][0-9]|2[0-4][0-9]|25[0-5])",IP)) {
       return "IPV4";
    } else if(Pattern.matches("((([0-9a-fA-F]){1,4})\\:){7}([0-9a-fA-F]){1,4}",IP)){
        return "IPV6";
     } else{
        return "Not a valid adrress";
    }
    }


    public static void main(String[] args) {
        String result = validIPAddress("125.16.100.1");
        System.out.println("result " + result);

        String result1 = validIPAddress("fffe:3465:efab:23fe:2235:6565:aaab:0001");
        System.out.println("result1 " + result1);

        String result2 = validIPAddress("2F33:12a0:3Ea0:0302");
        System.out.println("result2 " + result2);
    }
}
