/*
 * @lc app=leetcode.cn id=1143 lang=java
 *
 * [1143] 最长公共子序列
 *
 * https://leetcode.cn/problems/longest-common-subsequence/description/
 *
 * algorithms
 * Medium (64.97%)
 * Likes:    1484
 * Dislikes: 0
 * Total Accepted:    397.8K
 * Total Submissions: 612.2K
 * Testcase Example:  '"abcde"\n"ace"'
 *
 * 给定两个字符串 text1 和 text2，返回这两个字符串的最长 公共子序列 的长度。如果不存在 公共子序列 ，返回 0 。
 * 
 * 一个字符串的 子序列
 * 是指这样一个新的字符串：它是由原字符串在不改变字符的相对顺序的情况下删除某些字符（也可以不删除任何字符）后组成的新字符串。
 * 
 * 
 * 例如，"ace" 是 "abcde" 的子序列，但 "aec" 不是 "abcde" 的子序列。
 * 
 * 
 * 两个字符串的 公共子序列 是这两个字符串所共同拥有的子序列。
 * 
 * 
 * 
 * 示例 1：
 * 
 * 
 * 输入：text1 = "abcde", text2 = "ace" 
 * 输出：3  
 * 解释：最长公共子序列是 "ace" ，它的长度为 3 。
 * 
 * 
 * 示例 2：
 * 
 * 
 * 输入：text1 = "abc", text2 = "abc"
 * 输出：3
 * 解释：最长公共子序列是 "abc" ，它的长度为 3 。
 * 
 * 
 * 示例 3：
 * 
 * 
 * 输入：text1 = "abc", text2 = "def"
 * 输出：0
 * 解释：两个字符串没有公共子序列，返回 0 。
 * 
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * 1 
 * text1 和 text2 仅由小写英文字符组成。
 * 
 * 
 */

// @lc code=start

import java.util.Map;

class Solution {
    Map<String,Integer> lengthMap=new HashMap<String, Integer>();
    public int longestCommonSubsequence(String text1, String text2) {
        return getCommonLength(text1, text2, 0, 0);
    }

    public int getCommonLength(String text1, String text2, int i, int j){
        String key=String.valueOf(i)+"_"+String.valueOf(j);
        if(lengthMap.containsKey(key)){
            return lengthMap.get(key);
        }
        if(i==text1.length()||j==text2.length()){
            return 0;
        }
        else{
            char c = text1.charAt(i);
            int index= text2.indexOf(c, j);
            int tmp= getCommonLength(text1, text2, i+1, j);
            if(index>=0){
                int length = Math.max(getCommonLength(text1, text2, i+1,index+1)+1,tmp);
                lengthMap.put(key, length);
                return length;
            }
            else{
                return tmp;
            }
        }
    }
}
// @lc code=end

