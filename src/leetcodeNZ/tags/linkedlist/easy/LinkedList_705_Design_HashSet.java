package leetcodeNZ.tags.linkedlist.easy;

import leetcodeNZ.model.ListNode;

public class LinkedList_705_Design_HashSet {



    public LinkedList_705_Design_HashSet() { }

    private ListNode node;
    public void add(int key) {
        if (node == null) node = new ListNode(key);
        else {
            ListNode tempNode = node;
            tempNode.next = new ListNode(key);
            node = tempNode;
        }
    }

    private ListNode removeElement(ListNode head, int val) {
        if(head == null) return null;
        ListNode next = removeElement(head.next, val);
        if(head.val == val) return next;
        head.next = next;
        return head;
    }

    public void remove(int key) {
        if (node == null) return;
        node = removeElement(node, key);
    }

    public boolean contains(int key) {
        ListNode tempNode = node;
        while (tempNode != null) {
            if (tempNode.val == key) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        LinkedList_705_Design_HashSet obj = new LinkedList_705_Design_HashSet();
        obj.add(1);
        boolean param_3 = obj.contains(1);
        System.out.println(param_3);
        obj.remove(1);
    }
}
