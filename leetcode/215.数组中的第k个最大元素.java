/*
 * @lc app=leetcode.cn id=215 lang=java
 *
 * [215] 数组中的第K个最大元素
 *
 * https://leetcode.cn/problems/kth-largest-element-in-an-array/description/
 *
 * algorithms
 * Medium (62.38%)
 * Likes:    2369
 * Dislikes: 0
 * Total Accepted:    965.4K
 * Total Submissions: 1.5M
 * Testcase Example:  '[3,2,1,5,6,4]\n2'
 *
 * 给定整数数组 nums 和整数 k，请返回数组中第 k 个最大的元素。
 * 
 * 请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
 * 
 * 你必须设计并实现时间复杂度为 O(n) 的算法解决此问题。
 * 
 * 
 * 
 * 示例 1:
 * 
 * 
 * 输入: [3,2,1,5,6,4], k = 2
 * 输出: 5
 * 
 * 
 * 示例 2:
 * 
 * 
 * 输入: [3,2,3,1,2,4,5,5,6], k = 4
 * 输出: 4
 * 
 * 
 * 
 * 提示： 
 * 
 * 
 * 1 <= k <= nums.length <= 10^5
 * -10^4 <= nums[i] <= 10^4
 * 
 * 
 */

// @lc code=start

import java.util.concurrent.PriorityBlockingQueue;

class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityBlockingQueue<Integer> queue=new PriorityBlockingQueue<>(
            nums.length, (x,y)->{
                if(x>y){
                    return -1;
                }
                else if(x<y){
                    return 1;
                }
                else{
                    return 0;
                }
            }
        );
        

        for(int i=0;i<nums.length;i++){
            queue.add(nums[i]);
        }
        for(int i=0;i<k-1;i++){
            queue.poll();
        }
        return queue.poll();
    }
}
// @lc code=end

