# Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
#
# An input string is valid if:
#
# Open brackets must be closed by the same type of brackets.
# Open brackets must be closed in the correct order.
# Note that an empty string is also considered valid.
#
# Example 1:
#
# Input: "()"
# Output: true
# Example 2:
#
# Input: "()[]{}"
# Output: true
# Example 3:
#
# Input: "(]"
# Output: false
# Example 4:
#
# Input: "([)]"
# Output: false
# Example 5:
#
# Input: "{[]}"
# Output: true


class Solution:
    def isValid(self, s: str) -> bool:
        while True:
            isContainRoundBracket = s.find("()") >= 0
            if isContainRoundBracket:
                s = s.replace("()", "")

            isContainCurlyBracket = s.find("{}") >= 0
            if isContainCurlyBracket:
                s = s.replace("{}", "")
            
            isContainSquareBracket = s.find("[]") >= 0
            if isContainSquareBracket:
                s = s.replace("[]", "")
            
            if not isContainRoundBracket and not isContainCurlyBracket and not isContainSquareBracket:
                break

        if len(s) > 0:
            return False
        else:
            return True

s = Solution()
s.isValid("()")
s.isValid("()[]{}")
s.isValid("(]")
s.isValid("([)]")
s.isValid("{[]}")
