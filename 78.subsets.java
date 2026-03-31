
import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode id=78 lang=java
 *
 * [78] Subsets
 */

// @lc code=start
class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        int n = nums.length;
        int max = (1 << nums.length);
        List<List<Integer>> result = new ArrayList<>();
        for(int i = 0; i < max; i++){
            List<Integer> temp = new ArrayList<>();
            for(int j = 0; j < n; j++){
                if(((1<<j)&i)==1){
                    temp.add(nums[j]);
                }
            }
            result.add(temp);
        }
        return result;
    }
}
// @lc code=end

