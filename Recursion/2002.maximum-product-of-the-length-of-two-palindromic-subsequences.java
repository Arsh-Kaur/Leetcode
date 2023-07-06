package Recursion;
/*
 * @lc app=leetcode id=2002 lang=java
 *
 * [2002] Maximum Product of the Length of Two Palindromic Subsequences
 */

// @lc code=start

import java.util.ArrayList;
import java.util.List;

class Solution {
    public int maxProduct(String s) {
       int maxProd= 1;
       List<List<Integer>> array = new ArrayList<>();
        findSubseq(new ArrayList<Integer>(), 0,s,array);

        for(int i=0; i<array.size();i++){
            for(int j=i+1; j<array.size();j++){
                if(notSameIndex(array.get(i), array.get(j))){
                    maxProd = Math.max(maxProd,array.get(i).size()*array.get(j).size());
                }
            }
        }

        return maxProd;
    }

    private void findSubseq( List<Integer> subseq, int index, String s, List<List<Integer>> array){
        
        if(index >= s.length()){
            if(isPalim(subseq,s)){
                array.add(new ArrayList<>(subseq));
            }
            return;
        }

        subseq.add(index);
        findSubseq(subseq, index+1, s, array);
        subseq.remove(subseq.size()-1);
        findSubseq(subseq, index+1, s, array);
    }

    private boolean isPalim(List<Integer> sub, String s){
        int start = 0;
        int end = sub.size()-1;

        while(start<end){
            if(s.charAt(sub.get(start)) != s.charAt(sub.get(end)))
                return false;
            start++;
            end--;
        }
        return true;
    }

    private boolean notSameIndex(List<Integer> s1, List<Integer> s2){

        if(s1.size()>=s2.size()){
            for(int i=0; i<s1.size();i++){
                if(s2.contains(s1.get(i))){
                    return false;
                }
            }
        }else{
            for(int i=0; i<s2.size();i++){
                if(s1.contains(s2.get(i))){
                    return false;
                }
            }
        }
        return true;
    }
}
// @lc code=end

