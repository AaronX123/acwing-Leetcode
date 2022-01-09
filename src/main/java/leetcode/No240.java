package leetcode;

/**
 * @link https://leetcode-cn.com/problems/search-a-2d-matrix-ii/
 */
public class No240 {
    /**
     * 从右上角看，右上角的元素一定是一行的最大值，一列的最小值。因此可以用于缩短用于搜索的矩形区域
     * @param matrix
     * @param target
     * @return
     */
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0) {
            return false;
        }

        for (int i = matrix[0].length - 1; i >= 0; i--) {
            for (int j = 0; j < matrix.length; j++) {
                if (target == matrix[j][i]) {
                    return true;
                }
                // 如果target小于于该矩形右上角的值，则向左缩小矩形
                if (target < matrix[j][i]) {
                    break;
                }
                // 如果target大于矩形右上角的值，则向下缩小矩形
                // continue;

                // 如果此时已经走完了，还没找到，则说明不存在了
                if (j == matrix.length - 1) {
                    return false;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        //System.out.println(new No240().searchMatrix(new int[][]{{1,4,7,11,15},{2,5,8,12,19},{3,6,9,16,22},{10,13,14,17,24},{18,21,23,26,30}}, 5));
        System.out.println(new No240().searchMatrix(new int[][]{{1,1}}, 0));

        int[][] arr = new int[][]{{1,2,3},{1,2}};
        System.out.println(arr.length + " " + arr[0].length);
    }

}
