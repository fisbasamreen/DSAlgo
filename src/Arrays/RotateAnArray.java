package src.Arrays;

public class RotateAnArray {
    static void reverse(int[] nums, int i , int j) {
        int low = i;
        int high = j;

        while(low<high) {
            int temp = nums[low];
            nums[low] = nums[high];
            nums[high] = temp;

            low++;
            high--;
        }
    }

    public void rotate(int[] nums, int k) {
        int n = nums.length;
        k = k%n;
        if(k<0){
            k = k+n;
        }
        //first half
        reverse(nums,0,nums.length-k-1);

        //second half
        reverse(nums,nums.length-k, nums.length-1);

        //all
        reverse(nums,0,nums.length-1);
    }

    void printArray(int arr[], int size)
    {
        int i;
        for (i = 0; i < size; i++)
            System.out.print(arr[i] + " ");
    }

    public static void main(String[] args) {
        RotateAnArray rotate = new RotateAnArray();
        int arr[] = { 1, 2, 3, 4, 5, 6, 7 };
        rotate.rotate(arr, 2);
        rotate.printArray(arr, arr.length);
    }
}
