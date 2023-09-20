package src.String;

public class DPLongestPalindromeSubstr {
    static void printSubStr(
            String str, int low, int high)
    {
        System.out.println(
                str.substring(
                        low, high + 1));
    }

    static int longestPalSubstr(String str){
        int maxlength =1;
        int n = str.length();

        boolean table[][] = new boolean[n][n];

        for(int i=0;i<n;i++) {
            table[i][i] = true;
        }

        int start = 0;
        for(int i=0;i<n-1;i++) {
            if(str.charAt(i) == str.charAt(i+1)) {
                table[i][i+1] = true;
                maxlength = 2;
                start = i;
            }
        }

        for(int k=3;k<=n;k++){
            for (int i = 0; i < n - k + 1; ++i) {
                // Get the ending index of substring from
                // starting index i and length k
                int j = i + k - 1;

                // checking for sub-string from ith index to
                // jth index iff str.charAt(i+1) to
                // str.charAt(j-1) is a palindrome
                if (table[i + 1][j - 1]
                        && str.charAt(i) == str.charAt(j)) {
                    table[i][j] = true;

                    if (k > maxlength) {
                        start = i;
                        maxlength = k;
                    }
                }
            }
        }
        System.out.print("Longest palindrome substring is; ");
        printSubStr(str, start,
                start + maxlength - 1);

        // return length of LPS
        return maxlength;
    }

    public static void main(String[] args) {
        String str = "forgeeksskeegfor";
        System.out.println("Length is: " + longestPalSubstr(str));
    }
}
