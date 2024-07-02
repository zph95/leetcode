/*
 * @lc app=leetcode.cn id=34 lang=java
 *
 * [34] 在排序数组中查找元素的第一个和最后一个位置
 *
 * https://leetcode.cn/problems/find-first-and-last-position-of-element-in-sorted-array/description/
 *
 * algorithms
 * Medium (43.22%)
 * Likes:    2724
 * Dislikes: 0
 * Total Accepted:    1M
 * Total Submissions: 2.3M
 * Testcase Example:  '[5,7,7,8,8,10]\n8'
 *
 * 给你一个按照非递减顺序排列的整数数组 nums，和一个目标值 target。请你找出给定目标值在数组中的开始位置和结束位置。
 * 
 * 如果数组中不存在目标值 target，返回 [-1, -1]。
 * 
 * 你必须设计并实现时间复杂度为 O(log n) 的算法解决此问题。
 * 
 * 
 * 
 * 示例 1：
 * 
 * 
 * 输入：nums = [5,7,7,8,8,10], target = 8
 * 输出：[3,4]
 * 
 * 示例 2：
 * 
 * 
 * 输入：nums = [5,7,7,8,8,10], target = 6
 * 输出：[-1,-1]
 * 
 * 示例 3：
 * 
 * 
 * 输入：nums = [], target = 0
 * 输出：[-1,-1]
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * 0 <= nums.length <= 10^5
 * -10^9 <= nums[i] <= 10^9
 * nums 是一个非递减数组
 * -10^9 <= target <= 10^9
 * 
 * 
 */

// @lc code=start
class Solution {
    public int[] searchRange(int[] nums, int target) {

        int left = 0;
        int right = nums.length - 1;
        int[] res = new int[]{-1, -1};
        // find the left bound
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) right = mid - 1;
            else if (nums[mid] < target) left = mid + 1;
            else right = mid - 1;
        }
        if (left >= nums.length || nums[left] != target) return res;
        res[0] = left;
        // find the right bound
        right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) left = mid + 1;
            else if (nums[mid] < target) left = mid + 1;
            else right = mid - 1;
        }
        res[1] = right;
        return res;

    }
}
// @lc code=end

