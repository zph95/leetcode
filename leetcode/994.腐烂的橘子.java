/*
 * @lc app=leetcode.cn id=994 lang=java
 *
 * [994] 腐烂的橘子
 *
 * https://leetcode.cn/problems/rotting-oranges/description/
 *
 * algorithms
 * Medium (51.21%)
 * Likes:    785
 * Dislikes: 0
 * Total Accepted:    136.7K
 * Total Submissions: 266.9K
 * Testcase Example:  '[[2,1,1],[1,1,0],[0,1,1]]'
 *
 * 在给定的 m x n 网格 grid 中，每个单元格可以有以下三个值之一：
 * 
 * 
 * 值 0 代表空单元格；
 * 值 1 代表新鲜橘子；
 * 值 2 代表腐烂的橘子。
 * 
 * 
 * 每分钟，腐烂的橘子 周围 4 个方向上相邻 的新鲜橘子都会腐烂。
 * 
 * 返回 直到单元格中没有新鲜橘子为止所必须经过的最小分钟数。如果不可能，返回 -1 。
 * 
 * 
 * 
 * 示例 1：
 * 
 * 
 * 
 * 
 * 输入：grid = [[2,1,1],[1,1,0],[0,1,1]]
 * 输出：4
 * 
 * 
 * 示例 2：
 * 
 * 
 * 输入：grid = [[2,1,1],[0,1,1],[1,0,1]]
 * 输出：-1
 * 解释：左下角的橘子（第 2 行， 第 0 列）永远不会腐烂，因为腐烂只会发生在 4 个正向上。
 * 
 * 
 * 示例 3：
 * 
 * 
 * 输入：grid = [[0,2]]
 * 输出：0
 * 解释：因为 0 分钟时已经没有新鲜橘子了，所以答案就是 0 。
 * 
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * m == grid.length
 * n == grid[i].length
 * 1 <= m, n <= 10
 * grid[i][j] 仅为 0、1 或 2
 * 
 * 
 */

// @lc code=start

import java.util.HashSet;
import java.util.Set;

class Solution {

    Set<String> badSet = new HashSet();

    public int orangesRotting(int[][] grid) {

        int m = grid.length;
        int n = grid[0].length;
        int totalCount = 0;
        int time = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 2) {
                    totalCount++;
                    badSet.add(String.valueOf(i) + "_" + String.valueOf(j));
                }
                if (grid[i][j] == 1) {
                    totalCount++;
                }
            }
        }

        Set<String> preBad = getNewBad(badSet, grid, m, n);
        while (!preBad.isEmpty()) {
            time++;
            preBad = getNewBad(preBad, grid, m, n);
        }
        if (badSet.size() < totalCount) {
            return -1;
        } else {
            return time;
        }

    }

    Set<String> getNewBad(Set<String> preBad, int[][] grid, int m, int n) {
        Set<String> newBad = new HashSet<>();
        for (String pair : preBad) {
            String[] pos = pair.split("_");
            Integer row = Integer.valueOf(pos[0]);
            Integer col = Integer.valueOf(pos[1]);
            if (row + 1 <= m - 1
                    && !badSet.contains(String.valueOf(row + 1) + "_" + col)
                    && grid[row + 1][col] == 1) {
                newBad.add(String.valueOf(row + 1) + "_" + col);
            }
            if (row - 1 >= 0
                    && !badSet.contains(String.valueOf(row - 1) + "_" + col)
                    && grid[row - 1][col] == 1) {
                newBad.add(String.valueOf(row - 1) + "_" + col);
            }
            if (col + 1 <= n - 1
                    && !badSet.contains(row + "_" + String.valueOf(col + 1))
                    && grid[row][col + 1] == 1) {
                newBad.add(row + "_" + String.valueOf(col + 1));
            }
            if (col - 1 >= 0
                    && !badSet.contains(row + "_" + String.valueOf(col - 1))
                    && grid[row][col - 1] == 1) {
                newBad.add(row + "_" + String.valueOf(col - 1));
            }
        }
        badSet.addAll(newBad);
        return newBad;
    }

    public static void main(String[] args) {
        int[][] grid = new int[3][3];
        grid[0] = new int[] { 2, 1, 1 };
        grid[1] = new int[] { 1, 1, 0 };
        grid[2] = new int[] { 0, 1, 1 };
        Solution solution = new Solution();
        System.out.println(solution.orangesRotting(grid));
    }
}
// @lc code=end
