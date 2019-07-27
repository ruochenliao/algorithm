package greedy;

import greedy.Candy;

public class TestCandy {
    public static void main(String[] args){
        Candy candy = new Candy();
        int arr[] = {1,2,87,87,87,2,1};
        int candyNum = candy.candy(arr);
        System.out.println(candyNum);
    }
}
