package leetcode.easy;

class ListNode {
	int val;
	ListNode next;

	ListNode(int x) {
		val = x;
	}
}

public class MergeTwoLists {
    /*
     * @param l1: ListNode l1 is the head of the linked list
     * @param l2: ListNode l2 is the head of the linked list
     * @return: ListNode head of linked list
     */
	public ListNode mergeTwoLists2(ListNode l1, ListNode l2) 
	{
	      if(l1 == null) return l2;
	      if(l2 == null) return l1;
	      
	      if(l1.val > l2.val)
	      {
	    	  l2.next = mergeTwoLists2(l1, l2.next);
	    	  return l2;
	      }
	      else
	      {
	    	  l1.next = mergeTwoLists2(l1.next, l2);
	    	  return l1;
	      }
    }
	
	public ListNode mergeTwoLists(ListNode l1, ListNode l2) 
	{
		if(l1 == null) return l2;
		if(l2 == null) return l1;
        ListNode newListHead = null; 
		ListNode oldListHead = null;
		if(l1.val > l2.val)
		{
			newListHead = l2;
			oldListHead = l1;
		}
		else
		{
			newListHead = l1;
			oldListHead = l2;
		}
		ListNode tempNewListNode = newListHead;
		ListNode tempOldListNode = oldListHead;
		while(tempOldListNode != null)
    	{
    		while(tempNewListNode != null)
            {
    			if(tempNewListNode.next == null)
    			{
    				tempNewListNode.next = tempOldListNode;
    				return newListHead;
    			}
    			
    			if(tempNewListNode.next != null && tempOldListNode.val > tempNewListNode.val && tempOldListNode.val > tempNewListNode.next.val)
    			{
    				tempNewListNode = tempNewListNode.next;
    				continue;
    			}
    			
    			if(tempNewListNode.next != null && tempOldListNode.val >= tempNewListNode.val && tempOldListNode.val <= tempNewListNode.next.val)
    			{
    				ListNode nextNode = tempNewListNode.next;
    				ListNode newInsertNode = new ListNode(tempOldListNode.val);
    				newInsertNode.next = nextNode;
    				tempNewListNode.next = newInsertNode;
    				tempNewListNode = newInsertNode;
    			}
    			break;
            }
    		if(tempOldListNode.next != null)
    		{
    			tempOldListNode = tempOldListNode.next;
    		}
    		else
    		{
    			return newListHead;
    		}
    	}
		return newListHead;
	}

	public static void main(String[] args) {
		ListNode l1 = new ListNode(-9);
		ListNode l2 = new ListNode(-7);
		ListNode l3 = new ListNode(-3);
		ListNode l4 = new ListNode(-3);
		ListNode l5 = new ListNode(-1);
		ListNode l6 = new ListNode(2);
		ListNode l7 = new ListNode(3);
		
		l1.next = l2;
		l2.next = l3;
		l3.next = l4;
		l4.next = l5;
		l5.next = l6;
		l6.next = l7;
		
		ListNode list1 = new ListNode(-7);
		ListNode list2 = new ListNode(-7);
		ListNode list3 = new ListNode(-6);
		ListNode list4 = new ListNode(-6);
		ListNode list5 = new ListNode(-5);
		ListNode list6 = new ListNode(-3);
		ListNode list7 = new ListNode(2);
		ListNode list8 = new ListNode(4);
		
		list1.next = list2;
		list2.next = list3;
		list3.next = list4;
		list4.next = list5;
		list5.next = list6;
		list6.next = list7;
		list7.next = list8;
		
		MergeTwoLists mtList = new MergeTwoLists();
		ListNode tempNode = mtList.mergeTwoLists(l1, list1);
		System.out.print("+++++++ " + tempNode.val + " ");
		while (tempNode != null && tempNode.next != null) {
			ListNode currentNode = tempNode.next;
			System.out.print(currentNode.val + " ");
			tempNode = currentNode;
		}
	}	
}



















