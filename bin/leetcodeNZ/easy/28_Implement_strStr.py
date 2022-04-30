# https://leetcode.com/problems/implement-strstr/

# Implement strStr().

# Return the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.

# Example 1:

# Input: haystack = "hello", needle = "ll"
# Output: 2
# Example 2:

# Input: haystack = "aaaaa", needle = "bba"
# Output: -1
# Clarification:

# What should we return when needle is an empty string? This is a great question to ask during an interview.

# For the purpose of this problem, we will return 0 when needle is an empty string. This is consistent to C's strstr() and Java's indexOf().
      
class Solution:

    def strStr(self, haystack: str, needle: str) -> int:

      haystackLen = len(haystack)
      needleLen = len(needle)

      if haystackLen <= 0 and needleLen <= 0 or needleLen <= 0:
        return 0
      if haystackLen <= 0 or needleLen > haystackLen:
        return -1

      map = {}

      index = 0
      while index < haystackLen - needleLen + 1:
        if haystack[index] == needle[0]:
          map[index] = haystack[index: index + needleLen]
        index += 1

      for key in map:
        if map[key] == needle:
          return key

      return -1

s = Solution()
print(s.strStr("hellolodloeloflkjlkilmnlkjlhf", "ll"))
print(s.strStr("commonmjmkmnmhmjmkmlmnmnmnmvmvm", "mo"))
print(s.strStr("aaaaabhjhbbbhjbghbghbghbvcbvcbvcbvcxbvcxzbfrdbgyh", "bba"))
print(s.strStr("bba", "aaaaa"))
