package dfs;

import Utils.Node;

import java.util.*;

public class Search {
    /**
     * bread first search
     * 用 set 保证不会绕回来
     * @param node
     */
    public void bfs(Node node){
        Queue<Node> q = new LinkedList<>();
        Set<Node> set = new HashSet<>();
        q.offer(node);
        set.add(node);
        while(!q.isEmpty()){
            Node n = q.poll();
            System.out.print(n.val + ", ");
            for(Node neightbor: n.neighbors){
                if(!set.contains(neightbor)){
                    set.add(neightbor);
                    q.offer(neightbor);
                }
            }
        }
    }

    int time = 0;
    public void dfs(Node[] nodes){
        Set<Node> set = new HashSet<>();
        for(Node node:nodes){
            dfs(node, set);
        }
    }

    void dfs(Node node, Set<Node> set){
        if(set.contains(node)){
            return;
        }
        node.discoverTime = ++time;
        set.add(node);
        for(Node n:node.neighbors){
            dfs(n, set);
        }
        node.finishTime = ++time;
    }

    void topologySort(Node[] nodes){
        dfs(nodes);
        List<Node> nodeList = Arrays.asList(nodes);
        nodeList.sort((x, y) -> y.finishTime - x.finishTime);
        for(Node node:nodeList){
            System.out.print(node.val + ",");
        }
    }
}
