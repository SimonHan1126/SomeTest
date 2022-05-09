package leetcodeNZ.tags.linkedlist.easy;

import leetcodeNZ.model.ListNode;

public class LinkedList_1290_Convert_Binary_Number_in_a_Linked_List_to_Integer {

    private int dValue = 0;
    private int count = 0;
    private void traversal(ListNode head) {
        if (head == null) return;
        traversal(head.next);
        int temp = 1;
        for (int i = 0; i < count; i++) {
            temp *= 2 * head.val;
        }
        dValue += temp * head.val;
        count++;
    }

    public int getDecimalValue(ListNode head) {
        traversal(head);
        return dValue;
    }

    public static void main(String[] args) {

//        int[] array = {1, 0, 1};
//        int[] array = {1, 1, 1};
//        int[] array = {0};
        int[] array = {1, 0, 1, 1};
//        int[] array = {1,2,3};
        ListNode node = ListNode.insertNode(array);
        LinkedList_1290_Convert_Binary_Number_in_a_Linked_List_to_Integer object = new LinkedList_1290_Convert_Binary_Number_in_a_Linked_List_to_Integer();
        System.out.println(object.getDecimalValue(node));
    }
}
