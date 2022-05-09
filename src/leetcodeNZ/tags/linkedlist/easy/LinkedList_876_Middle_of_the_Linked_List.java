package leetcodeNZ.tags.linkedlist.easy;

import leetcodeNZ.model.ListNode;

public class LinkedList_876_Middle_of_the_Linked_List {

    public ListNode middleNode(ListNode head) {
        if (head!= null && head.next == null) return head;
        ListNode tempNode = null;
        ListNode copiedHead = head;
        double loopedIndex = 0, middleIndex, tempIndex = 0;
        while (head != null) {
            loopedIndex++;
            middleIndex = loopedIndex % 2 == 1 ? Math.floor(loopedIndex / 2) : Math.ceil(loopedIndex / 2);
            if (tempIndex != middleIndex && copiedHead != null) {
                tempNode = copiedHead.next;
                copiedHead = tempNode;
                tempIndex = middleIndex;
            }
            head = head.next;
        }
        return tempNode;
    }

    public static void main(String[] args) {
        int[] array = {1,2,3,4,5};
        ListNode node = ListNode.insertNode(array);
        LinkedList_876_Middle_of_the_Linked_List object = new LinkedList_876_Middle_of_the_Linked_List();
        ListNode middleNode = object.middleNode(node);
        System.out.println("**------------------------------**");
        while (middleNode != null) {
            System.out.println(middleNode.val);
            middleNode = middleNode.next;
        }
    }
}
