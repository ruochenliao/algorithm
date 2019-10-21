package dfs;

import Utils.TreeNode;
import Utils.TreeUtils;

public class TestSearchBfs {
    public static void main(String[] args){
        SearchBst bfs = new SearchBst();
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
         * 删除一个节点
         */
        System.out.println("删除一个 child");
        TreeNode removeNode = bfs.deleteNode(root, root.left.left.left);
        TreeUtils.printTree(removeNode);
        TreeNode removeNode1 = bfs.deleteNode(root, root.right.right.right);
        TreeUtils.printTree(removeNode1);
        System.out.println("删除包含两个 child, 并且右孩子是叶子节点");
        TreeNode removeNode2 = bfs.deleteNode(root, root.right);
        TreeUtils.printTree(removeNode2);
        TreeUtils.printTree(removeNode2);
        bfs.deleteNode(root,root);
        TreeUtils.printTree(root);
        System.out.println("删除包含两个 child");
        removeNode2.right.left = new TreeNode(10);
        removeNode2.right.left.parent = removeNode2.right;
        removeNode2.right.left.right = new TreeNode(20);
        removeNode2.right.left.right.parent = removeNode2.right.left;
        TreeUtils.printTree(removeNode2);
        TreeNode removeNode3 =bfs.deleteNode(root,root);
        TreeUtils.printTree(removeNode3);
    }
}
