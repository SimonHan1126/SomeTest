package leetcodeNZ.tags.linkedlist.easy;

import leetcodeNZ.model.ListNode;

public class LinkedList_203_Remove_Linked_List_Elements {



//    public ListNode removeElements(ListNode head, int val) {
//        ListNode newHead = head;
//        while (head != null) {
//            ListNode.printLinedList(head, "current node");
//            if (head.next != null && head.next.val == val) {
//                if (head.next.next != null) {
//                    ListNode.printLinedList(head, "=------111------>");
//                    ListNode newNext = head;
//                    head.next = newNext.next.next;
//                    ListNode.printLinedList(newNext, "=-----2222------->");
////                    head = ;
//                    ListNode.printLinedList(head, "8==============?");
//                } else {
//                    System.out.println("3333333");
//                    head = head.next;
//                }
//            } else if(head.val == val) {
//                System.out.println("4444444");
//                newHead = head.next;
//                head = newHead;
//            } else {
//                System.out.println("555555");
//                head = head.next;
//            }
//        }
//        return newHead;
//    }

//    public ListNode removeElements(ListNode head, int val) {
//        ListNode newHead = head;
//        while (head != null) {
//            if (head.next!=null && head.next.val == val) {
//                ListNode tempNode = head.next.next;
//                head.next = tempNode;
//            } else {
//                head = head.next;
//            }
//        }
//        if(newHead != null && newHead.val == val) {
//            ListNode tempNewHead = newHead.next;
//            newHead = tempNewHead;
//        }
//        return newHead;
//    }

    public ListNode removeElements(ListNode head, int val) {
        if(head == null) return null;
        ListNode next = removeElements(head.next, val);
        if(head.val == val) return next;
        head.next = next;
        return head;
    }

    public static void main(String[] args) {
        int[] array = {1,2,3,4,5,4};
//        int[] array = {7,7,7,7,7};
        ListNode node = ListNode.insertNode(array);
        LinkedList_203_Remove_Linked_List_Elements object = new LinkedList_203_Remove_Linked_List_Elements();
        ListNode.printLinedList(node, "original node");
        ListNode newNode = object.removeElements(node, 4);
        System.out.println("**------------------------------**");
        ListNode.printLinedList(newNode, "newNode");
    }
}
