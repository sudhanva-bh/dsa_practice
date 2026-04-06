

/*
 * @lc app=leetcode id=2075 lang=java
 *
 * [2075] Decode the Slanted Ciphertext
 */

// @lc code=start

class Solution {
    public String decodeCiphertext(String encodedText, int rows) {
        if(rows == 1) return encodedText;
        int n = encodedText.length();
        int cols = n / rows;

        char[] ca = new char[n];
        Arrays.fill(ca, ' ');

        char[] ea = encodedText.toCharArray();

        for(int i = 0; i < rows; i++) {
            for(int j = i; j < cols; j++) {
                // System.out.print(ea[i * cols + j] + " ");
                ca[i + (j - i) * rows] = ea[i * cols + j];
                // System.out.print((i + (j - i) * rows) + " ");
            }
            // System.out.println();
        }

        int trim = n - 1;
        while(trim > 0 && ca[trim - 1] == ' ') trim--;

        return new String(ca).substring(0, trim);
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        String encodedText = "iveo    eed   l te   olc";
        int rows = 4;

        System.out.println(sol.decodeCiphertext(encodedText, rows));
    }
}
// @lc code=end

