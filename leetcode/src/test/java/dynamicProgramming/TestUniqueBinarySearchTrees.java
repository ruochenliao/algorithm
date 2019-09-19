package dynamicProgramming;

public class TestUniqueBinarySearchTrees {
    public static void main(String[] args){
        UniqueBinarySearchTree binarySearchTree = new UniqueBinarySearchTree();
        int cnt = binarySearchTree.numTrees(3);
        System.out.println(cnt);
    }
}
