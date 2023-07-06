package Recursion;
/*
 * @lc app=leetcode id=31 lang=java
 *
 * [31] Next Permutation
 */

// @lc code=start
class Solution {
    public void nextPermutation(int[] nums) {
        int idx1 = -1;
        int idx2 =-1;
        for(int i=nums.length-2; i>=0;i--){
            if(nums[i] < nums[i+1]){
                idx1 = i;
                break;
            }
        }
        if(idx1 == -1){
            reverse(nums,0);
        }else{
            for(int i=nums.length-1; i>=0;i--){
                if(nums[i]>nums[idx1]){
                    idx2=i;
                    break;
                }
            }
            int temp = nums[idx2];
            nums[idx2] = nums[idx1];
            nums[idx1] = temp;
            reverse(nums,idx1+1);
        }
    }

    private void reverse(int[] nums,int index){
        int fin = (nums.length - index)/2;
        int end = nums.length-1;
        for(int i=index; i<index+fin;i++){
            int temp = nums[i];
            nums[i] = nums[end];
            nums[end] = temp;
            end--;
            
        }
    }
}
// @lc code=end

