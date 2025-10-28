/*
 * @lc app=leetcode.cn id=1466 lang=java
 *
 * [1466] 重新规划路线
 *
 * https://leetcode.cn/problems/reorder-routes-to-make-all-paths-lead-to-the-city-zero/description/
 *
 * algorithms
 * Medium (60.48%)
 * Likes:    211
 * Dislikes: 0
 * Total Accepted:    32.2K
 * Total Submissions: 53.2K
 * Testcase Example:  '6\n[[0,1],[1,3],[2,3],[4,0],[4,5]]'
 *
 * n 座城市，从 0 到 n-1 编号，其间共有 n-1
 * 条路线。因此，要想在两座不同城市之间旅行只有唯一一条路线可供选择（路线网形成一颗树）。去年，交通运输部决定重新规划路线，以改变交通拥堵的状况。
 * 
 * 路线用 connections 表示，其中 connections[i] = [a, b] 表示从城市 a 到 b 的一条有向路线。
 * 
 * 今年，城市 0 将会举办一场大型比赛，很多游客都想前往城市 0 。
 * 
 * 请你帮助重新规划路线方向，使每个城市都可以访问城市 0 。返回需要变更方向的最小路线数。
 * 
 * 题目数据 保证 每个城市在重新规划路线方向后都能到达城市 0 。
 * 
 * 
 * 
 * 示例 1：
 * 
 * 
 * 
 * 输入：n = 6, connections = [[0,1],[1,3],[2,3],[4,0],[4,5]]
 * 输出：3
 * 解释：更改以红色显示的路线的方向，使每个城市都可以到达城市 0 。
 * 
 * 示例 2：
 * 
 * 
 * 
 * 输入：n = 5, connections = [[1,0],[1,2],[3,2],[3,4]]
 * 输出：2
 * 解释：更改以红色显示的路线的方向，使每个城市都可以到达城市 0 。
 * 
 * 示例 3：
 * 
 * 输入：n = 3, connections = [[1,0],[2,0]]
 * 输出：0
 * 
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * 2 <= n <= 5 * 10^4
 * connections.length == n-1
 * connections[i].length == 2
 * 0 <= connections[i][0], connections[i][1] <= n-1
 * connections[i][0] != connections[i][1]
 * 
 * 
 */

// @lc code=start

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

class Solution {

    Set<Integer> attachCities = new HashSet<>();
    int count = 0;
    Map<Integer, Set<Integer>> inMap = new HashMap<>();
    Map<Integer, Set<Integer>> outMap = new HashMap<>();

    public int minReorder(int n, int[][] connections) {

        for (int i = 0; i < n - 1; i++) {
            Set<Integer> inSet = inMap.get(connections[i][1]);
            if (inSet == null) {
                inSet = new HashSet<>();
                inMap.put(connections[i][1], inSet);
            }
            inSet.add(connections[i][0]);
            Set<Integer> outSet = outMap.get(connections[i][0]);
            if (outSet == null) {
                outSet = new HashSet<>();
                outMap.put(connections[i][0], outSet);
            }
            outSet.add(connections[i][1]);
        }
        Queue<Integer> cityQueue = new ArrayDeque<>();
        attachCities.add(0);
        Set<Integer> linkCities = getLinkCity(0);
        cityQueue.addAll(linkCities);
        while (!cityQueue.isEmpty()) {
            Integer city = cityQueue.poll();
            if(!attachCities.contains(city)){
                attachCities.add(city);
                Set<Integer> tmp = getLinkCity(city);
                cityQueue.addAll(tmp);
            }
        }
        return count;
    }

    Set<Integer> getLinkCity(int city) {
        Set<Integer> result = new HashSet<>();

        Set<Integer> outSet = outMap.get(city);
        Set<Integer> inSet = inMap.get(city);

        if (inSet != null) {
            result.addAll(inSet);
        }

        if (outSet != null) {
            outSet.removeAll(attachCities);
            count += outSet.size();
            result.addAll(outSet);
        }
        return result;
    }

    public static void main(String[] args) {
        int n = 2;
        int[][] connections = new int[1][2];
        connections[0][0] = 0;
        connections[0][1] = 1;
        Solution solution = new Solution();
        System.out.println(solution.minReorder(n, connections));
    }
}
// @lc code=end
