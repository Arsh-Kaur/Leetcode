package Recursion;

/*
 * @lc app=leetcode id=46 lang=java
 *
 * [46] Permutations
 */

// @lc code=start

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> prefix = new ArrayList<>();
        List<Integer> running = new ArrayList<>();
        for(int num:nums){
            running.add(num);
        }

        findpermute(running, prefix, result);
        return result;
    }

    public void findpermute(List<Integer> running, List<Integer> prefix, List<List<Integer>> result){
        //Base Case
        if(running.size() == 0){
            result.add(prefix);
        }
        for(int i=0; i<running.size(); i++){
            List<Integer> newprefix = new ArrayList<>(prefix);
            newprefix.add(running.get(i));
            List<Integer> newrunning = new ArrayList<>(running);
            newrunning.remove(i);
            findpermute(newrunning, newprefix, result);
        }
    }
}
// @lc code=end

