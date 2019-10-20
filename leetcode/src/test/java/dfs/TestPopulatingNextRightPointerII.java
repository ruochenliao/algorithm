package dfs;

public class TestPopulatingNextRightPointerII {
    public static void main(String[] args){
        PopulatingNextRightPointerII pointerII = new PopulatingNextRightPointerII();
        PopulatingNextRightPointerII.Node root = new PopulatingNextRightPointerII.Node(1, null, null,null);
        root.left = new PopulatingNextRightPointerII.Node(2, null, null, null);
        root.right = new PopulatingNextRightPointerII.Node(3, null, null, null);
        root.left.left = new PopulatingNextRightPointerII.Node(4, null, null, null);
        root.left.right = new PopulatingNextRightPointerII.Node(5, null, null, null);
        root.right.left = new PopulatingNextRightPointerII.Node(6, null, null, null);
        root.right.right = new PopulatingNextRightPointerII.Node(7, null, null, null);
        pointerII.connect(root);
    }
}
