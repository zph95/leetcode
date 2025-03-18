/*
 * @lc app=leetcode.cn id=2956 lang=java
 *
 * [2956] 找到两个数组中的公共元素
 */

// @lc code=start

import java.util.ArrayList;
import java.util.List;

class Solution {
    public int[] findIntersectionValues(int[] nums1, int[] nums2) {
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        for(int num : nums1) {
            list1.add(num);
        }
        for(int num : nums2) {
            list2.add(num);
        }

        
        int count1 = 0;
        int count2 = 0;
        for(int num : list1) {
            if (list2.contains(num)) {
                count1++;
            }
        }
        for(int num : list2) {
            if (list1.contains(num)) {
                count2++;
            }
        }
        int[] res = new int[] {count1, count2};
        return res;
    }
}
// @lc code=end

