/*
 * @lc app=leetcode.cn id=739 lang=java
 *
 * [739] 每日温度
 *
 * https://leetcode.cn/problems/daily-temperatures/description/
 *
 * algorithms
 * Medium (68.76%)
 * Likes:    1667
 * Dislikes: 0
 * Total Accepted:    492.6K
 * Total Submissions: 716.4K
 * Testcase Example:  '[73,74,75,71,69,72,76,73]'
 *
 * 给定一个整数数组 temperatures ，表示每天的温度，返回一个数组 answer ，其中 answer[i] 是指对于第 i
 * 天，下一个更高温度出现在几天后。如果气温在这之后都不会升高，请在该位置用 0 来代替。
 * 
 * 
 * 
 * 示例 1:
 * 
 * 
 * 输入: temperatures = [73,74,75,71,69,72,76,73]
 * 输出: [1,1,4,2,1,1,0,0]
 * 
 * 
 * 示例 2:
 * 
 * 
 * 输入: temperatures = [30,40,50,60]
 * 输出: [1,1,1,0]
 * 
 * 
 * 示例 3:
 * 
 * 
 * 输入: temperatures = [30,60,90]
 * 输出: [1,1,0]
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * 1 <= temperatures.length <= 10^5
 * 30 <= temperatures[i] <= 100
 * 
 * 
 */

// @lc code=start

import java.util.Stack;

class Solution {
    public int[] dailyTemperatures(int[] temperatures) {

        int[] ret=new int[temperatures.length];

        Stack<Integer> maxTemp=new Stack<>();

        for(int i=temperatures.length-1;i>=0;i--){
            while(!maxTemp.isEmpty()){
                int index=maxTemp.peek();
                if(temperatures[i]<temperatures[index]){
                    ret[i]=index-i;
                    maxTemp.push(i);
                    break;
                }
                else{
                    maxTemp.pop();
                }
            }
            
            if(maxTemp.isEmpty()){
                maxTemp.push(i);
                ret[i]=0;
            }
        }
        return ret;
    }
}
// @lc code=end

