package greedy;

public class Candy {
    public int candy(int[] ratings) {
        if (ratings.length == 0) return 0;
        int ret = 1;
        int up = 0, down = 0;
        int candyGet = 1;
        for (int i = 1; i < ratings.length; i++) {
            if (ratings[i - 1] < ratings[i]) {
                down = 0;
                candyGet = 1 + up;
                ret += 1 + up;
            } else if (ratings[i - 1] == ratings[i])  {
                ret += 1;
                candyGet = 1;
            } else {
                up = 0;
                down++;
                ret += down;
                if(candyGet == 1){
                    ret++;
                }
                candyGet = ret;
            }
        }
        return ret;
    }
}
