package leetcodeNZ.tags.linkedlist.easy;

import java.util.ArrayList;
import java.util.List;

import leetcodeNZ.model.ListNode;

public class LinkedList_206_Reverse_Linked_List {

//    public ListNode reverseList(ListNode head) {
//        List<ListNode> list = new ArrayList<>();
//        ListNode tempNode = head;
//        while (tempNode != null) {
//            ListNode curNode = tempNode;
//            tempNode = tempNode.next;
//            curNode.next = null;
//            list.add(curNode);
//        }
//        if (list.isEmpty()) return null;
//        else {
//            ListNode newNode = list.get(list.size() - 1);
//            tempNode = newNode;
//            for (int i = list.size() - 2; i >= 0; i--) {
//                newNode.next = list.get(i);
//                newNode = newNode.next;
//            }
//            return tempNode;
//        }
//    }

    private ListNode reverseListInt(ListNode head, ListNode newHead) {
        ListNode.printLinedList(newHead, "new head");
        if (head == null)
            return newHead;
        ListNode.printLinedList(head, "head");
        ListNode next = head.next;
        head.next = newHead;
        return reverseListInt(next, head);
    }

    public ListNode reverseList(ListNode head) {
        /* recursive solution */
        return reverseListInt(head, null);
    }

    public static void main(String[] args) {
        int[] array = {1,2,3,4,5};
        ListNode node = ListNode.insertNode(array);
        LinkedList_206_Reverse_Linked_List object = new LinkedList_206_Reverse_Linked_List();
        ListNode.printLinedList(node, "original node");
        ListNode reverseNode = object.reverseList(node);
        System.out.println("**------------------------------**");
        ListNode.printLinedList(reverseNode, "reversed node");
    }
}
