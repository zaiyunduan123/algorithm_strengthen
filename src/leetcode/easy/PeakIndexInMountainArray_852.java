package leetcode.easy;

/**
 * @Author jiangyunxiong
 * @Date 2018/12/22 下午1:22
 */
public class PeakIndexInMountainArray_852 {
    public int peakIndexInMountainArray(int[] A) {
        int result =0;
        for (int i = 1; i < A.length - 1; i++) {
            if (A[i] > A[i + 1]) {
                result = i;
                break;
            }
        }
        return result;
    }
}