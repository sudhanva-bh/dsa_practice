/*
 * @lc app=leetcode id=273 lang=java
 *
 * [273] Integer to English Words
 */

// @lc code=start
class Pair {
    int num;
    String rep;

    Pair(int num, String rep) {
        this.num = num;
        this.rep = rep;
    }
}

class Solution {
    final static String[] mapLT20 = {
            "",
            "One",
            "Two",
            "Three",
            "Four",
            "Five",
            "Six",
            "Seven",
            "Eight",
            "Nine",
            "Ten",
            "Eleven",
            "Twelve",
            "Thirteen",
            "Fourteen",
            "Fifteen",
            "Sixteen",
            "Seventeen",
            "Eighteen",
            "Nineteen"
    };

    final static String[] mapGT20 = {
            "",
            "",
            "Twenty",
            "Thirty",
            "Forty",
            "Fifty",
            "Sixty",
            "Seventy",
            "Eighty",
            "Ninety"
    };

    String buildTwoDigitNum(int x) {
        if (x < 20)
            return mapLT20[x];

        return mapGT20[x / 10] +
                (x % 10 == 0 ? "" : " " + mapLT20[x % 10]);
    }

    String buildThreeDigitNum(int x) {
        if (x < 100) {
            return buildTwoDigitNum(x);
        } else {
            return mapLT20[x / 100] + " Hundred" +
                    (x % 100 == 0 ? "" : " " + buildTwoDigitNum(x % 100));
        }
    }

    public String numberToWords(int num) {
        if(num == 0) return "Zero";
        
        int curr = 0;
        
        String ans = buildThreeDigitNum(num % 1000);    // 3 digits

        curr *= 1000;
        curr += num % 1000;
        num /= 1000;
        if(num > 0 && num % 1000 > 0) {                                   // thousands
            ans = buildThreeDigitNum(num % 1000) + " Thousand" + 
                ((curr == 0) ? "" : " ") + ans;
        }

        curr *= 1000;
        curr += num % 1000;
        num /= 1000;
        if(num > 0 && num % 1000 > 0) {                                   // Millions
            ans = buildThreeDigitNum(num % 1000) + " Million" + 
                ((curr == 0) ? "" : " ") + ans;
        }

        curr *= 1000;
        curr += num % 1000;
        num /= 1000;
        if(num > 0 && num % 1000 > 0) {                                   // Billions
            ans = buildThreeDigitNum(num % 1000) + " Billion" + 
                ((curr == 0) ? "" : " ") + ans;
        }

        return ans;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        System.out.println(sol.numberToWords(100000));
    }
}
// @lc code=end
