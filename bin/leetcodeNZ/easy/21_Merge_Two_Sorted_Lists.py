# Merge two sorted linked lists and return it as a new list. The new list should be made by splicing together the nodes of the first two lists.

# Example:

# Input: 1 -> 2 -> 4, 1 -> 3 -> 4
# Output: 1 -> 1 -> 2 -> 3 -> 4 -> 4


# Definition for singly-linked list.
class ListNode:
    def __init__(self, x):
        self.val = x
        self.next = None


class Solution:
    def mergeTwoLists(self, l1: ListNode, l2: ListNode) -> ListNode:
        if not l1 and not l2:
            return None

        if not l1:
            return l2

        if not l2:
            return l1

        head = mergedNode = ListNode(0)
        while mergedNode is not None:
            if l1 is None:
                mergedNode.next = l2
                return head.next
            if l2 is None:
                mergedNode.next = l1
                return head.next
            val1 = l1.val
            val2 = l2.val
            if val1 < val2:
                newNode = ListNode(val1)
                l1 = l1.next
            else:
                newNode = ListNode(val2)
                l2 = l2.next
            mergedNode.next = newNode
            mergedNode = mergedNode.next

node1 = ListNode(4)
node2 = ListNode(2)
node2.next = node1
node3 = ListNode(1)
node3.next = node2

nodeA = ListNode(4)
nodeB = ListNode(3)
nodeB.next = nodeA
nodeC = ListNode(1)
nodeC.next = nodeB

s = Solution()
print("---------------------BEGIN------------ ")
resultNode = s.mergeTwoLists(node3, nodeC)

while resultNode is not None:
    print(resultNode.val)
    resultNode = resultNode.next

print("---------------------END------------ ")
