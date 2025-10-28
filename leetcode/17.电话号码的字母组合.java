/*
 * @lc app=leetcode.cn id=17 lang=java
 *
 * [17] 电话号码的字母组合
 *
 * https://leetcode.cn/problems/letter-combinations-of-a-phone-number/description/
 *
 * algorithms
 * Medium (58.74%)
 * Likes:    2708
 * Dislikes: 0
 * Total Accepted:    789.8K
 * Total Submissions: 1.3M
 * Testcase Example:  ""23""
 *
 * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。
 * 
 * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 * 
 * 
 * 
 * 
 * 
 * 示例 1：
 * 
 * 
 * 输入：digits = "23"
 * 输出：["ad","ae","af","bd","be","bf","cd","ce","cf"]
 * 
 * 
 * 示例 2：
 * 
 * 
 * 输入：digits = ""
 * 输出：[]
 * 
 * 
 * 示例 3：
 * 
 * 
 * 输入：digits = "2"
 * 输出：["a","b","c"]
 * 
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * 0 <= digits.length <= 4
 * digits[i] 是范围 ["2", "9"] 的一个数字。
 * 
 * 
 */

// @lc code=start

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<String> letterCombinations(String digits) {
        
        List<String> result=new ArrayList<>();
        
        for(char c : digits.toCharArray()){
            String[] ret= getDigitString(Integer.valueOf(String.valueOf(c)));
            if(result.isEmpty()){
                result.addAll(getResult("", ret));
            }
            else{
                List<String> tmp =new ArrayList<>();
                for(String s: result){
                    tmp.addAll(getResult(s, ret));
                }
                result.clear();
                result.addAll(tmp);
            }
        }
        return result;
    }

    public List<String> getResult(String origin, String[] digitStr){
        List<String> result=new ArrayList<>();
        for(int i=0;i<digitStr.length;i++){
            result.add(origin+digitStr[i]);
        }
        return result;
    }

    private String[] getDigitString(Integer num){
        switch (num) {
            case 2:
                return new String[]{"a","b","c"};
            case 3:
                return new String[]{"d","e","f"};
            case 4:
                return new String[]{"g","h","i"};
            case 5:
                return new String[]{"j","k","l"};
            case 6:
                return new String[]{"m","n","o"};
            case 7:
                return new String[]{"p","q","r","s"};
            case 8:
                return new String[]{"t","u","v"};
            case 9:
                return new String[]{"w","x","y","z"};
            default:
                return null;
        }
    }
}
// @lc code=end

