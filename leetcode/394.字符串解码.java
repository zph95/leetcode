/*
 * @lc app=leetcode.cn id=394 lang=java
 *
 * [394] 字符串解码
 *
 * https://leetcode.cn/problems/decode-string/description/
 *
 * algorithms
 * Medium (57.09%)
 * Likes:    1647
 * Dislikes: 0
 * Total Accepted:    277.5K
 * Total Submissions: 486.1K
 * Testcase Example:  '"3[a]2[bc]"'
 *
 * 给定一个经过编码的字符串，返回它解码后的字符串。
 * 
 * 编码规则为: k[encoded_string]，表示其中方括号内部的 encoded_string 正好重复 k 次。注意 k 保证为正整数。
 * 
 * 你可以认为输入字符串总是有效的；输入字符串中没有额外的空格，且输入的方括号总是符合格式要求的。
 * 
 * 此外，你可以认为原始数据不包含数字，所有的数字只表示重复的次数 k ，例如不会出现像 3a 或 2[4] 的输入。
 * 
 * 
 * 
 * 示例 1：
 * 
 * 
 * 输入：s = "3[a]2[bc]"
 * 输出："aaabcbc"
 * 
 * 
 * 示例 2：
 * 
 * 
 * 输入：s = "3[a2[c]]"
 * 输出："accaccacc"
 * 
 * 
 * 示例 3：
 * 
 * 
 * 输入：s = "2[abc]3[cd]ef"
 * 输出："abcabccdcdcdef"
 * 
 * 
 * 示例 4：
 * 
 * 
 * 输入：s = "abc3[cd]xyz"
 * 输出："abccdcdcdxyz"
 * 
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * 1 <= s.length <= 30
 * s 由小写英文字母、数字和方括号 '[]' 组成
 * s 保证是一个 有效 的输入。
 * s 中所有整数的取值范围为 [1, 300] 
 * 
 * 
 */

// @lc code=start

import java.util.Stack;

class Solution {
    int index=0;
    public String decodeString(String s) {
        String result = "";

      
        while(index<s.length()){
            result+=process(s.toCharArray());
        }
        
        return result;
    }

    private String process(char[] s){
        String result="";
        Stack<String> numStack=new Stack<>();
        Stack<String> strStack=new Stack<>();
        while( index<s.length ){

            char c=s[index];
            if(c>='0'&&c<='9'){
                numStack.push(String.valueOf(c));
                index++;
            }
            else if(c=='['){
                index++;
                String  tmp= process(s);
                Integer n = Integer.valueOf(numStack.stream().collect(Collectors.joining()));
                for(int j=0;j<n;j++){
                    strStack.push(tmp);
                }
                numStack.clear();
            }
            else if(c==']'){
                index++;
                String tmp= strStack.stream().collect(Collectors.joining());
                return tmp;
            }
            else{
                strStack.push(String.valueOf(c));
                index++;
            }
        }
        String tmp= strStack.stream().collect(Collectors.joining());
        result+=tmp;
        return result;
    }
}
// @lc code=end

