package leetcodeNZ.Array;

/**
 * @author Simon-the-coder
 * @date 4/10/20 12:44 pm
 * @TO_DO
 */

import java.text.DecimalFormat;
import java.util.LinkedList;

/**
 * Given two sorted arrays nums1 and nums2 of size m and n respectively, return the median of the two sorted arrays.
 *
 * Follow up: The overall run time complexity should be O(log (m+n)).
 *
 *
 *
 * Example 1:
 *
 * Input: nums1 = [1,3], nums2 = [2]
 * Output: 2.00000
 * Explanation: merged array = [1,2,3] and median is 2.
 *
 * Example 2:
 *
 * Input: nums1 = [1,2], nums2 = [3,4]
 * Output: 2.50000
 * Explanation: merged array = [1,2,3,4] and median is (2 + 3) / 2 = 2.5.
 *
 * Example 3:
 *
 * Input: nums1 = [0,0], nums2 = [0,0]
 * Output: 0.00000
 *
 * Example 4:
 *
 * Input: nums1 = [], nums2 = [1]
 * Output: 1.00000
 *
 * Example 5:
 *
 * Input: nums1 = [2], nums2 = []
 * Output: 2.00000
 *
 *
 * Constraints:
 *
 * nums1.length == m
 * nums2.length == n
 * 0 <= m <= 1000
 * 0 <= n <= 1000
 * 1 <= m + n <= 2000
 * -1000000 <= nums1[i], nums2[i] <= 1000000
 */
public class Hard_4_Median_of_Two_Sorted_Arrays {

    private double doubleFormat(double d) {
        DecimalFormat df = new DecimalFormat("#.##");
        return Double.valueOf(df.format(d));
    }

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        double result = 0;
        if (nums1 == null) {
            nums1 = new int[0];
        }
        if (nums2 == null) {
            nums2 = new int[0];
        }
        int length1 = nums1.length;
        int length2 = nums2.length;

        if (length1 <= 0 && length2 <= 0) {
            return doubleFormat(0);
        }

        LinkedList<String> list = new LinkedList();
        list.remove();

        return result;
    }


}
