/*
 * @lc app=leetcode.cn id=724 lang=java
 *
 * [724] 寻找数组的中心下标
 */

// @lc code=start
class Solution {
    public int pivotIndex(int[] nums) {

        int sum=0;
        for(int i=0;i<nums.length;i++){
            sum+=nums[i];
        }
        int preSum=0;
        for(int i=0;i<nums.length;i++){
            if(preSum==(sum-nums[i])/2.0){
                return i;
            }
            preSum+=nums[i];
        }
        return -1;
    }
}
// @lc code=end

