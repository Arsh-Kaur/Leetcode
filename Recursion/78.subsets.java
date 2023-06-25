package Recursion;

import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode id=78 lang=java
 *
 * [78] Subsets
 */

// @lc code=start
class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        recursionSubset(nums, 0, new ArrayList<>(), result);
        return result;
    }

    /**
     * @param nums
     * @param idx
     * @param running
     * @param result
     */
    public void recursionSubset(int[] nums, int idx, List<Integer> running, List<List<Integer>> result){
        //base case
        if(idx == nums.length){
            result.add( new ArrayList(running));
            return;
        } 

        // state => index, running list with and without value at idx.
        // 1. change index, dont change running
        // 2. change index, change running list
        recursionSubset(nums, idx+1, running, result);
        running.add(nums[idx]);
        recursionSubset(nums, idx+1, running, result);
        running.remove(running.size()-1);

    }
}
// @lc code=end

