package dfs;
import dfs.CloneGraph.*;

import java.util.ArrayList;

public class TestCloneGraph {
    public static void main(String[] args){
        CloneGraph graph = new CloneGraph();
        Node node1 = new Node(1, new ArrayList<>());
        Node node2 = new Node(2, new ArrayList<>());
        Node node3 = new Node(3, new ArrayList<>());
        Node node4 = new Node(4, new ArrayList<>());

        node1.neighbors.add(node2);node1.neighbors.add(node4);
        node2.neighbors.add(node1);node2.neighbors.add(node3);
        node3.neighbors.add(node2);node3.neighbors.add(node4);
        node4.neighbors.add(node1);node4.neighbors.add(node3);
        Node clonedNode = graph.cloneGraph(node1);
        System.out.println(clonedNode.val);
    }
}
