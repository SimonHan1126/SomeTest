package leetcodeNZ.medium;

/**
 * Created by hanshihui on 16/01/19.
 *
 You are given two non-empty linked lists representing two non-negative integers. The digits are stored in

 reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.

 You may assume the two numbers do not contain any leading zero, except the number 0 itself.

 Example:

 Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 Output: 7 -> 0 -> 8
 Explanation: 342 + 465 = 807.
 */

class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
}

class Medium_2_Add_Two_Numbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        String str1 = "";
        String str2 = "";

        while (l1 != null)
        {
            str1 += l1.val;
            l1 = l1.next;
        }

        while (l2 != null)
        {
            str2 += l2.val;
            l2 = l2.next;
        }
        
        str2 = String.valueOf(Integer.parseInt(str1) + Integer.parseInt(str2));

        ListNode node = null;
        int strLength = str2.length();
        for (int i = 0; i < strLength; i++)
        {
            String singleNum = str2.substring(strLength -1 - i, strLength - i);
            Integer curVal = Integer.parseInt(singleNum);
            if(node == null)
            {
                node = new ListNode(curVal);
            }
            else
            {
                ListNode tempNode = node;
                while (tempNode.next != null)
                {
                    tempNode = node.next;
                }

                tempNode.next = new ListNode(curVal);
            }
        }
        return node;
    }

    private ListNode insertNode(int[] arr)
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

    public static void main(String[] args) {

//        int[] array1 = {2,4,3};
//        int[] array2 = {5,6,4};
        int[] array1 = {1,8};
        int[] array2 = {0};
        Medium_2_Add_Two_Numbers m = new Medium_2_Add_Two_Numbers();
        ListNode node2 = m.insertNode(array1);

        ListNode node5 = m.insertNode(array2);

        ListNode resultNode = m.addTwoNumbers(node2,node5);

        while (resultNode != null)
        {
            System.out.println(resultNode.val);
            resultNode = resultNode.next;
        }
    }
}
