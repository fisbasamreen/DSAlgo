package src.Arrays;

import java.util.HashMap;

public class TwoSum {
    static void printpairs(int[] arr, int sum){
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<arr.length-1;i++) {

            int diff = sum - arr[i];
            if(map.containsKey(diff)) {
                System.out.println(arr[i] + " " + diff);
            } else {
                map.put(arr[i],i);
            }
        }
    }

    public static void main(String[] args) {
        int A[] = { 1, 4, 45, 6, 10, 8 };
        int sum = 16;
        printpairs(A, sum);
    }
}
