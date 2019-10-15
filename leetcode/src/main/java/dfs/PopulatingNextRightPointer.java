package dfs;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class PopulatingNextRightPointer {
    public static class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {}

        public Node(int _val,Node _left,Node _right,Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    };

    public Node connect(Node root) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        Node dummy = root;
        while(!queue.isEmpty()){
            int size = queue.size();
            Node prev = null;
            Queue<Node> tempQueue = new LinkedList<>(queue);
            for(int i = 0; i < size; i++){
                root = queue.remove();
                Node temp = ((LinkedList<Node>) tempQueue).removeLast();
                temp.next = prev;
                prev = temp;
                if(root.left != null){
                    queue.offer(root.left);
                }
                if(root.right != null){
                    queue.offer(root.right);
                }
            }
        }
        return dummy;
    }
}
