package Recursion;
/*
 * @lc app=leetcode id=17 lang=java
 *
 * [17] Letter Combinations of a Phone Number
 */

import java.sql.Array;
import java.util.ArrayList;
import java.util.List;

// @lc code=start
class Solution {
    public List<String> letterCombinations(String digits) {
        //Base Case
        if(digits.length() == 0) return new ArrayList<String>();
        String[] map = {"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};

        List<String> result = new ArrayList<>();
        
        backtrack(map, digits, 0, new StringBuilder(), result);  
        
        return result;

    }

    private void backtrack(String[] map, String digits, int idx, StringBuilder running, List<String> result ){
        if(running.length() == digits.length()){
            result.add(running.toString());
            return;
        }

        int digit = digits.charAt(idx)-'0';
        int dlen = map[digit].length();
        for(int i=0; i<dlen; i++){
            running.append(map[digit].charAt(i));
            backtrack(map, digits,idx+1,running,result);
            running.deleteCharAt(running.length()-1);
        }
    }
}
// @lc code=end

