package leetcodeNZ.medium;

import java.util.Stack;

import leetcodeNZ.model.ListNode;

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

class Medium_2_Add_Two_Numbers {

//    public ListNode addTwoNumbers(ListNode node1, ListNode node2) {
//        long listNodeToInt1 = 0;
//        long listNodeToInt2 = 0;
//        long index = 1;
//        while (node1 != null) {
//            listNodeToInt1 += node1.val * index;
//            node1 = node1.next;
//            index *= 10;
//        }
//        index = 1;
//        while (node2 != null) {
//            listNodeToInt2 += node2.val * index;
//            System.out.println("listNodeToInt2 " + listNodeToInt2 + " node2.val " + node2.val);
//            System.out.println("listNodeToInt2 " + Long.MAX_VALUE + " index " + index + " node2.val * index " + (node2.val * index));
//            node2 = node2.next;
//            index *= 10;
//        }
//
//        long sum = listNodeToInt1 + listNodeToInt2;
//        System.out.println("listNodeToInt1 " + listNodeToInt1);
//        System.out.println("listNodeToInt2 " + listNodeToInt2);
//        System.out.println("sum " + sum);
//        if (sum == 0) return new ListNode(0);
//        ListNode newNode = null;
//        ListNode tempNode;
//        for (long i = sum; i > 0;) {
//            int value = (int) (i % 10);
//            if(newNode == null) {
//                newNode = new ListNode(value);
//            } else {
//                tempNode = newNode;
//                while (tempNode.next != null) {
//                    tempNode = tempNode.next;
//                }
//                tempNode.next = new ListNode(value);
//            }
//            i = i / 10;
//        }
//        return newNode;
//    }

    public ListNode addTwoNumbers(ListNode node1, ListNode node2) {
        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();
        while (node1 != null) {
            stack1.push(node1.val);
            node1 = node1.next;
        }

        while (node2 != null) {
            stack2.push(node2.val);
            node2 = node2.next;
        }
        System.out.println("stack1 " + stack1);
        System.out.println("stack2 " + stack2);
        ListNode newNode = null;
        ListNode tempNode;
        System.out.println("=====================");
        int value1 = 0;
        int value2 = 0;
        while (!stack1.isEmpty() && !stack2.isEmpty()) {

            if (!stack1.isEmpty()) {
                value1 += stack1.pop();
            }
            System.out.println("value1 " + value1);
            if (!stack2.isEmpty()) {
                value2 += stack2.pop();
            }
            System.out.println("value2 " + value2);
            int newNodeValue = value1 + value2;
            if (newNodeValue < 10) {
                value1 = 0;
                value2 = 0;
            } else {
                value1 = 1;
                value2 = 1;
                newNodeValue %= 10;
            }
            System.out.println("newNodeValue " + newNodeValue);
            if(newNode == null) {
                newNode = new ListNode(newNodeValue);
            } else {
                tempNode = newNode;
                while (tempNode.next != null) {
                    tempNode = tempNode.next;
                }
                tempNode.next = new ListNode(newNodeValue);
            }
        }
        return newNode;
    }

    public static void main(String[] args) {

        int[] array1 = {2,4,3};
        int[] array2 = {5,6,4};
//        int[] array1 = {0};
//        int[] array2 = {0};
//        int[] array1 = {5};
//        int[] array2 = {3};
//        int[] array1 = {9,9,9,9,9,9,9};
//        int[] array2 = {9,9,9,9};
//        int[] array1 = {2,4,9};
//        int[] array2 = {5,6,4,9};
//        int[] array1 = {9};
//        int[] array2 = {1,9,9,9,9,9,9,9,9,9};
        Medium_2_Add_Two_Numbers m = new Medium_2_Add_Two_Numbers();
        ListNode node2 = ListNode.insertNode(array1);

        ListNode node5 = ListNode.insertNode(array2);

        ListNode resultNode = m.addTwoNumbers(node2,node5);
        System.out.println("&&&&&&&&&&&&&&&&&");
        while (resultNode != null)
        {
            System.out.print(resultNode.val + " ");
            resultNode = resultNode.next;
        }
    }
}
