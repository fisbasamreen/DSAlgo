package src.Arrays;

public class ProductOfArrayExceptSelf {
    public static int[] productExceptSelf(int[] nums) {
        int[] output = new int[nums.length];

        int product = 1;
        //left product
        for (int i = 0; i <= nums.length-1; i++) {
            product = nums[i] * product;
            output[i] = product;
        }


        product = 1;
        for(int i = nums.length-1; i > 0; i--) {
            output[i] = output[i-1] * product;
            product = product * nums[i];
        }
        output[0] = product;

        return output;
    }

    public static void main(String[] args) {
        int arr[] = { 10, 3, 5, 6, 2 };
        System.out.println("The product array is : ");

        int[] res = productExceptSelf(arr);
        for (int i = 0; i < res.length; i++)
            System.out.print(res[i] + " ");
    }
}

/*
// Initialize two arrays to store products to the left and right of each element.
    int[] leftProducts = new int[n];
    int[] rightProducts = new int[n];

    leftProducts[0] = 1;
    for (int i = 1; i < n; i++) {
        leftProducts[i] = leftProducts[i - 1] * nums[i - 1];
    }

    rightProducts[n - 1] = 1;
    for (int i = n - 2; i >= 0; i--) {
        rightProducts[i] = rightProducts[i + 1] * nums[i + 1];
    }

    // Calculate the final product except self for each element.
    for (int i = 0; i < n; i++) {
        output[i] = leftProducts[i] * rightProducts[i];
    }

 */