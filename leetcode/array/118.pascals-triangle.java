
import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode id=118 lang=java
 *
 * [118] Pascal's Triangle
 */
// @lc code=start
class Solution {

    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> arrList = new ArrayList<>();
        List<Integer> row1 = new ArrayList<>();
        row1.add(1);
        arrList.add(row1);
        if (numRows == 1) {
            return arrList;
        }
        for (int i = 2; i <= numRows; i++) {
            List<Integer> rowi = new ArrayList<>();
            rowi.add(1);
            List<Integer> rowiminus1 = arrList.get(i - 2);
            for (int j = 1; j < i - 1; j++) {
                rowi.add(rowiminus1.get(j) + rowiminus1.get(j + 1));
            }
            arrList.add(rowi);
        }
        return arrList;
    }
}
// @lc code=end

