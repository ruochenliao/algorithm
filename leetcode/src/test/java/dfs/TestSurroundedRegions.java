package dfs;

public class TestSurroundedRegions {
    public static void main(String[] args){
        SurroundedRegions regions = new SurroundedRegions();
        char[][] arr = {
                {'X','X','X','X'},
                {'X','O','O','X'},
                {'X','X','O','X'},
                {'X','O','X','X'}
        };
        char[][] arr1= {
                {'O'}
        };
        regions.solve(arr1);
        for(int i = 0; i < arr1.length; i++){
            for(int j = 0; j < arr1[0].length; j++){
                System.out.print(arr1[i][j] +", ");
            }
            System.out.println();
        }
    }
}
