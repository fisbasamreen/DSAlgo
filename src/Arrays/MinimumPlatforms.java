package src.Arrays;

import java.util.Arrays;

public class MinimumPlatforms {

    static int minimumPlatforms(int[] arr, int[] dep){
        Arrays.sort(arr);
        Arrays.sort(dep);

        int n = arr.length;
        int platform_needed=1, result=1;
        int i=1,j=0;

        while(i<n && j<n) {

            if(arr[i]<=dep[j]){
                platform_needed++;
                i++;
            } else if(arr[i] > dep[j]){
                platform_needed--;
                j++;
            }

            if(result<platform_needed){
                result = platform_needed;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int arr[] = { 900, 940, 950, 1100, 1500, 1800 };
        int dep[] = { 910, 1200, 1120, 1130, 1900, 2000 };

        System.out.println("Minimum Number of Platforms Required = " + minimumPlatforms(arr, dep));
    }
}
