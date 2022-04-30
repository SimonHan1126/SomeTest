# Write a function to find the longest common prefix string amongst an array of strings.
#
# If there is no common prefix, return an empty string "".
#
# Example 1:
#
# Input: ["flower","flow","flight"]
# Output: "fl"
# Example 2:
#
# Input: ["dog","racecar","car"]
# Output: ""
# Explanation: There is no common prefix among the input strings.
# Note:
#
# All given inputs are in lowercase letters a-z.


from typing import List


# def getCommonPrefixFromTwoStrs(str_one, str_two) -> str:
#     commonPrefix = ""
#     str_one_len = len(str_one)
#     str_two_len = len(str_two)
#
#     index = 0
#     if str_one_len > str_two_len:
#         loopStr = str_two
#         compareStr = str_one
#         shorter_len = str_two_len
#     else:
#         loopStr = str_one
#         compareStr = str_two
#         shorter_len = str_one_len
#
#     cursor = 0
#     cursorLen = 1
#     while index <= shorter_len:
#         cursorStr = loopStr[cursor: cursorLen]
#         findIndex = compareStr.find(cursorStr)
#         if findIndex >= 0:
#             cursorLen += 1
#             commonPrefix = cursorStr
#         else:
#             cursor += cursorLen
#         index = cursor + cursorLen
#
#     return commonPrefix

def getCommonPrefixFromTwoStrs(str_one, str_two) -> str:
    commonPrefix = ""
    str_one_len = len(str_one)
    str_two_len = len(str_two)

    if str_one_len <= 0 or str_two_len <= 0 or str_one[0] != str_two[0]:
        print("str_one " + str_one + " str_two " + str_two)
        return ""

    index = 0
    if str_one_len > str_two_len:
        loopStr = str_two
        compareStr = str_one
        shorter_len = str_two_len
    else:
        loopStr = str_one
        compareStr = str_two
        shorter_len = str_one_len

    cursor = 0
    cursorLen = 1
    while index <= shorter_len:
        cursorStr = loopStr[cursor: cursorLen]
        findIndex = compareStr.find(cursorStr)
        if findIndex == 0:
            cursorLen += 1
            commonPrefix = cursorStr
        else:
            cursor += cursorLen
        index = cursor + cursorLen
    return commonPrefix

class Solution:

    def longestCommonPrefix(self, strs: List[str]) -> str:
        listLength = len(strs)
        if listLength <= 0:
            return ""
        if listLength == 1:
            return strs[0]
        commonPrefix = getCommonPrefixFromTwoStrs(strs[0], strs[1])
        print("commonprefix 111 " + commonPrefix + " strs[0] " + strs[0] + " strs[1] " + strs[1])
        index = 2
        while index < listLength:
            itemStr = strs[index]
            print("commonprefix 2222 commonPrefix " + commonPrefix + " itemStr " + itemStr)
            commonPrefix = getCommonPrefixFromTwoStrs(commonPrefix, itemStr)
            print("commonprefix 33333 " + commonPrefix)
            index += 1
        return commonPrefix



s = Solution()
print(s.longestCommonPrefix(["flower", "flow", "flight"]))
print(s.longestCommonPrefix(["ca", "a"]))
print(s.longestCommonPrefix(["abca","aba","aaab"]))

