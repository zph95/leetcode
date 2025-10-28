/*
 * @lc app=leetcode.cn id=845 lang=java
 *
 * [845] 数组中的最长山脉
 */

// @lc code=start
class Solution {
    public int longestMountain(int[] arr) {
        int n = arr.length;
        if(n < 3) return 0;
        int res = 0;
        for(int i = 1; i < n - 1; i++) {
            if(arr[i] > arr[i - 1] && arr[i] > arr[i + 1]) {
                int left = i - 1;
                int right = i + 1;
                while(left > 0 && arr[left] > arr[left - 1]) {
                    left--;
                }
                while(right < n - 1 && arr[right] > arr[right + 1]) {
                    right++;
                }
                res = Math.max(res, right - left + 1);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] arr = {2,1,4,7,3,2,5};
        System.out.println(solution.longestMountain(arr));
    }
}
// @lc code=end

