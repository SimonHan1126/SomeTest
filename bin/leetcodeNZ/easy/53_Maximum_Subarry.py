# https: // leetcode.com/problems/maximum-subarray/

# Given an integer array nums, find the contiguous subarray(containing at least one number) which has the largest sum and return its sum.

# Example:

# Input: [-2, 1, -3, 4, -1, 2, 1, -5, 4],
# Output: 6
# Explanation: [4, -1, 2, 1] has the largest sum = 6.
# Follow up:

# If you have figured out the O(n) solution, try coding another solution using the divide and conquer approach,
# which is more subtle.

from typing import List


class Solution:
    def maxSubArray(self, nums: List[int]) -> int:
        listLen = len(nums)
        if listLen <= 0:
            return 0
        max_current = max_global = nums[0]
        index = 1
        while index < listLen:
            max_current = max(nums[index], nums[index] + max_current)
            max_global = max(max_current, max_global)
            index += 1
        return max_global


s = Solution()
print(s.maxSubArray([-2, 1, -3, 4, -1, 2, 1, -5, 4]))
