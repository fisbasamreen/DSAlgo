package src.String;

public class AnagramStrings {
    static boolean areAnagram(char str1[], char str2[])
    {
        if (str1.length != str2.length)
            return false;

        int[] count = new int[256];
        //Arrays.fill(count,0);

        for(int i=0;i<str1.length;i++) {
            count[str1[i]]++;
            count[str2[i]]--;
        }

        for(int i = 0; i < 256; i++)
            if (count[i] != 0)
            {
                return false;
            }
        return true;
    }

    public static void main(String[] args) {
        char str1[] = ("geeksforgeeks").toCharArray();
        char str2[] = ("forgeeksgeeks").toCharArray();

        // Function call
        if (areAnagram(str1, str2))
            System.out.println("The two strings are"
                    + "anagram of each other");
        else
            System.out.println("The two strings are not"
                    + " anagram of each other");
    }
}
