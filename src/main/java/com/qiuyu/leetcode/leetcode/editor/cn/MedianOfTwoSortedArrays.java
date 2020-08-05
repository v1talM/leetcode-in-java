//给定两个大小为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。 
//
// 请你找出这两个正序数组的中位数，并且要求算法的时间复杂度为 O(log(m + n))。 
//
// 你可以假设 nums1 和 nums2 不会同时为空。 
//
// 
//
// 示例 1: 
//
// nums1 = [1, 3]
//nums2 = [2]
//
//则中位数是 2.0
// 
//
// 示例 2: 
//
// nums1 = [1, 2]
//nums2 = [3, 4]
//
//则中位数是 (2 + 3)/2 = 2.5
// 
// Related Topics 数组 二分查找 分治算法 
// 👍 3017 👎 0

package main.java.com.qiuyu.leetcode.leetcode.editor.cn;

import java.util.Arrays;

public class MedianOfTwoSortedArrays{
  public static void main(String[] args) {
       Solution solution = new MedianOfTwoSortedArrays().new Solution();
  }
  //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        double mid = 0;
        if (nums1.length > 0 && nums2.length > 0) {
            int l1 = nums1.length;
            int l2 = nums2.length;
            int[] total = new int[l1 + l2];
            int i = 0, j = 0, k = 0;
            while (i < nums1.length && j < nums2.length) {
                if (nums1[i] < nums2[j]) {
                    total[k++] = nums1[i];
                    i++;
                } else {
                    total[k++] = nums2[j];
                    j++;
                }
            }
            while (i < nums1.length) {
                total[k++] = nums1[i++];
            }
            while (j < nums2.length) {
                total[k++] = nums2[j++];
            }
            if (total.length % 2 == 1) {
                mid = total[total.length / 2];
            } else {
                int left = total.length / 2 - 1;
                int right = total.length / 2;
                mid = (double) (total[left] + total[right]) / 2;
            }
        } else {
            if (nums1.length > 0) {
                if (nums1.length % 2 == 1) {
                    mid = (double) nums1[nums1.length / 2];
                } else {
                    mid = (double) (nums1[nums1.length - 1] + nums1[0]) / 2;
                }
            }
            if (nums2.length > 0) {
               if (nums2.length % 2 == 1) {
                   mid = (double) nums2[nums2.length / 2];
               } else {
                   mid = (double) (nums2[nums2.length - 1] + nums2[0]) / 2;
               }
            }
        }
        return mid;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
