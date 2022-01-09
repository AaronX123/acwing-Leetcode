package leetcode;

import java.util.Arrays;

/**
 * @link https://leetcode-cn.com/problems/merge-sorted-array/
 */
public class No88 {

    /**
     * 观察可得，如果从小往大去放置元素，则每次都需要挪动插入位置后面的元素，所以直接从大往小放。
     * @param nums1
     * @param m
     * @param nums2
     * @param n
     */
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if (nums1 == null || nums2 == null || n == 0) return;
        // 分别是数组1的数据当前指向， 数组2的数据当前指向，数组1实际空间使用指向。
        int arr1Idx = m - 1, arr2Idx = n - 1, arrUsedIdx = nums1.length -1;
        while (arr1Idx >= 0 && arr2Idx >= 0) {
            // 比较谁更大
            if (nums1[arr1Idx] >= nums2[arr2Idx]) {
                nums1[arrUsedIdx] = nums1[arr1Idx];
                arr1Idx--;
            } else {
                nums1[arrUsedIdx] = nums2[arr2Idx];
                arr2Idx--;
            }
            arrUsedIdx--;
        }

        // 此时剩下数组2的元素
        if (arr1Idx < 0) {
            for (; arr2Idx >= 0; arr2Idx--) {
                nums1[arrUsedIdx] = nums2[arr2Idx];
                arrUsedIdx--;
            }
        }
        // 此时剩下数组1的元素，又因为本身最终结果是放在数组1的，所以不需要做处理。
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1,2,3,4,0,0,0,0};
        int[] arr2 = new int[]{1,3,4,5};
        new No88().merge(arr, 4, arr2, 4);
        System.out.println(Arrays.toString(arr));
    }
}
