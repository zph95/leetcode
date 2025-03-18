/*
 * @lc app=leetcode.cn id=434 lang=java
 *
 * [434] 字符串中的单词数
 */

// @lc code=start
class Solution {
    public int countSegments(String s) {
        String[] words = s.split(" ");
        int count = 0;
        for (String word : words) {
            if (!word.equals("")) {
                count++;
            }
        }
        return count;
    }
}
// @lc code=end

