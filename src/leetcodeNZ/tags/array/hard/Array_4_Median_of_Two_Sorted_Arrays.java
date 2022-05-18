package leetcodeNZ.tags.array.hard;

/**
 * @author Simon-the-coder
 * @date 4/10/20 12:44 pm
 * @TO_DO
 */

import java.lang.reflect.Array;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

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
public class Array_4_Median_of_Two_Sorted_Arrays {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        double result = 0;
        List list = new ArrayList<>();
        int num1Length = nums1.length;
        int num2Length = nums2.length;
        if (num1Length == 0) Collections.addAll(list, nums2);
        if (num2Length == 0) Collections.addAll(list, nums1);
        if (num1Length > 0 && num2Length > 0) {
            for (int i = 0; i < num1Length; i++) {
                int tempNum1Item = nums1[i];
                boolean isInsert = false;
                for (int j = 0; j < num2Length; j++) {
                    int tempNum2Item = nums2[j];
                    if (tempNum2Item < tempNum1Item) {

                    }
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int num1[] = {1, 2};
        int num2[] = {3, 4};
        Array_4_Median_of_Two_Sorted_Arrays object = new Array_4_Median_of_Two_Sorted_Arrays();
        System.out.println(object.findMedianSortedArrays(num1, num2));
    }
}
