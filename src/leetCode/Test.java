package leetCode;

class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] re = new int[2];
        loop:
        for(int i =0;i<nums.length;i++){
            int now = nums[i];
            for(int j=0;j<nums.length;j++){
                if(j==i) {
                    continue ;
                }
                    if (target == now + nums[j]) {
                        re[0] = i;
                        re[1] = j;
                        break loop;
                    }

            }
        }
        return re;
    }
}
public class Test{
public static void main(String[] args){
        Solution s = new Solution();
        int[] a = {2,5,5,11};
        int[] b = s.twoSum(a,10);
        System.out.println("["+b[0]+","+b[1]+"]");
        }
        }