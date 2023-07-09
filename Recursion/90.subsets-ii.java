package Recursion;
/*
 * @lc app=leetcode id=90 lang=java
 *
 * [90] Subsets II
 */

// @lc code=start

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        recurse(nums, 0, new ArrayList<Integer>(), result);
        return result;
    }

    private void recurse(int[] nums,int idx, List<Integer> running, List<List<Integer>> result){
        if(!result.contains(running))
            result.add(new ArrayList<>(running));

        for(int i=idx; i<nums.length;i++){
            // if(i!=0 && nums[i]==nums[i-1])
            //     continue;
            running.add(nums[i]);
            recurse(nums,i+1, running, result);
            running.remove(running.size()-1);
        }
  
    }
}
// @lc code=end

