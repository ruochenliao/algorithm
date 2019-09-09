package dynamicProgramming;

public class TestEditDistance {
    public static void main(String[] args){
        EditDistance editDistance = new EditDistance();
        int result = editDistance.minDistance("a", "b");
        System.out.println(result);
    }
}
