package dfs;

import Utils.TreeNode;

public class SearchBfs {
    public void inorderSearch(TreeNode root){
        if(root == null){
            return;
        }
        inorderSearch(root.left);
        System.out.print(root.val + ",");
        inorderSearch(root.right);
    }

    /**
     * 查询root 下的最小值
     * @param root
     * @return
     */
    public TreeNode findMinimum(TreeNode root){
        while(root != null && root.left != null){
            root = root.left;
        }
        return root;
    }

    /**
     * 查找最大值
     * @param root
     * @return
     */
    public TreeNode findMax(TreeNode root){
        while(root != null && root.right != null){
            root = root.right;
        }
        return root;
    }

    /**
     * 寻找下一个节点
     * @param root
     * @return
     */
    public TreeNode findNextNode(TreeNode root){
        if(root.right != null){
            return findMinimum(root.right);
        }
        //node 节点没有右孩子时，下一个节点是父亲节点中第一个左节点
        TreeNode parent = root.parent;
        while(parent.right == root){
            root = parent;
            parent = root.parent;
        }
        return parent;
    }

    /**
     * 插入一个节点
     * @param root
     * @param node
     * @return 返回根节点
     */
    public TreeNode insertNode(TreeNode root, TreeNode node){
        TreeNode prev = null;
        TreeNode temp = root;
        while(temp!= null){
            prev = temp;
            if(node.val < temp.val){
                temp = temp.left;
            }
            else{
                temp = temp.right;
            }
        }
        node.parent = prev;
        if(prev == null){
            return node;
        }
        else if(node.val < prev.val){
            prev.left = node;
        }
        else{
            prev.right = node;
        }
        return root;
    }

    /**
     * 用 y 把 x 位置顶替掉
     * @param x
     * @param y
     */
    public void transplantNodeParent(TreeNode root,TreeNode x, TreeNode y){
        if(x == null){
            return;
        }
        if(y == null){
            if(x.parent.left == x){
                x.parent.left = null;
            }else{
                x.parent.right = null;
            }
        }
        else{
            x.val = y.val;
        }
    }

    /**
     * 删除节点 node
     * @param root
     * @param node
     * @return
     */
    public TreeNode deleteNode(TreeNode root, TreeNode node){
        if(node == null){
            return null;
        }
        //delete 的这个节点没有children节点
        if(node.left == null && node.right == null){
            transplantNodeParent(root, node, null);
        }
        //delete 的这个节点有一个child节点
        else if(node.right == null){
            transplantNodeParent(root, node, node.left);
        }else{
            TreeNode minimumNode = findMinimum(node.right);
            if(minimumNode == node.right){
                transplantNodeParent(root, node, minimumNode);
                minimumNode.parent.right = null;
            }
            else if(minimumNode.right == null){
                minimumNode.parent.left = null;
                transplantNodeParent(root, node, minimumNode);
            }
            else {
                minimumNode.parent.left = minimumNode.right;
                minimumNode.right.parent = minimumNode.parent;
                transplantNodeParent(root, node, minimumNode);
            }
        }
        return root;
    }
}
