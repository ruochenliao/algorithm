package Utils;

import java.util.List;

public class Node {
    public int val;
    public List<Node> neighbors;
    public int discoverTime;
    public int finishTime;

    public Node() {}

    public Node(int _val,List<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
};