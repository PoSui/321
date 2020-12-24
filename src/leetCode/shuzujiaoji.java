package leetCode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class shuzujiaoji {
    static class Solution {
        public int[] intersection(int[] nums1, int[] nums2) {

            Set set = new HashSet();
            for(int i =0;i<nums1.length;i++){
                for(int j =0;j<nums2.length;j++){
                    if(nums1[i]==nums2[j]){
                        set.add(nums2[j]);
                    }
                }
            }
            int[] arr = new int[set.size()];
            List<Integer> list = new ArrayList(set);
            for(int i = 0;i < set.size();i++){
                arr[i] = list.get(i);
            }
            return arr;

        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int arr[] = new int[]{1,2,2,1};
        int arr2[] = new int[]{2,2};
        s.intersection(arr,arr2);

    }
}
