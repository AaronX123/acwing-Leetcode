package leetcode;

/**
 * @link https://leetcode-cn.com/problems/single-number/
 */
public class No136 {
    /**
     * 根据题意举例，比如[1,2,1,3,3,4,4]，已知性质n与n的异或结果为0
     * @param nums
     * @return
     */
    public int singleNumber(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int res = 0;
        for (int num : nums) {
            res ^= num;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new No136().singleNumber(new int[]{1,2,1,3,3,4,4}));
    }
}
