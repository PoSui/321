package leetCode;

import java.util.Arrays;

//输入: [-2,1,-3,4,-1,2,1,-5,4]
//        输出: 6
//        解释: 连续子数组 [4,-1,2,1] 的和最大为 6。
public class Test3 {
    public static int maxSubArray1(int[] nums) {
    int res = nums[0];
    int sum = 0;
        for (int num : nums) {
        if (sum > 0) {
            sum += num;
        }
        else {
            sum = num;
        }
        res = Math.max(res, sum);
    }
        System.out.println(res);
        return res;
}
    public static int maxSubArray(int[] nums) {
        int max = -10000;
        int now = 0;
        if(nums.length==1){
            System.out.println(nums[0]);
            return nums[0];
        }
        int[] arr2=java.util.Arrays.copyOf(nums,nums.length<<1);
        int[] litnums = new int[arr2.length];
        for(int i = 0;i<nums.length; i++) {
            for (int j = 1; j < nums.length+1; j++) {
                System.arraycopy(arr2, i, litnums, 0,j);
                for (int k=0;k<litnums.length;k++){
                    now=now+litnums[k];
                }
                if(now>max){
                    max=now;
                }
                now=0;
                System.out.print(Arrays.toString(litnums));
                System.out.println(max+",起始位置："+i+",复制长度"+j);
                litnums=new int[arr2.length];
            }
        }
        System.out.println(max);
        return max;
    }

    public static void main(String[] args) {
        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
        Test3.maxSubArray1(nums);
    }
}
