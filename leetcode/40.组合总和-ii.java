/*
 * @lc app=leetcode.cn id=40 lang=java
 *
 * [40] 组合总和 II
 *
 * https://leetcode.cn/problems/combination-sum-ii/description/
 *
 * algorithms
 * Medium (59.50%)
 * Likes:    1495
 * Dislikes: 0
 * Total Accepted:    483.7K
 * Total Submissions: 813K
 * Testcase Example:  '[10,1,2,7,6,1,5]\n8'
 *
 * 给定一个候选人编号的集合 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 * 
 * candidates 中的每个数字在每个组合中只能使用 一次 。
 * 
 * 注意：解集不能包含重复的组合。 
 * 
 * 
 * 
 * 示例 1:
 * 
 * 
 * 输入: candidates = [10,1,2,7,6,1,5], target = 8,
 * 输出:
 * [
 * [1,1,6],
 * [1,2,5],
 * [1,7],
 * [2,6]
 * ]
 * 
 * 示例 2:
 * 
 * 
 * 输入: candidates = [2,5,2,1,2], target = 5,
 * 输出:
 * [
 * [1,2,2],
 * [5]
 * ]
 * 
 * 
 * 
 * 提示:
 * 
 * 
 * 1 <= candidates.length <= 100
 * 1 <= candidates[i] <= 50
 * 1 <= target <= 30
 * 
 * 
 */

// @lc code=start

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

class Solution {

    List<List<Integer>> result = new ArrayList<>();

    HashMap<Integer, Integer> freqMap = new HashMap<>();

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        for (int i : candidates) {
            freqMap.put(i, freqMap.getOrDefault(i, 0) + 1);
        }
        Integer[] arr=new Integer[freqMap.keySet().size()];


        getComList(freqMap.keySet().toArray(arr), target, 0, new ArrayList<>());
        return result;
    }

    public void getComList(Integer[] candidates, int target, int index, List<Integer> inputList) {

        for (int i = index; i < candidates.length; i++) {
            for (int j = 0; j < freqMap.get(candidates[i]); j++) {
                int tmp = target - candidates[i] * (j + 1);
                if (tmp < 0) {
                    continue;
                } else if (tmp == 0) {
                    List<Integer> resultList = new ArrayList<Integer>();
                    resultList.addAll(inputList);
                    for(int k=0;k<=j;k++){
                         resultList.add(candidates[i]);
                    }
                    result.add(resultList);
                } else if (tmp > 0) {

                    List<Integer> resultList = new ArrayList<Integer>();
                    resultList.addAll(inputList);
                     for(int k=0;k<=j;k++){
                         resultList.add(candidates[i]);
                    } 
                    getComList(candidates, tmp, i + 1, resultList);
                }
            }
        }
    }
}
// @lc code=end
