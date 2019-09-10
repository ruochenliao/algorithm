package dynamicProgramming;

public class TestEditDistance {
    public static void main(String[] args){
        EditDistance editDistance = new EditDistance();
        String s1 = "horse";
        String s2 = "ros";
        int result = editDistance.minDistance(s1, s2);
        int result2 = editDistance.minDistanceRecursive(s1, s2);
        System.out.println(result);
        System.out.println(result2);
    }
}
