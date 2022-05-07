package leetcodeNZ.tags.tree.easy;

import java.util.ArrayList;
import java.util.List;

class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};

public class Tree_590_N_ary_Tree_Postorder_Traversal {

    private List<Integer> list = new ArrayList<>();

    private void treePostOrder(Node root) {
        if (root == null) return;
        if (root.children == null) return;
        for (Node node : root.children) {
            treePostOrder(node);
            list.add(node.val);
        }
    }

    public List<Integer> postorder(Node root) {
        treePostOrder(root);
        if (root != null) list.add(root.val);
        return list;
    }

    public static void main(String[] args) {

        Node treeNode14 = new Node(14, new ArrayList<>());
        Node treeNode13 = new Node(13, new ArrayList<>());
        Node treeNode12 = new Node(12, new ArrayList<>());
        List<Node> treeChildren11 = new ArrayList<>();
        treeChildren11.add(treeNode14);
        Node treeNode11 = new Node(11, treeChildren11);
        Node treeNode10 = new Node(10, new ArrayList<>());
        List<Node> treeChildren9 = new ArrayList<>();
        treeChildren9.add(treeNode13);
        Node treeNode9 = new Node(9, treeChildren9);
        List<Node> treeChildren8 = new ArrayList<>();
        treeChildren8.add(treeNode12);
        Node treeNode8 = new Node(8, treeChildren8);
        List<Node> treeChildren7 = new ArrayList<>();
        treeChildren7.add(treeNode11);
        Node treeNode7 = new Node(7, treeChildren7);
        Node treeNode6 = new Node(6, new ArrayList<>());
        List<Node> treeChildren5 = new ArrayList<>();
        treeChildren5.add(treeNode9);
        treeChildren5.add(treeNode10);
        Node treeNode5 = new Node(5, treeChildren5);
        List<Node> treeChildren4 = new ArrayList<>();
        treeChildren4.add(treeNode8);
        Node treeNode4 = new Node(4, treeChildren4);
        List<Node> treeChildren3 = new ArrayList<>();
        treeChildren3.add(treeNode6);
        treeChildren3.add(treeNode7);
        Node treeNode3 = new Node(3, treeChildren3);
        Node treeNode2 = new Node(2, new ArrayList<>());
        List<Node> treeChildren1 = new ArrayList<>();
        treeChildren1.add(treeNode2);
        treeChildren1.add(treeNode3);
        treeChildren1.add(treeNode4);
        treeChildren1.add(treeNode5);
        Node treeNode1 = new Node(1, treeChildren1);

        Tree_590_N_ary_Tree_Postorder_Traversal object = new Tree_590_N_ary_Tree_Postorder_Traversal();
        System.out.println(object.postorder(treeNode1));
    }
}
