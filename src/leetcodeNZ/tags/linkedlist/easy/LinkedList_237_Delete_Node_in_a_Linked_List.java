package leetcodeNZ.tags.linkedlist.easy;

import leetcodeNZ.model.ListNode;

public class LinkedList_237_Delete_Node_in_a_Linked_List { // this is not a good question :)
    public void deleteNode(ListNode node) {

    }

    public static void main(String[] args) {
        int[] array = {1,2,3,4,5};
        ListNode node = ListNode.insertNode(array);

        ListNode tempNode = node;
        while (tempNode != null) {
            if (tempNode.val == 3) {
//                if (tempNode.next )
            }
            tempNode = tempNode.next;
        }


        LinkedList_237_Delete_Node_in_a_Linked_List object = new LinkedList_237_Delete_Node_in_a_Linked_List();
        object.deleteNode(node);
    }
}
