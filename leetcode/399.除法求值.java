/*
 * @lc app=leetcode.cn id=399 lang=java
 *
 * [399] 除法求值
 *
 * https://leetcode.cn/problems/evaluate-division/description/
 *
 * algorithms
 * Medium (58.93%)
 * Likes:    1049
 * Dislikes: 0
 * Total Accepted:    87.9K
 * Total Submissions: 149.1K
 * Testcase Example:  '[["a","b"],["b","c"]]\n' +
  '[2.0,3.0]\n' +
  '[["a","c"],["b","a"],["a","e"],["a","a"],["x","x"]]'
 *
 * 给你一个变量对数组 equations 和一个实数值数组 values 作为已知条件，其中 equations[i] = [Ai, Bi] 和
 * values[i] 共同表示等式 Ai / Bi = values[i] 。每个 Ai 或 Bi 是一个表示单个变量的字符串。
 * 
 * 另有一些以数组 queries 表示的问题，其中 queries[j] = [Cj, Dj] 表示第 j 个问题，请你根据已知条件找出 Cj / Dj
 * = ? 的结果作为答案。
 * 
 * 返回 所有问题的答案 。如果存在某个无法确定的答案，则用 -1.0 替代这个答案。如果问题中出现了给定的已知条件中没有出现的字符串，也需要用 -1.0
 * 替代这个答案。
 * 
 * 注意：输入总是有效的。你可以假设除法运算中不会出现除数为 0 的情况，且不存在任何矛盾的结果。
 * 
 * 注意：未在等式列表中出现的变量是未定义的，因此无法确定它们的答案。
 * 
 * 
 * 
 * 示例 1：
 * 
 * 
 * 输入：equations = [["a","b"],["b","c"]], values = [2.0,3.0], queries =
 * [["a","c"],["b","a"],["a","e"],["a","a"],["x","x"]]
 * 输出：[6.00000,0.50000,-1.00000,1.00000,-1.00000]
 * 解释：
 * 条件：a / b = 2.0, b / c = 3.0
 * 问题：a / c = ?, b / a = ?, a / e = ?, a / a = ?, x / x = ?
 * 结果：[6.0, 0.5, -1.0, 1.0, -1.0 ]
 * 注意：x 是未定义的 => -1.0
 * 
 * 示例 2：
 * 
 * 
 * 输入：equations = [["a","b"],["b","c"],["bc","cd"]], values = [1.5,2.5,5.0],
 * queries = [["a","c"],["c","b"],["bc","cd"],["cd","bc"]]
 * 输出：[3.75000,0.40000,5.00000,0.20000]
 * 
 * 
 * 示例 3：
 * 
 * 
 * 输入：equations = [["a","b"]], values = [0.5], queries =
 * [["a","b"],["b","a"],["a","c"],["x","y"]]
 * 输出：[0.50000,2.00000,-1.00000,-1.00000]
 * 
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * 1 <= equations.length <= 20
 * equations[i].length == 2
 * 1 <= Ai.length, Bi.length <= 5
 * values.length == equations.length
 * 0.0 < values[i] <= 20.0
 * 1 <= queries.length <= 20
 * queries[i].length == 2
 * 1 <= Cj.length, Dj.length <= 5
 * Ai, Bi, Cj, Dj 由小写英文字母与数字组成
 * 
 * 
 */

// @lc code=start

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class Solution {
    Map<String, Map<String, Double>> equationsMap;
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {

        equationsMap=new HashMap<>();

        for(int i=0;i<values.length;i++){
            List<String> equation= equations.get(i);
            Double value=values[i];
            String key1= equation.get(0);
            String key2= equation.get(1);
            Map<String, Double> valueMap1 = equationsMap.get(key1);
            if(valueMap1==null){
                valueMap1=new HashMap<>();
                equationsMap.put(key1, valueMap1);
            }
            valueMap1.put(key2, value);

            Map<String, Double> valueMap2 = equationsMap.get(key2);
            if(valueMap2 == null){
                valueMap2 = new HashMap<>();
                equationsMap.put(key2, valueMap2);
            }
            valueMap2.put(key1, 1/value);
        }

        double[] result=new double[queries.size()];
        for(int i=0;i<queries.size();i++){
            result[i]=calcValue(queries.get(i).get(0), queries.get(i).get(1), new HashSet<>());
        }
        return result;

    }

    private double calcValue(String key1, String key2, Set<String> keySet){
        Map<String, Double> valueMap=equationsMap.get(key1);
        if(valueMap==null){
            return -1.0;
        }
        if(key1.equals(key2)){
            return 1.0;
        }
        else{
            keySet.add(key1);
            for(Map.Entry<String, Double> entry: valueMap.entrySet()){
                if(keySet.contains(entry.getKey())){
                    continue;
                }
                HashSet<String> tmpSet=new HashSet<>();
                tmpSet.addAll(keySet);
                Double result = calcValue(entry.getKey(), key2, tmpSet )*entry.getValue();
                if(result>0){
                    return result;
                }
            }
        }
        return -1;
    }
}
// @lc code=end

