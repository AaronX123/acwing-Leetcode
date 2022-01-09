package leetcode;

/**
 * @link https://leetcode-cn.com/problems/majority-element/
 */
public class No169 {
    /**
     * 定一个计数器，记录当前val出现的次数，如果为0则更换
     * @param nums
     * @return
     */
    public int majorityElement(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int count = 1;
        int cur = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (cur == nums[i]) {
                count++;
            } else {
                count--;
            }
            if (count == 0) {
                cur = nums[i];
                count = 1;
            }
        }
        return cur;
    }

    public static void main(String[] args) {
        System.out.println(new No169().majorityElement(new int[]{1,1,1,1,2,3,4,5}));
    }
}
