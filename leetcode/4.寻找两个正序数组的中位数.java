/*
 * @lc app=leetcode.cn id=4 lang=java
 *
 * [4] 寻找两个正序数组的中位数
 */

// @lc code=start
class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        
        int m = nums1.length;
        int n = nums2.length;
        if (m > n) {
            int[] temp = nums1;
            nums1 = nums2;
            nums2 = temp;
            int tmp = m;
            m = n;
            n = tmp;
        }
        int iMin = 0, iMax = m, halfLen = (m + n + 1) / 2;
        int i = 0, j = 0;
        while (iMin <= iMax) {
            i = (iMin + iMax) / 2;
            j = halfLen - i;
            if (i < iMax && nums2[j - 1] > nums1[i]) {
                iMin = i + 1;
            } else if (i > iMin && nums1[i - 1] > nums2[j]) {
                iMax = i - 1;
            } else {
                break;
            }
        }
        int maxLeft = 0;
        if (i == 0) {
            maxLeft = nums2[j - 1];
        } else if (j == 0) {
            maxLeft = nums1[i - 1];
        } else {
            maxLeft = Math.max(nums1[i - 1], nums2[j - 1]);
        }
        if ((m + n) % 2 == 1) {
            return maxLeft;
        }
        int minRight = 0;
        if (i == m) {
            minRight = nums2[j];
        } else if (j == n) {
            minRight = nums1[i];
        } else {
            minRight = Math.min(nums1[i], nums2[j]);
        }
        return (maxLeft + minRight) / 2.0;

    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums1 = {1, 3};
        int[] nums2 = {2};
        double result = solution.findMedianSortedArrays(nums1, nums2);
        System.out.println(result);

    }
}
// @lc code=end

