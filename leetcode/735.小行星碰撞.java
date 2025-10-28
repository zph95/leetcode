/*
 * @lc app=leetcode.cn id=735 lang=java
 *
 * [735] 小行星碰撞
 *
 * https://leetcode.cn/problems/asteroid-collision/description/
 *
 * algorithms
 * Medium (42.48%)
 * Likes:    462
 * Dislikes: 0
 * Total Accepted:    85.9K
 * Total Submissions: 202.1K
 * Testcase Example:  '[5,10,-5]'
 *
 * 给定一个整数数组 asteroids，表示在同一行的小行星。
 * 
 * 对于数组中的每一个元素，其绝对值表示小行星的大小，正负表示小行星的移动方向（正表示向右移动，负表示向左移动）。每一颗小行星以相同的速度移动。
 * 
 * 
 * 找出碰撞后剩下的所有小行星。碰撞规则：两个小行星相互碰撞，较小的小行星会爆炸。如果两颗小行星大小相同，则两颗小行星都会爆炸。两颗移动方向相同的小行星，永远不会发生碰撞。
 * 
 * 
 * 
 * 示例 1：
 * 
 * 
 * 输入：asteroids = [5,10,-5]
 * 输出：[5,10]
 * 解释：10 和 -5 碰撞后只剩下 10 。 5 和 10 永远不会发生碰撞。
 * 
 * 示例 2：
 * 
 * 
 * 输入：asteroids = [8,-8]
 * 输出：[]
 * 解释：8 和 -8 碰撞后，两者都发生爆炸。
 * 
 * 示例 3：
 * 
 * 
 * 输入：asteroids = [10,2,-5]
 * 输出：[10]
 * 解释：2 和 -5 发生碰撞后剩下 -5 。10 和 -5 发生碰撞后剩下 10 。
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * 2 <= asteroids.length <= 10^4
 * -1000 <= asteroids[i] <= 1000
 * asteroids[i] != 0
 * 
 * 
 */

// @lc code=start

import java.util.List;
import java.util.Stack;

class Solution {
    Stack<Integer> numStack = new Stack();
    public int[] asteroidCollision(int[] asteroids) {
     
        for(int i=0;i<asteroids.length;i++){
           process(asteroids[i]);
        }
        List<Integer> numsList = numStack.stream().toList();
        int[] result=new int[numsList.size()];
        for(int i=0;i<numsList.size();i++){
            result[i]=numsList.get(i);
        }
        return result;
    }

    private void process(int num){
            if(numStack.isEmpty()){
                numStack.push(num);
                return;
            }
            else{
                if(num<0&&numStack.peek()>0){
                    int pre=numStack.pop();
                    if(Math.abs(pre)>Math.abs(num)){
                        numStack.push(pre);
                    }
                    else if(Math.abs(pre)<Math.abs(num)){
                       process(num);
                    }
                }
                else{
                    numStack.push(num);
                }
            }
    }

}
// @lc code=end

