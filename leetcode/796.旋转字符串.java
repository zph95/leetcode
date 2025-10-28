/*
 * @lc app=leetcode.cn id=796 lang=java
 *
 * [796] 旋转字符串
 */

// @lc code=start
class Solution {
    public boolean rotateString(String s, String goal) {
        
        if(s.length() != goal.length()) return false;
        if(s.equals(goal)) return true;
        for(int i = 0; i < s.length(); i++){
            if(s.substring(i).equals(goal.substring(0, s.length() - i)) && s.substring(0, i).equals(goal.substring(s.length() - i))){
                return true;
            }
        }
        return false;

    }
}
// @lc code=end

