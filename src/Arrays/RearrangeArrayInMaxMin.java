package src.Arrays;

import java.util.Arrays;

public class RearrangeArrayInMaxMin {
    static int[] rearrange(int[] arr, int n, int[] temp) {
        // Auxiliary array to hold modified array

        // Indexes of smallest and largest elements
        // from remaining array.
        int small = 0, large = n - 1;

        // To indicate whether we need to copy rmaining
        // largest or remaining smallest at next position
        boolean flag = true;

        // Store result in temp[]
          for(int i=0;i<n;i++) {
            if (flag) {
                System.out.println("large " + arr[large]);
                temp[i] = arr[large];
                large--;
            } else {
                System.out.println("small " + arr[small]);
                temp[i] = arr[small];
                small++;
            }
            flag = !flag;
        }
        return temp;
    }

    // Driver code
    public static void main(String[] args) {
        int arr[] = new int[]{1, 2, 3, 4, 5, 6};
        int temp[] = new int[arr.length];



        System.out.println("Original Array ");
        System.out.println(Arrays.toString(arr));

        int temp1[] = rearrange(arr, arr.length, temp);

        System.out.println("Modified Array ");
        System.out.println(Arrays.toString(temp1));
    }
}
