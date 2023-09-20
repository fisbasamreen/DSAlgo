package src.Arrays;

import java.util.HashSet;
import java.util.Set;

public class LongestConsequtiveSubsequence {
    static int longestSequence(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int res=0;

        for(int i=0;i<nums.length;i++) {
            set.add(nums[i]);
        }

        for(int i=0;i<nums.length;i++) {
            if(!set.contains(nums[i]-1)) {

                int j = nums[i];

                while(set.contains(j)) {
                    j++;
                }

                if(res < j-nums[i]) {
                    res = j-nums[i];
                }

            }
        }
        return res;
    }

    public static void main(String[] args) {
        int arr[] = { 1, 9, 3, 10, 4, 20, 2 };
        int n = arr.length;
        System.out.println(
                "Length of the Longest consecutive subsequence is "
                        + longestSequence(arr));
    }
}
