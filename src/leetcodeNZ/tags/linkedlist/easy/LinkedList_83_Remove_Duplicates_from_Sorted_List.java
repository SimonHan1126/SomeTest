package leetcodeNZ.tags.linkedlist.easy;

import leetcodeNZ.model.ListNode;

public class LinkedList_83_Remove_Duplicates_from_Sorted_List {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) return null;
        ListNode next = deleteDuplicates(head.next);
        if (next != null && head.val == next.val) head.next = next.next;
        return head;
    }

    public static void main(String[] args) {
//        int[] array = {1,1,1,2,2,3,3,3};
        int[] array = {5,1,1};
//        int[] array = {7,7,7,7,7};
        ListNode node = ListNode.insertNode(array);
        LinkedList_83_Remove_Duplicates_from_Sorted_List object = new LinkedList_83_Remove_Duplicates_from_Sorted_List();
        ListNode.printLinedList(node, "original node");
        ListNode newNode = object.deleteDuplicates(node);
        System.out.println("**------------------------------**");
        ListNode.printLinedList(newNode, "newNode");
    }
}
