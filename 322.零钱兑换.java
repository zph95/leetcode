/*
 * @lc app=leetcode.cn id=322 lang=java
 *
 * [322] 零钱兑换
 *
 * https://leetcode.cn/problems/coin-change/description/
 *
 * algorithms
 * Medium (48.84%)
 * Likes:    2867
 * Dislikes: 0
 * Total Accepted:    891.2K
 * Total Submissions: 1.8M
 * Testcase Example:  '[1,2,5]\n11'
 *
 * 给你一个整数数组 coins ，表示不同面额的硬币；以及一个整数 amount ，表示总金额。
 * 
 * 计算并返回可以凑成总金额所需的 最少的硬币个数 。如果没有任何一种硬币组合能组成总金额，返回 -1 。
 * 
 * 你可以认为每种硬币的数量是无限的。
 * 
 * 
 * 
 * 示例 1：
 * 
 * 
 * 输入：coins = [1, 2, 5], amount = 11
 * 输出：3 
 * 解释：11 = 5 + 5 + 1
 * 
 * 示例 2：
 * 
 * 
 * 输入：coins = [2], amount = 3
 * 输出：-1
 * 
 * 示例 3：
 * 
 * 
 * 输入：coins = [1], amount = 0
 * 输出：0
 * 
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * 1 <= coins.length <= 12
 * 1 <= coins[i] <= 2^31 - 1
 * 0 <= amount <= 10^4
 * 
 * 
 */

// @lc code=start
class Solution {
    public int coinChange(int[] coins, int amount) {
        // dp[i]表示凑成金额i所需的最少硬币个数
        int[] dp = new int[amount + 1];
        // 初始化dp数组
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;
        // 遍历金额
        for (int i = 1; i <= amount; i++) {
            // 遍历硬币
            for (int coin : coins) {
                // 如果硬币面值大于金额i，则跳过
                if (coin > i) {
                    continue;
                }
                // 状态转移方程
                dp[i] = Math.min(dp[i], dp[i - coin] + 1);
            }
        }
        // 如果dp[amount] > amount，则说明凑不出来，返回-1
        return dp[amount] > amount ? -1 : dp[amount];
    }
}
// @lc code=end

