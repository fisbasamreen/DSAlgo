package src.Arrays;

import java.util.*;

public class LargestNumberFromArray {
    static void printLargest(Vector<String> arr)
    {
        Comparator<String> customComparator = (str1, str2) -> (str2 + str1).compareTo(str1 + str2);

        Collections.sort(arr, customComparator);


        Iterator it = arr.iterator();

        while (it.hasNext())
            System.out.print(it.next());
    }

    // Driver code
    public static void main(String[] args)
    {

        Vector<String> arr;
        arr = new Vector<>();

        // output should be 6054854654
        arr.add("54");
        arr.add("546");
        arr.add("548");
        arr.add("60");
        printLargest(arr);
    }
}
