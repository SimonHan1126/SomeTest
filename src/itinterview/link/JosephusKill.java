package itinterview.link;

/**
 * @author hanshihui
 *         Created by hanshihui on 2017/12/12.
 */
public class JosephusKill {
    public Node josephusKill1(Node head, int m) {
        if (head == null || head.next == head || m < 1) {
            return head;
        }
        Node last = head;
        while (last.next != head) {
            last = last.next;
        }
        int count = 0;
        while (head != last) {
            if (++count % m == 0) {
                System.out.print("kill " + last.next.value );
                last.next = head.next;
            } else {
                last = last.next;
                System.out.print(" " + last.value + " say " + (count % m));
            }
            System.out.println();
            System.out.println("-----------------------------------------------------------count " + count);
            head = last.next;
        }
        return head;
    }

    public static void main(String[] args) {
        Node[] nodes = new Node[41];
        for (int i = 0; i <nodes.length ; i++) {
            nodes[i] = new Node(i + 1);
        }
        for (int i = 0; i <nodes.length ; i++) {
            if(i < (nodes.length - 1))
            {
                nodes[i].next = nodes[i + 1];
            }
        }
        nodes[nodes.length - 1].next = nodes[0];
        JosephusKill j = new JosephusKill();
        Node survivor = j.josephusKill1(nodes[0],3);
        System.out.println("survivor " + survivor.value);
    }
}

class Node {
    public int value;
    public Node next;
    public Node(int data) {
        this.value = data;
    }
}
