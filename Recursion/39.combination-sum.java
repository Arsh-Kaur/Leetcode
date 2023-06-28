package Recursion;
/*
 * @lc app=leetcode id=39 lang=java
 *
 * [39] Combination Sum
 */

// @lc code=start

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(candidates, target, new ArrayList<Integer>(), 0, result);
        return result;
    }

    public void backtrack(int[] candidates, int target, List<Integer> running, int idx, List<List<Integer>> result){
        //base case 1 -> sum not possible with current combination
        if(target < 0) return;

        //base case 2 -> found the combination
        else if(target == 0){
            result.add(new ArrayList<>(running));
        }
        
        //backtrack
        else{
            for(int i = idx; i<candidates.length ; i++){
                running.add(candidates[i]);
                backtrack(candidates, target-candidates[i], running, i, result);
                running.remove(running.size()-1);
            }
        }
    }
}
// @lc code=end

