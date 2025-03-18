/*
 * @lc app=leetcode.cn id=1036 lang=java
 *
 * [1036] 逃离大迷宫
 */

// @lc code=start

import java.util.HashSet;
import java.util.Set;

class Solution {
    public boolean isEscapePossible(int[][] blocked, int[] source, int[] target) {
        if(blocked.length == 0) {
            return true;
        }
        int N = 1_000_000;
        Set<Pair> blockedSet = new HashSet<>();
        for (int[] block : blocked) {
            blockedSet.add(new Pair(block[0], block[1]));
        }
        return bfs(blockedSet, source, target, N) && bfs(blockedSet, target, source, N);
    }

    private boolean bfs(Set<Pair> blockedSet, int[] source, int[] target, int N) {
        int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        Set<Pair> visited = new HashSet<>();
        visited.add(new Pair(source[0], source[1]));
        Set<Pair> current = new HashSet<>();
        current.add(new Pair(source[0], source[1]));
        while (!current.isEmpty()) {
            Set<Pair> next = new HashSet<>();
            for (Pair pos : current) {
                int x = pos.x, y = pos.y;
                for (int[] direction : directions) {
                    int nx = x + direction[0], ny = y + direction[1];
                    Pair nextPos = new Pair(nx, ny);
                    if (nx >= 0 && nx < N && ny >= 0 && ny < N 
                    && !visited.contains(nextPos)
                    && !blockedSet.contains(nextPos)) {
                        if (nx == target[0] && ny == target[1]) {
                            return true;
                        }
                        visited.add(nextPos);
                        next.add(nextPos);
                    }
                }
            }
            if (visited.size() > (blockedSet.size()-1)*blockedSet.size()/2) {
                return true;
            }
            current = next;
        }
        return false;
    }

    class Pair{
        int x;
        int y;
        Pair(int x, int y) {
            this.x = x;
            this.y = y;
       
        }
        @Override
        public int hashCode() {
            return (int) ((long) x << 20 | y);
        }

        @Override
        public boolean equals(Object obj) {
            Pair pair = (Pair) obj;
            return this.x == pair.x && this.y == pair.y;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] blocked = {{0, 1}, {1, 0}};
        int[] source = {0, 0};
        int[] target = {0, 2};
        System.out.println(solution.isEscapePossible(blocked, source, target));
    }
}
// @lc code=end

