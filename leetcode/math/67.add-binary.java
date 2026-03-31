/*
 * @lc app=leetcode id=67 lang=java
 *
 * [67] Add Binary
 */

// @lc code=start
class AdderResult {

    boolean sum;
    boolean carry;

    AdderResult(boolean sum, boolean carry) {
        this.sum = sum;
        this.carry = carry;
    }
}

class Solution {

    public String addBinary(String a, String b) {
        int result = 0;
        char[] ca = a.toCharArray();
        char[] cb = b.toCharArray();

        AdderResult res = new AdderResult(false, false);

        int ia = a.length() - 1, ib = b.length() - 1;
        StringBuilder sb = new StringBuilder(Math.max(ia, ib) + 2);

        while (ia >= 0 && ib >= 0) {
            res = fullAdder(ca[ia--] == '1', cb[ib--] == '1', res.carry);
            sb.append(res.sum ? '1' : '0');
        }

        while (ia >= 0) {
            res = halfAdder(ca[ia--] == '1', res.carry);
            sb.append(res.sum ? '1' : '0');
        }

        while (ib >= 0) {
            res = halfAdder(cb[ib--] == '1', res.carry);
            sb.append(res.sum ? '1' : '0');
        }

        if(res.carry) sb.append('1');

        return sb.reverse().toString();
    }

    public static AdderResult fullAdder(boolean a, boolean b, boolean c) {
        return new AdderResult(a ^ b ^ c, (a & b) | (b & c) | (c & a));
    }

    public static AdderResult halfAdder(boolean a, boolean b) {
        return new AdderResult(a ^ b, a & b);
    }
}
// @lc code=end

