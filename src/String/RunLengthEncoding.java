package src.String;

public class RunLengthEncoding {
    static  void printRLE(String str) {

        for(int i=0;i<str.length();i++) {
            int count =1;
            while(i<str.length()-1 && str.charAt(i) == str.charAt(i+1)) {
                i++;
                count++;
            }

            System.out.print(str.charAt(i));
            System.out.print(count);
        }
    }

    public static void main(String[] args) {
        String str = "wwwwaaadexxxxxxywww";
        printRLE(str);
    }
}
