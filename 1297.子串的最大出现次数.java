/*
 * @lc app=leetcode.cn id=1297 lang=java
 *
 * [1297] 子串的最大出现次数
 */

// @lc code=start
import java.util.HashMap;

class Solution {
    public int maxFreq(String s, int maxLetters, int minSize, int maxSize) {
        HashMap<String, Integer> substringCount = new HashMap<>();
        int maxFrequency = 0;

        for (int i = 0; i <= s.length() - minSize; i++) {
            String substring = s.substring(i, i + minSize);
            if (countUniqueCharacters(substring) <= maxLetters) {
                substringCount.put(substring, substringCount.getOrDefault(substring, 0) + 1);
                maxFrequency = Math.max(maxFrequency, substringCount.get(substring));
            }
        }

        return maxFrequency;
    }

    private int countUniqueCharacters(String s) {
        boolean[] seen = new boolean[26];
        int uniqueCount = 0;

        for (char c : s.toCharArray()) {
            if (!seen[c - 'a']) {
                seen[c - 'a'] = true;
                uniqueCount++;
            }
        }

        return uniqueCount;
    }
}
// @lc code=end

