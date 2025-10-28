/*
 * @lc app=leetcode.cn id=1732 lang=java
 *
 * [1732] 找到最高海拔
 */

// @lc code=start
class Solution {
    public int largestAltitude(int[] gain) {
        int max=0;
        int sum=max;
        for(int i=0;i<gain.length;i++){
            sum+=gain[i];
            if(sum>max){
                max=sum;
            }
        }
        return max;
    }
}
// @lc code=end

