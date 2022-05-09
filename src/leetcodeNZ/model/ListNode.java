package leetcodeNZ.model;

public class ListNode {
    public int val;
    public ListNode next;

    public ListNode(int x) {
        val = x;
    }

    public static void printLinedList(ListNode node, String tag) {
        ListNode tempNewHead = node;
        System.out.print(tag + ": ");
        while (tempNewHead != null) {
            System.out.print(tempNewHead.val + " -> ");
            tempNewHead = tempNewHead.next;
        }
        System.out.print("null");
        System.out.println();
    }

    public static ListNode insertNode(int[] arr)
    {
        if(arr == null || arr.length <= 0)
        {
            return null;
        }

        ListNode node = null;
        ListNode tempNode = null;
        for(int i : arr)
        {
            if(node == null)
            {
                node = new ListNode(i);
            }
            else
            {
                tempNode = node;
                while (tempNode.next != null)
                {
                    tempNode = tempNode.next;
                }

                tempNode.next = new ListNode(i);
            }
        }

        return node;
    }
}