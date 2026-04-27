/*
 * @lc app=leetcode id=3606 lang=java
 *
 * [3606] Coupon Code Validator
 */

// @lc code=start

import java.util.*;
import java.util.regex.Pattern;

class Solution {
    private static final Pattern PATTERN = Pattern.compile("^[a-zA-Z0-9_]*$");

    public static boolean isValid(String s) {
        return s != null && PATTERN.matcher(s).matches();
    }

    public List<String> validateCoupons(String[] code, String[] businessLine, boolean[] isActive) {
        List<String> elecRes = new ArrayList<>();
        List<String> grocRes = new ArrayList<>();
        List<String> pharRes = new ArrayList<>();
        List<String> restRes = new ArrayList<>();
        int n = code.length;
        
        for(int i = 0; i < n; i++) {
            if(isActive[i] && isValid(code[i])) {
                switch (businessLine[i].charAt(0)) {
                    case 'e' -> elecRes.add(code[i]);
                    case 'g' -> grocRes.add(code[i]);
                    case 'p' -> pharRes.add(code[i]);
                    case 'r' -> restRes.add(code[i]);
                }
            }
        }

        Collections.sort(elecRes);
        Collections.sort(grocRes);
        Collections.sort(pharRes);
        Collections.sort(restRes);

        elecRes.addAll(grocRes);
        elecRes.addAll(pharRes);
        elecRes.addAll(restRes);

        return elecRes;
    }
}
// @lc code=end

