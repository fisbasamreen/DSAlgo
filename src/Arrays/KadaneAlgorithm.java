package src.Arrays;

public class KadaneAlgorithm {

    static int maxSubArray(int[] nums) {
        int sum= 0, max= Integer.MIN_VALUE;

        for(int i=0;i<nums.length;i++) {
            sum = sum + nums[i];
            max = Math.max(sum, max);
            if(sum<0) {
                sum = 0;
            }
        }
        return max;
    }

    static int maxSubArraySum(int a[],int size)
    {

        int max_so_far = a[0], max_ending_here = 0;

        for (int i = 0; i < size; i++)
        {
            max_ending_here = max_ending_here + a[i];
            if (max_ending_here < 0)
                max_ending_here = 0;

        /* Do not compare for all
           elements. Compare only
           when max_ending_here > 0 */
            else if (max_so_far < max_ending_here)
                max_so_far = max_ending_here;

        }
        return max_so_far;
    }




    public static void main (String[] args)
    {
        int [] a = {-2, -3, 4, -1, -2, 1, 5, -3};
        System.out.println("Maximum contiguous sum is " +
                maxSubArraySum(a, a.length));

        System.out.println("Maximum contiguous sum " + maxSubArray(a));
    }
}
