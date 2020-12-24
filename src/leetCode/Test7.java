package leetCode;

import java.util.Arrays;

public class Test7 {
    static class Solution {
        public static void sortColors(int[] coins) {
            int count =0;
           for (int i=0;i<coins.length;i++){
               if(coins[i]%2==0){
                   count+=coins[i]/2;
               }else if(coins[i]%2==1){
                   count+=coins[i]/2+1;
               }
           }
            System.out.println(count);
        }
        public static int[] runningSum(int[] nums) {
            for(int i=1;i<nums.length;i++){
//                for(int j =0;j<i;j++) {
//                    nums[i] += nums[j];
//                }
                nums[i] +=nums[i-1];
            }
            System.out.println(Arrays.toString(nums));
            return nums;
        }

    }

    public static void main(String[] args) {
//        int[] c = new int[]{4,2,1};
//        Solution.sortColors(c);
        int[] c = new int[]{1,2,3,4};
        Solution.runningSum(c);
    }
}
