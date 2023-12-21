/*
 * @lc app=leetcode.cn id=1926 lang=java
 *
 * [1926] 迷宫中离入口最近的出口
 *
 * https://leetcode.cn/problems/nearest-exit-from-entrance-in-maze/description/
 *
 * algorithms
 * Medium (39.91%)
 * Likes:    74
 * Dislikes: 0
 * Total Accepted:    18.9K
 * Total Submissions: 47.2K
 * Testcase Example:  '[["+","+",".","+"],[".",".",".","+"],["+","+","+","."]]\n[1,2]'
 *
 * 给你一个 m x n 的迷宫矩阵 maze （下标从 0 开始），矩阵中有空格子（用 '.' 表示）和墙（用 '+' 表示）。同时给你迷宫的入口
 * entrance ，用 entrance = [entrancerow, entrancecol] 表示你一开始所在格子的行和列。
 * 
 * 每一步操作，你可以往 上，下，左 或者 右 移动一个格子。你不能进入墙所在的格子，你也不能离开迷宫。你的目标是找到离 entrance 最近
 * 的出口。出口 的含义是 maze 边界 上的 空格子。entrance 格子 不算 出口。
 * 
 * 请你返回从 entrance 到最近出口的最短路径的 步数 ，如果不存在这样的路径，请你返回 -1 。
 * 
 * 
 * 
 * 示例 1：
 * 
 * 输入：maze = [["+","+",".","+"],[".",".",".","+"],["+","+","+","."]], entrance
 * = [1,2]
 * 输出：1
 * 解释：总共有 3 个出口，分别位于 (1,0)，(0,2) 和 (2,3) 。
 * 一开始，你在入口格子 (1,2) 处。
 * - 你可以往左移动 2 步到达 (1,0) 。
 * - 你可以往上移动 1 步到达 (0,2) 。
 * 从入口处没法到达 (2,3) 。
 * 所以，最近的出口是 (0,2) ，距离为 1 步。
 * 
 * 
 * 示例 2：
 * 
 * 输入：maze = [["+","+","+"],[".",".","."],["+","+","+"]], entrance = [1,0]
 * 输出：2
 * 解释：迷宫中只有 1 个出口，在 (1,2) 处。
 * (1,0) 不算出口，因为它是入口格子。
 * 初始时，你在入口与格子 (1,0) 处。
 * - 你可以往右移动 2 步到达 (1,2) 处。
 * 所以，最近的出口为 (1,2) ，距离为 2 步。
 * 
 * 
 * 示例 3：
 * 
 * 输入：maze = [[".","+"]], entrance = [0,0]
 * 输出：-1
 * 解释：这个迷宫中没有出口。
 * 
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * maze.length == m
 * maze[i].length == n
 * 1 <= m, n <= 100
 * maze[i][j] 要么是 '.' ，要么是 '+' 。
 * entrance.length == 2
 * 0 <= entrancerow < m
 * 0 <= entrancecol < n
 * entrance 一定是空格子。
 * 
 * 
 */

// @lc code=start

import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Queue;
import java.util.Set;

class Solution {
    class Grid {
        Integer row;
        Integer col;
        int count;

        Grid(int row, int col, int count) {
            this.row = row;
            this.col = col;
            this.count = count;
        }
    }

    public int nearestExit(char[][] maze, int[] entrance) {

        int rowLength = maze.length;
        int colLength = maze[0].length;

        Set<String> gridSet = new HashSet<>();

        Queue<Grid> gridQueue = new ArrayDeque<>();
        Grid entryGrid = new Grid(entrance[0], entrance[1], 0);
        gridQueue.add(entryGrid);

        while (!gridQueue.isEmpty()) {
            Grid grid = gridQueue.poll();
            Integer row = grid.row;
            Integer col = grid.col;
            String tmp = grid.row.toString() + "_" + grid.col.toString();
            if (!gridSet.contains(tmp)) {
                gridSet.add(row.toString() + "_" + col.toString());

                if (col == 0 || col == colLength - 1 || row == 0 || row == rowLength - 1) {
                    if (grid.count != 0) {
                        return grid.count;
                    }
                }

                if (row + 1 <= rowLength-1 && maze[row + 1][col] == '.') {
                    gridQueue.add(new Grid(row + 1, col, grid.count + 1));
                }
                if (row - 1 >= 0 && maze[row - 1][col] == '.') {
                    gridQueue.add(new Grid(row - 1, col, grid.count + 1));
                }
                if (col + 1 <= colLength-1 && maze[row][col + 1] == '.') {
                    gridQueue.add(new Grid(row, col + 1, grid.count + 1));
                }
                if (col - 1 >= 0 && maze[row][col - 1] == '.') {
                    gridQueue.add(new Grid(row, col - 1, grid.count + 1));
                }

            }
        }
        return -1;
    }
}
// @lc code=end
