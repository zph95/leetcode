/*
 * @lc app=leetcode.cn id=3 lang=java
 *
 * [3] 无重复字符的最长子串
 *
 * https://leetcode.cn/problems/longest-substring-without-repeating-characters/description/
 *
 * algorithms
 * Medium (39.47%)
 * Likes:    9946
 * Dislikes: 0
 * Total Accepted:    2.7M
 * Total Submissions: 6.8M
 * Testcase Example:  '"abcabcbb"'
 *
 * 给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度。
 * 
 * 
 * 
 * 示例 1:
 * 
 * 
 * 输入: s = "abcabcbb"
 * 输出: 3 
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * 
 * 
 * 示例 2:
 * 
 * 
 * 输入: s = "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * 
 * 
 * 示例 3:
 * 
 * 
 * 输入: s = "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 * 请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 * 
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * 0 <= s.length <= 5 * 10^4
 * s 由英文字母、数字、符号和空格组成
 * 
 * 
 */

// @lc code=start
class Solution {
    int n = s.length(); // 字符串长度
    int ans = 0; // 记录最长子串长度
    int[] index = new int[128]; // 记录字符上一次出现的位置（ASCII字符集）

    for (int j = 0, i = 0; j < n; j++) { // j 是右指针，i 是左指针
        i = Math.max(index[s.charAt(j)], i); // 更新左指针，确保窗口内无重复字符
        ans = Math.max(ans, j - i + 1); // 更新最长子串长度
        index[s.charAt(j)] = j + 1; // 更新当前字符的最新位置
    }
    return ans; // 返回结果
    public static void main(String[] args) {
        Solution solution = new Solution();
        String testString = "abcabcbb";
        System.out.println(solution.lengthOfLongestSubstring(testString)); // 测试输出
    }
}
// @lc code=end

