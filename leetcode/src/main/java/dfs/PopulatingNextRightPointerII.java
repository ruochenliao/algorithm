package dfs;

public class PopulatingNextRightPointerII {
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
        Node cur = root;
        Node head = null;
        Node prev = null;
        while(cur != null){
            Node node = cur;
            while(node != null){
                if(node.left != null){
                    if(prev != null){
                        prev.next = node.left;
                    }
                    else{
                        head = node.left;
                    }
                    prev = node.left;
                }
                if(node.right != null){
                    if(prev != null){
                        prev.next = node.right;
                    }
                    else{
                        head = node.right;
                    }
                    prev = node.right;
                }
                node = node.next;
            }
            cur = head;
            head = null;
            prev = null;
        }
        return root;
    }
}
