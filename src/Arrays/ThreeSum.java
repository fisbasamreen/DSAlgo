package src.Arrays;

import java.util.Arrays;

public class ThreeSum {

    static void findThreeSum(int[] arr, int target) {
        Arrays.sort(arr);

        for(int i=0;i<arr.length-2;i++) {

            int low = i+1;
            int high = arr.length -1;

            while(low<high) {
                int sum = arr[i] + arr[low] + arr[high];
                if(sum == target) {
                    System.out.println("print" + arr[i] + " "  + arr[low] + " " + arr[high]);
                    return;
                } else if(sum<target) {
                    low++;
                } else {
                    high --;
                }
            }
            }

    }

    public static void main(String[] args) {
        int arr[] = { 1, 4, 45, 6, 10, 8 };
        int sum = 22;

        findThreeSum(arr, sum);

    }
}
