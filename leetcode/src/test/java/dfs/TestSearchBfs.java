package dfs;

import Utils.TreeNode;
import Utils.TreeUtils;

public class TestSearchBfs {
    public static void main(String[] args){
        SearchBfs bfs = new SearchBfs();
        /**
         * 构建 bsf
         */
        TreeNode root = TreeUtils.createTree(new Integer[]{4,2,6,1,3,5,7});
        root.left.parent = root;
        root.right.parent = root;
        root.left.left.parent = root.left;
        root.left.right.parent = root.left;
        root.right.right.parent = root.right;
        root.right.left.parent = root.right;
        TreeUtils.printTree(root);
        /**
         * 顺序打印
         */
        bfs.inorderSearch(root);
        System.out.println();
        /**
         * 查找树的最小值
         */
        TreeNode minimum = bfs.findMinimum(root);
        System.out.println("minimum:"+minimum.val);
        /**
         * 查找最大值
         */
        TreeNode max = bfs.findMax(root);
        System.out.println("max:"+max.val);
        /**
         * 寻找下一个几点, 3 的下一个节点是 4
         */
        TreeNode nextNode = bfs.findNextNode(root.left.right);
        System.out.println("nextNode:"+ nextNode.val);

        /**
         * 新增一个节点
         */
        bfs.insertNode(root, new TreeNode(10));
        TreeNode newRoot =  bfs.insertNode(root, new TreeNode(0));
        System.out.println("增加一个节点");
        TreeUtils.printTree(newRoot);

        /**
         * 替换掉一个节点
         */
        TreeNode newTreeNode = new TreeNode(100);
        newTreeNode.left = new TreeNode(200);
        TreeNode tranplantParentNode = bfs.transplantNodeParent(root, root.left.left.left, newTreeNode);
        System.out.println("交换节点");
        TreeUtils.printTree(tranplantParentNode);
    }
}
