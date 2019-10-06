package dynamicProgramming;

public class TestBombEnemy {
    public static void main(String[] args){
        BombEnemy enemy = new BombEnemy();
        char[][] arr = {
                {'0','E','0','0'},
                {'E','0','W','E'},
                {'0','E','0','0'}};
        int result = enemy.maxKilledEnemies(arr);
        System.out.println(result);
    }
}
