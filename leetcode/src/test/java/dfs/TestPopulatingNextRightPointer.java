package dfs;

public class TestPopulatingNextRightPointer {
    public static void main(String[] args){
        PopulatingNextRightPointer.Node root = new PopulatingNextRightPointer.Node(1, null, null,null);
        root.left = new PopulatingNextRightPointer.Node(2, null, null, null);
        root.right = new PopulatingNextRightPointer.Node(3, null, null, null);
        root.left.left = new PopulatingNextRightPointer.Node(4, null, null, null);
        root.left.right = new PopulatingNextRightPointer.Node(5, null, null, null);
        root.right.left = new PopulatingNextRightPointer.Node(6, null, null, null);
        root.right.right = new PopulatingNextRightPointer.Node(7, null, null, null);

        PopulatingNextRightPointer pointer = new PopulatingNextRightPointer();
        PopulatingNextRightPointer.Node result = pointer.connect(root);
        System.out.println(result.val);
    }
}
