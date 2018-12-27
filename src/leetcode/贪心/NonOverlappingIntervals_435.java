package leetcode.贪心;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @Author jiangyunxiong
 * @Date 2018/12/20 下午10:04
 *
 *  435. 不重叠的区间个数
 *
 * Input: [ [1,2], [1,2], [1,2] ]
 *
 * Output: 2
 *
 * Explanation: You need to remove two [1,2] to make the rest of intervals non-overlapping.
 * Input: [ [1,2], [2,3] ]
 *
 * Output: 0
 *
 * Explanation: You don't need to remove any of the intervals since they're already non-overlapping.
 * 题目描述：计算让一组区间不重叠所需要移除的区间个数。
 *
 * 先计算最多能组成的不重叠区间个数，然后用区间总个数减去不重叠区间的个数。
 *
 * 在每次选择中，区间的结尾最为重要，选择的区间结尾越小，留给后面的区间的空间越大，那么后面能够选择的区间个数也就越大。
 *
 * 按区间的结尾进行排序，每次选择结尾最小，并且和前一个区间不重叠的区间。
 */



public class NonOverlappingIntervals_435 {

    public int eraseOverlapIntervals(Interval[] intervals) {

        if (intervals.length == 0) {
            return 0;
        }

        Arrays.sort(intervals, new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                return o1.end - o2.end;
            }
        });

        int num = 1;
        int end = intervals[0].end;
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i].start < end){
                continue;
            }
            end = intervals[i].end;
            num++;
        }
        return intervals.length - num;
    }



    class Interval {
        int start;
        int end;

        Interval() {
            start = 0;
            end = 0;
        }

        Interval(int s, int e) {
            start = s;
            end = e;
        }
    }

}
