package dynamicProgramming;

public class TestUniquePath {
    public static void main(String[] args){
        UniquePath uniquePath = new UniquePath();
        int result = uniquePath.uniquePaths(3, 2);
        System.out.println(result);
    }
}
