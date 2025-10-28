/*
 * @lc app=leetcode.cn id=695 lang=java
 *
 * [695] 岛屿的最大面积
 */

// @lc code=start
class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int maxArea = 0;
        int row = grid.length;
        int col = grid[0].length;
        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                if (grid[i][j] == 1) { // 只有当前单元格为1时才调用dfs
                    maxArea = Math.max(maxArea, dfs(grid, i, j));
                }
            }
        }
        return maxArea;
    }

    private int dfs(int[][] grid, int i, int j ){
        if(i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == 0){
            return 0;
        }
        grid[i][j] = 0; // 标记为已访问
        int area = 1;
        int[] directions = {0, 1, 0, -1, 0}; // 方向数组，表示上下左右
        for (int d = 0; d < 4; d++) {
            area += dfs(grid, i + directions[d], j + directions[d + 1]);
        }
        return area;
    }
    
}
// @lc code=end

