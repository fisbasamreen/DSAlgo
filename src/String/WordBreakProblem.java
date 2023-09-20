package src.String;

import java.util.HashSet;

public class WordBreakProblem {
    private static HashSet<String> dictionary = new HashSet<>();

    public static void wordBreak(String str, String ans, HashSet<String> dictionary) {
        if(str.length() ==0) {
            System.out.println(ans);
            return;
        }

        for(int i=0;i<str.length();i++) {
            String left = str.substring(0,i+1);
            if(dictionary.contains(left)){
                String right = str.substring(i+1);
                wordBreak(right, ans + left + " " , dictionary);
            }
        }
    }

    public static void main(String[] args) {
        String temp_dictionary[] = {"mobile","samsung","sam","sung",
                "man","mango","icecream","and",
                "go","i","like","ice","cream"};

        for(String s : temp_dictionary) {
            dictionary.add(s);
        }

        wordBreak("ilikesamsung","", dictionary);
        wordBreak("iiiiiiii","", dictionary);
        wordBreak("","", dictionary);
        wordBreak("ilikelikeimangoiii","", dictionary);
        wordBreak("samsungandmango","", dictionary);
        wordBreak("samsungandmangok","", dictionary);
    }
}
