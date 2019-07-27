package greedy;

import greedy.QueueReconstructByHeight;

public class TestQueueReconstructByHeight {
    public static void main(String[] args){
        int[][] arr = {{5,0}, {7,0}, {5,2}, {6,1}, {4,4}, {7,1}};
        QueueReconstructByHeight height = new QueueReconstructByHeight();
        int[][] result = height.reconstructQueue(arr);
        System.out.println(result);
    }
}
