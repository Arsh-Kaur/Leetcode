package Recursion;
/*
 * @lc app=leetcode id=77 lang=java
 *
 * [77] Combinations
 */

import java.util.ArrayList;
import java.util.List;

// @lc code=start
class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        recursion(1, k, n, new ArrayList<Integer>(), result);
        return result;
    }

    private void recursion(int current, int k, int n, List<Integer> running, List<List<Integer>> result){
        if(running.size() == k){
            result.add(new ArrayList<>(running));
            return;
        }
        for(int i= current; i<=n; i++){
            running.add(i);
            recursion(i+1, k, n, running, result);
            running.remove(running.size()-1);
        }
    }
}
// @lc code=end

