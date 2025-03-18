/**
 * @param {number} n
 * @param {number[][]} edges
 * @return {number}
 */
var minTrioDegree = function(n, edges) {

    const degree = Array(n).fill(0);
    const g = Array(n).fill(0).map(()=> new Array(n).fill(0));
g
    for (const [x, y] of edges) {
        g[x - 1][y - 1] = g[y - 1][x - 1] = 1;
        degree[x - 1]++;
        degree[y - 1]++;
    }


    let ans = Infinity;
    for (let i = 0; i < n; ++i) {
        for (let j = i + 1; j < n; ++j) {
            if (g[i][j] == 1) {
                for (let k = j + 1; k < n; ++k) {
                    if (g[i][k] == 1 && g[j][k] == 1) {
                        ans = Math.min(ans, degree[i] + degree[j] + degree[k] - 6);
                    }
                }
            }
        }
    }
    return ans == Infinity ? -1 : ans;
};


let n = 7;
let edges = [[1,3],[4,1],[4,3],[2,5],[5,6],[6,7],[7,5],[2,6]];

console.log(minTrioDegree(n, edges));