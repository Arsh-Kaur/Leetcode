package Recursion;
/*
 * @lc app=leetcode id=40 lang=java
 *
 * [40] Combination Sum II
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// @lc code=start
class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(candidates);
        recursion(candidates, 0, target, new ArrayList<Integer>(), result);
        return result;
    }

    private void recursion(int[] arr, int idx, int target, List<Integer> running, List<List<Integer>> result){
        
        //case 1 = if target achieved, add to result
        if(target ==0){
            result.add(new ArrayList<>(running));
            return;
        }

        // case 2 = if target<0 - can't be achieved or index at end of list
        // return
        if(idx == arr.length || target<0){
            return;
        }
        
        //avoid any duplicate calls
        for(int i=idx; i<arr.length;i++){
            if(i==idx || arr[i] != arr[i-1]){
                running.add(arr[i]);
                recursion(arr, i+1, target-arr[i], running, result);
                running.remove(running.size()-1);
            }
        }

        
    }
}
// @lc code=end

