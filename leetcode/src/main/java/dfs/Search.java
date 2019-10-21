package dfs;

import Utils.Node;

import java.util.*;

public class Search {
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
}
