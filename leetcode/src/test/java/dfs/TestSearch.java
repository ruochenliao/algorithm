package dfs;

import Utils.Node;

import java.util.*;

public class TestSearch {
    public static void main(String[] args){
        System.out.println("1 -  2  - 4");
        System.out.println("|         |");
        System.out.println("3 ------- 5");
        System.out.println();
        Search search = new Search();
        Node node1 = new Node();
        Node node2 = new Node();
        Node node3 = new Node();
        Node node4 = new Node();
        Node node5 = new Node();
        node1.val = 1;
        node2.val = 2;
        node3.val = 3;
        node4.val = 4;
        node5.val = 5;
        List<Node> neightbor1 = new ArrayList<>();
        List<Node> neightbor2 = new ArrayList<>();
        List<Node> neightbor3 = new ArrayList<>();
        List<Node> neightbor4 = new ArrayList<>();
        List<Node> neightbor5 = new ArrayList<>();
        neightbor1.add(node2);neightbor1.add(node3);
        neightbor2.add(node1);neightbor2.add(node4);
        neightbor3.add(node1);neightbor3.add(node5);
        neightbor4.add(node2);neightbor4.add(node5);
        neightbor5.add(node3);neightbor5.add(node4);
        node1.neighbors = neightbor1;
        node2.neighbors = neightbor2;
        node3.neighbors = neightbor3;
        node4.neighbors = neightbor4;
        node5.neighbors = neightbor5;

        System.out.println("bfs: 打印顺序");
        search.bfs(node1);
        System.out.println();

        System.out.println("dfs: 打印书序");
        Node[] nodes = {node1, node2, node3, node4, node5};
        search.dfs(nodes);
        List<Node> nodeList = Arrays.asList(nodes);
        nodeList.sort(Comparator.comparingInt(x -> x.finishTime));
        for(Node node:nodeList){
            System.out.print(node.val + ", ");
        }

        System.out.println("topology sort:");
        Node[] nodes1 = {node1, node2, node3, node4, node5};
        search.topologySort(nodes1);
        System.out.println();
    }
}
