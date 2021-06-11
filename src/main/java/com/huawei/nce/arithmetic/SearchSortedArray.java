package com.huawei.nce.arithmetic;

/**
 * TODO
 *
 * @author Administrator
 * @date 2021/1/5 20:51
 */

/***
 * 给定一个升序整数数组，写一个函数搜索nums中的数字target，
 * 如果target存在，返回它的下标，否则返回-1。注意，这个数组的长度的大小是未知的，
 * 你只能通过ArrayReader接口访问这个数组
 **/
public class SearchSortedArray {
    /***
     *   本题的难点在于：如何确定搜索边界
     *   我们一开始先定义边界为 [0, 1]，即 left = 0; right = 1;
     *   下面就开始不断逼近合适的边界：
     *   如果 reader.get(right) < target，说明左边界可以更新为 left = right，
     *  但是右边界不能简单的 right = right + 1，否则找边界就得找到猴年马月。
     *   我们确定边界后，肯定是使用二分法来定位目标，因此，我们直接把右边界更新为 right = right × 2 是最合适的。
     *   确定了左右边界后，剩下的就是最简单的二分查找。
     **/
    public int search (ArrayReader reader, int target) {
        int left = 0;
        int right = 1;
        // 如果目标元素大于有边界对应的数组元素.则扩大边界.
        while(target > reader.get(right)) {
            left = right;
            right = right * 2;
        }
        int middle;
        while(left <= right) {
            middle =  (left +right)/2;
            if (reader.get(middle) <target) {
                left = middle +1;
            } else if (reader.get(middle) > target) {
                right = middle -1;
            } else {
                return middle;
            }
        }
        return -1;
    }
}
