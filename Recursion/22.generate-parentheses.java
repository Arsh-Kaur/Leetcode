package Recursion;
/*
 * @lc app=leetcode id=22 lang=java
 *
 * [22] Generate Parentheses
 */

import java.util.ArrayList;
import java.util.List;

// @lc code=start
class Solution {
    /**
     * @param n
     * @return
     */
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        generate(n,0,0,"",result);
        return result;
    }

    private void generate(int n, int open, int close, String running, List<String> result){
        // base case 
        if(running.length() == n*2){
            result.add(running);
            return;
        }

        // STATE :
        // number of open brackets
        // number of close brackets
        // current running string
        if(open<n){
            generate(n,open+1,close,running+'(',result);
        }
        if(close<open){
            generate(n,open,close+1,running+')',result);
        }
    }
}
// @lc code=end

