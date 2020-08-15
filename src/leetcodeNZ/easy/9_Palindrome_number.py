# Determine whether an integer is a palindrome. An integer is a palindrome when it reads the same backward as forward.
#
# Example 1:
#
# Input: 121
# Output: true
# Example 2:
#
# Input: -121
# Output: false
# Explanation: From left to right, it reads -121. From right to left, it becomes 121-. Therefore it is not a palindrome.
# Example 3:
#
# Input: 10
# Output: false
# Explanation: Reads 01 from right to left. Therefore it is not a palindrome.

class Solution:
    def isPalindrome(self, num: int) -> bool:
        if num < 0:
            return False
        elif 0 <= num < 10:
            return True
        else:
            originalNum = num
            newNum = 0
            while num > 0:
                newNum *= 10
                newNum += num % 10
                num = int(num / 10)
            return not (originalNum - newNum)


s = Solution()
print(s.isPalindrome(2827282))
